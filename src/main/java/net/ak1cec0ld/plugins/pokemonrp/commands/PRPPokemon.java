package net.ak1cec0ld.plugins.pokemonrp.commands;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.files.PlayerFile;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import net.ak1cec0ld.plugins.pokemonrp.types.converters.PokemonToType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class PRPPokemon implements TabExecutor {

    public PRPPokemon(){
        Pokemon_RP.instance().getServer().getPluginCommand("pokemon").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        switch(args.length){
            case 1:
                if(commandSender instanceof Player) {
                    Player player = (Player)commandSender;
                    Type[] types = PokemonToType.get(args[0]);
                    if (types != null && types.length > 0) {
                        PlayerFile.resetType(player.getUniqueId().toString());
                        for (Type each : types) {
                            PlayerFile.addType(player.getUniqueId().toString(), each);
                            commandSender.sendMessage("Added "+each.toString().toLowerCase()+" Type!");
                        }
                        return true;
                    }
                    commandSender.sendMessage("No viable Pokemon found!");
                    return false;
                }
                commandSender.sendMessage("Must be sent by Player");
                return false;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        final List<String> completions = new ArrayList<>();
        switch(args.length){
            case 1:
                StringUtil.copyPartialMatches(args[0], PokemonToType.allPokemonNames(), completions);
                return completions;
            case 2:
                List<String> finalList = new ArrayList<>();
                for(Player eachPlayer : Bukkit.getOnlinePlayers()){
                    finalList.add(eachPlayer.getName());
                }
                StringUtil.copyPartialMatches(args[1], finalList, completions);
                return completions;
        }
        return null;
    }
}
