package net.ak1cec0ld.plugins.pokemonrp.commands;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.files.PlayerFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRP implements TabExecutor {

    public PRP(){
        Pokemon_RP.instance().getServer().getPluginCommand("rp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command commandLabel, String s, String[] args) {
        switch(args.length){
            case 0:
                messageHelp(commandSender, "default");
                break;
            case 1:
                if ("reload".equals(args[0].toLowerCase())) {
                    PlayerFile.reload();
                    return true;
                }
                messageHelp(commandSender,"default");
                break;
            case 2:
                messageHelp(commandSender, args[1].toLowerCase());
                break;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command commandLabel, String s, String[] args) {
        final List<String> completions = new ArrayList<>();
        switch(args.length){
            case 1:
                final List<String> actions = Arrays.asList("help","reload");
                StringUtil.copyPartialMatches(args[0], actions, completions);
                break;
            case 2:
                switch(args[0].toLowerCase()){
                    case "help":
                        final List<String> subCommands = Arrays.asList("pokemon","exp","level");
                        StringUtil.copyPartialMatches(args[1], subCommands, completions);
                        return completions;
                    default:
                        return null;
                }
            default:
                return null;
        }
        return completions;
    }
    private void messageHelp(CommandSender sender, String secondary){
        switch(secondary.toLowerCase()){
            case "pokemon":
                sender.sendMessage("  /pokemon [pokemon name]  will match your type to that Pokémon!");
                break;
            case "exp":
                sender.sendMessage("  /rpexp set {user} {type} {amount}   will set that person, in that type, to that exp value.");
                sender.sendMessage("  /rpexp add {user} {type} {amount}   will add to that person, in that type, that amount of exp.");
                sender.sendMessage("  /rpexp reset {user} {type} {amount} will set that person, in that type, to 0 exp ever.");
                break;
            case "level":
                sender.sendMessage("  /rplevel set {user} {type} {amount}   will set that person, in that type, to that level.");
                sender.sendMessage("  /rplevel add {user} {type} {amount}   will add to that person, in that type, that amount of levels.");
                sender.sendMessage("  /rplevel reset {user} {type} {amount} will set that person, in that type, to 0 exp ever.");
                break;
            default:
                sender.sendMessage("Roleplay as a PRPPokemon with this plugin!");
                sender.sendMessage("  /rp help {pokemon|exp|level}");
                sender.sendMessage("  /rp reload");
                break;
        }
    }

}
