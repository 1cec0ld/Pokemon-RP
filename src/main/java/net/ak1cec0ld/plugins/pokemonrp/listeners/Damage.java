package net.ak1cec0ld.plugins.pokemonrp.listeners;

import net.ak1cec0ld.plugins.pokemonrp.PlayerFile;
import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.converters.DamageCauseToType;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {



    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(!(event.getEntity() instanceof Player))return;
        Player player = (Player) event.getEntity();
        Type incomingDamageType = getIncomingDamageType(event);
        for(Type each : PlayerFile.getTypes(player.getUniqueId().toString())){
            if(incomingDamageType == null){
                Pokemon_RP.debug("incomingDamageType found to be null: " + event.getCause().toString());
            }
            if(incomingDamageType.dealsDoubleDamageTo(each)){
                event.setDamage(event.getDamage()*2);
            }
            if(incomingDamageType.dealsHalfDamageTo(each)){
                event.setDamage(event.getDamage()*0.5);
            }
            if(incomingDamageType.dealsZeroDamageTo(each)){
                event.setDamage(event.getDamage()*0);
            }
        }
    }

    private Type getIncomingDamageType(EntityDamageEvent event) {
        if(event instanceof EntityDamageByEntityEvent){
            EntityDamageByEntityEvent event_ee = (EntityDamageByEntityEvent)event;

        }
        return DamageCauseToType.get(event.getCause());
    }


}
