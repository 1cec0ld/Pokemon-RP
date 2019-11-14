package net.ak1cec0ld.plugins.pokemonrp.commands;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRPLevel implements TabExecutor {

    private static final List<String> types = Type.stringValues();

    public PRPLevel(){
        Pokemon_RP.instance().getServer().getPluginCommand("rplevel").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        switch(args.length){

        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        final List<String> completions = new ArrayList<>();
        switch(args.length) {
            case 1:
                final List<String> actions = Arrays.asList("set","add","reset");
                StringUtil.copyPartialMatches(args[0], actions, completions);
                return completions;
            case 2:
                List<String> finalList = new ArrayList<>();
                for (Player eachPlayer : Bukkit.getOnlinePlayers()){
                    finalList.add(eachPlayer.getName());
                }
                StringUtil.copyPartialMatches(args[1], finalList, completions);
                return completions;
            case 3:
                switch(args[0].toLowerCase()) {
                    case "set":
                    case "add":
                    case "remove":
                        StringUtil.copyPartialMatches(args[2], types, completions);
                        break;
                }
                return completions;
            default:
                return null;
        }
    }
}
