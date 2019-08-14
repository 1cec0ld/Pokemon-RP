package net.ak1cec0ld.plugins.pokemonrp;

import net.ak1cec0ld.plugins.pokemonrp.files.PlayerFile;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
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

public class PRPCommand implements TabExecutor {
    private static final List<String> types = Type.stringValues();
    private static final Material PAYMENT_METHOD = Material.DIAMOND;
    private static final int PAYMENT_AMOUNT = 10;

    PRPCommand(){
        Pokemon_RP.instance().getServer().getPluginCommand("rp").setExecutor(this);
    }


    public boolean onCommand(CommandSender commandSender, Command commandLabel, String s, String[] args) {
        switch(args.length){
            case 0:
                messageHelp(commandSender);
                break;
            case 1:
                if ("reload".equals(args[0].toLowerCase())) {
                    PlayerFile.reload();
                    return true;
                }
                messageHelp(commandSender);
                break;
            case 2:
                Player player;
                switch(args[0].toLowerCase()){
                    case "set":
                        if(!(commandSender instanceof Player))return false;
                        player = (Player) commandSender;
                        if(canPay(player)){
                            if(types.contains(args[1].toUpperCase())) {
                                PlayerFile.setType(player.getUniqueId().toString(), Type.valueOf(args[1].toUpperCase()));
                                player.sendMessage("Type set to "+ args[1].toUpperCase());
                                player.getInventory().removeItem(new ItemStack(PAYMENT_METHOD,PAYMENT_AMOUNT));
                            } else {
                                player.sendMessage("No type found by that name!");
                            }
                        }
                        break;
                    case "add":
                        if(!(commandSender instanceof Player))return false;
                        if(!types.contains(args[1].toUpperCase()))return false;
                        player = (Player)commandSender;
                        if(canPay(player)) {
                            if (PlayerFile.getTypes(player.getUniqueId().toString()).size() < 2) {
                                PlayerFile.addType(player.getUniqueId().toString(), Type.valueOf(args[1].toUpperCase()));
                                player.sendMessage(args[1].toUpperCase() + " added!");
                                player.getInventory().removeItem(new ItemStack(PAYMENT_METHOD,PAYMENT_AMOUNT));
                            } else {
                                player.sendMessage("Maximum of two types allowed!");
                            }
                        }
                        break;
                    case "remove":
                        if(!(commandSender instanceof Player))return false;
                        if(!types.contains(args[1].toUpperCase()))return false;
                        player = (Player)commandSender;
                        if(PlayerFile.getTypes(player.getUniqueId().toString()).size() < 2){
                            player.sendMessage("You can't remove your last Type!");
                        } else {
                            if (PlayerFile.removeType(player.getUniqueId().toString(), Type.valueOf(args[1].toUpperCase()))) {
                                player.sendMessage("Removed " + args[1].toUpperCase());
                            } else {
                                player.sendMessage("Failed, no type found by that name.");
                            }
                        }
                        break;
                    default:
                        commandSender.sendMessage("No valid action received.");
                        break;
                }

                break;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command commandLabel, String s, String[] args) {
        final List<String> completions = new ArrayList<>();
        switch(args.length){
            case 1:
                final List<String> actions = Arrays.asList("help","reload","set","add","remove");
                StringUtil.copyPartialMatches(args[0], actions, completions);
                break;
            case 2:
                switch(args[0].toLowerCase()){
                    case "set":
                    case "add":
                    case "remove":
                        StringUtil.copyPartialMatches(args[1], types, completions);
                        break;
                    default:
                        return completions;
                }
                break;
        }
        return completions;
    }
    private void messageHelp(CommandSender sender){
        sender.sendMessage("Roleplay as a Pokemon with this plugin!");
        sender.sendMessage("/pokemonrp set {type}    will change you to that type of pokemon.");
    }
    private boolean canPay(Player player){
        return player.getInventory().containsAtLeast(new ItemStack(PAYMENT_METHOD,1),PAYMENT_AMOUNT) ||
                PlayerFile.getTypes(player.getUniqueId().toString()).isEmpty();
    }
}
