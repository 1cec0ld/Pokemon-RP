package net.ak1cec0ld.plugins.pokemonrp.listeners;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.files.PlayerFile;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import net.ak1cec0ld.plugins.pokemonrp.types.converters.DamageCauseToType;
import net.ak1cec0ld.plugins.pokemonrp.types.converters.EntityToType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Collections;
import java.util.List;

public class Damage implements Listener {

    public Damage(){
        Pokemon_RP.instance().getServer().getPluginManager().registerEvents(this,Pokemon_RP.instance());
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        //final double damageBefore = event.getDamage();
        Type attackingDamageType = getIncomingDamageType(event);
        List<Type> defendingDamageType = getDefendingDamageType(event);
        for(Type each : defendingDamageType){
            if(attackingDamageType == null)return;
            if(attackingDamageType.dealsDoubleDamageTo(each)){
                event.setDamage(event.getDamage()*2);
            }
            if(attackingDamageType.dealsHalfDamageTo(each)){
                event.setDamage(event.getDamage()*0.5);
            }
            if(attackingDamageType.dealsZeroDamageTo(each)){
                event.setDamage(event.getDamage()*0);
            }
            //Pokemon_RP.debug(attackingDamageType + " attacked " + each+ "("+event.getEntity().getType()+") for " + event.getDamage() + " instead of " + damageBefore);
        }
    }

    private Type getIncomingDamageType(EntityDamageEvent event) {
        if(event instanceof EntityDamageByEntityEvent){
            EntityDamageByEntityEvent event_ee = (EntityDamageByEntityEvent)event;
            if(event.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)){
                Projectile shot = (Projectile)event_ee.getDamager();
                if(shot.getShooter() != null && shot.getShooter() instanceof Entity){
                    return EntityToType.get(((Entity)shot.getShooter()));
                }
            } else if(event_ee.getDamager() instanceof Player){
                return PlayerFile.getTypes(event_ee.getDamager().getUniqueId().toString()).get(0);
            }
            return EntityToType.get(event_ee.getDamager());
        }
        return DamageCauseToType.get(event.getCause());
    }
    private List<Type> getDefendingDamageType(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            return PlayerFile.getTypes(event.getEntity().getUniqueId().toString());
        }
        return Collections.singletonList(EntityToType.get(event.getEntity()));
    }
}
