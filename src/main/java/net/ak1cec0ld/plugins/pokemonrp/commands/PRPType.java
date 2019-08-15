package net.ak1cec0ld.plugins.pokemonrp.commands;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.files.PlayerFile;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRPType implements TabExecutor {
    private static final Material PAYMENT_METHOD = Material.DIAMOND;
    private static final int PAYMENT_AMOUNT = 10;
    private static final List<String> types = Type.stringValues();

    public PRPType(){
        Pokemon_RP.instance().getServer().getPluginCommand("rptype").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        switch(args.length){
            case 0:
                if(commandSender instanceof Player){
                    for(Type each : PlayerFile.getTypes(((Player)commandSender).getUniqueId().toString())){
                        commandSender.sendMessage(each.toString());
                    }
                }
            case 2:
                if(!(commandSender instanceof Player))return false;
                if(!types.contains(args[1].toUpperCase())){
                    commandSender.sendMessage("Use a valid Pokémon Type!");
                    return false;
                }
                Player player = (Player) commandSender;
                switch(args[0].toLowerCase()){
                    case "set":
                        if(canPay(player)){
                            if(types.contains(args[1].toUpperCase())) {
                                PlayerFile.setType(player.getUniqueId().toString(), Type.valueOf(args[1].toUpperCase()));
                                player.sendMessage("Type set to "+ args[1].toUpperCase());
                                player.getInventory().removeItem(new ItemStack(PAYMENT_METHOD,PAYMENT_AMOUNT));
                                return true;
                            }
                            player.sendMessage("No type found by that name!");
                            return false;
                        }
                        return false;
                    case "add":
                        if(canPay(player)) {
                            if (PlayerFile.getTypes(player.getUniqueId().toString()).size() < 2) {
                                PlayerFile.addType(player.getUniqueId().toString(), Type.valueOf(args[1].toUpperCase()));
                                player.sendMessage(args[1].toUpperCase() + " added!");
                                player.getInventory().removeItem(new ItemStack(PAYMENT_METHOD,PAYMENT_AMOUNT));
                                return true;
                            }
                            player.sendMessage("Maximum of two types allowed!");
                            return false;
                        }
                        return false;
                    case "remove":
                        if(PlayerFile.getTypes(player.getUniqueId().toString()).size() < 2){
                            player.sendMessage("You can't remove your last Type!");
                            return false;
                        }
                        if (PlayerFile.removeType(player.getUniqueId().toString(), Type.valueOf(args[1].toUpperCase()))) {
                            player.sendMessage("Removed " + args[1].toUpperCase());
                            return true;
                        }
                        player.sendMessage("Failed, no type found by that name.");
                        return false;
                    default:
                        commandSender.sendMessage("No valid action received.");
                        return false;
                }
            case 3:
                if(commandSender.isOp()){
                    Player target = getPlayerFromString(args[2]);
                    if(target == null){
                        commandSender.sendMessage("Online Targets Only Please");
                        return false;
                    }
                    if(!types.contains(args[1].toUpperCase())){
                        commandSender.sendMessage("Use a valid Pokémon Type!");
                        return false;
                    }
                    switch(args[0].toLowerCase()) {
                        case "set":
                            if (types.contains(args[1].toUpperCase())) {
                                PlayerFile.setType(target.getUniqueId().toString(), Type.valueOf(args[1].toUpperCase()));
                                commandSender.sendMessage("Type set to " + args[1].toUpperCase());
                                return true;
                            }
                            commandSender.sendMessage("No type found by that name!");
                            return false;
                        case "add":
                            if (PlayerFile.getTypes(target.getUniqueId().toString()).size() < 2) {
                                PlayerFile.addType(target.getUniqueId().toString(), Type.valueOf(args[1].toUpperCase()));
                                commandSender.sendMessage(args[1].toUpperCase() + " added!");
                                return true;
                            }
                            commandSender.sendMessage("Maximum of two types allowed!");
                            return false;
                        case "remove":
                            if (PlayerFile.getTypes(target.getUniqueId().toString()).size() < 2) {
                                commandSender.sendMessage("You can't remove their last Type!");
                                return false;
                            }
                            if (PlayerFile.removeType(target.getUniqueId().toString(), Type.valueOf(args[1].toUpperCase()))) {
                                commandSender.sendMessage("Removed " + args[1].toUpperCase());
                                return true;
                            }
                            commandSender.sendMessage("Failed, no type found by that name.");
                            return false;
                        default:
                            commandSender.sendMessage("No valid action received.");
                            return false;
                    }
                }
                commandSender.sendMessage("Operator Only!");
                return false;
            default:
                commandSender.sendMessage("Use /rp help type");
                return false;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        final List<String> completions = new ArrayList<>();
        switch(args.length){
            case 1:
                final List<String> actions = Arrays.asList("set","add","remove");
                StringUtil.copyPartialMatches(args[0], actions, completions);
                return completions;
            case 2:
                switch(args[0].toLowerCase()){
                    case "set":
                    case "add":
                    case "remove":
                        StringUtil.copyPartialMatches(args[1], types, completions);
                        return completions;
                }
            case 3:
                if(commandSender.isOp()){
                    List<String> finalList = new ArrayList<>();
                    for(Player eachPlayer : Bukkit.getOnlinePlayers()){
                        finalList.add(eachPlayer.getName());
                    }
                    StringUtil.copyPartialMatches(args[2], finalList, completions);
                    return completions;
                }
        }
        return null;
    }
    private boolean canPay(Player player){
        return player.getInventory().containsAtLeast(new ItemStack(PAYMENT_METHOD,1),PAYMENT_AMOUNT) ||
                PlayerFile.getTypes(player.getUniqueId().toString()).isEmpty();
    }
    private Player getPlayerFromString(String input){
        for(Player each : Bukkit.getOnlinePlayers()){
            if(each.getName().startsWith(input)){
                return each;
            }
        }
        return null;
    }
}
