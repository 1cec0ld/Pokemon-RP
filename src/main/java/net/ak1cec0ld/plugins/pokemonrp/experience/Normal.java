package net.ak1cec0ld.plugins.pokemonrp.experience;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.files.PlayerFile;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Normal implements Listener {

    public Normal(){
        Pokemon_RP.instance().getServer().getPluginManager().registerEvents(this,Pokemon_RP.instance());
    }


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if(!PlayerFile.getTypes(event.getPlayer().getUniqueId().toString()).contains(Type.NORMAL))return;
        PlayerFile.addExp(event.getPlayer().getUniqueId().toString(), Type.NORMAL, 1);
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(!PlayerFile.getTypes(event.getPlayer().getUniqueId().toString()).contains(Type.NORMAL))return;
        PlayerFile.addExp(event.getPlayer().getUniqueId().toString(), Type.NORMAL, 1);
    }
}
