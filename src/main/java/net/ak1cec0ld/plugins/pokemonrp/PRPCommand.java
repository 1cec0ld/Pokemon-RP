package net.ak1cec0ld.plugins.pokemonrp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PRPCommand implements CommandExecutor {

    PRPCommand(){
        Pokemon_RP.instance().getServer().getPluginCommand("pokemonrp").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
