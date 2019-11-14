package net.ak1cec0ld.plugins.pokemonrp.listeners.global;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.attacks.ghost.ConfuseRay;
import net.ak1cec0ld.plugins.pokemonrp.files.PlayerFile;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import net.ak1cec0ld.plugins.pokemonrp.types.converters.DamageCauseToType;
import net.ak1cec0ld.plugins.pokemonrp.types.converters.EntityToType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Damage implements Listener {

    public Damage(){
        Pokemon_RP.instance().getServer().getPluginManager().registerEvents(this,Pokemon_RP.instance());
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        Type attackingDamageType = getIncomingDamageType(event);
        List<Type> defendingDamageType = getDefendingDamageType(event);
        if(defendingDamageType == null)return;
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
        }
        if(event instanceof EntityDamageByEntityEvent){
            EntityDamageByEntityEvent event_ee = (EntityDamageByEntityEvent)event;
            if(event_ee.getDamager().hasMetadata(ConfuseRay.CONFUSION_KEY)){
                processConfusion(event_ee);
            }
        }
        event.setCancelled(event.getDamage() <= 0.0);

    }

    private void processConfusion(EntityDamageByEntityEvent event_ee) {
        Random r = new Random();
        if(r.nextDouble() < .5 && event_ee.getDamager() instanceof LivingEntity){
            event_ee.setCancelled(true);
            ((LivingEntity) event_ee.getDamager()).damage(3.0, event_ee.getDamager());
            event_ee.getDamager().sendMessage("You hurt yourself in your confusion!");
        }
        int remainingConfusion = event_ee.getDamager().getMetadata(ConfuseRay.CONFUSION_KEY).get(0).asInt();
        if(remainingConfusion == 1){
            event_ee.getDamager().removeMetadata(ConfuseRay.CONFUSION_KEY,Pokemon_RP.instance());
        } else {
            event_ee.getDamager().setMetadata(ConfuseRay.CONFUSION_KEY, new FixedMetadataValue(Pokemon_RP.instance(),remainingConfusion-1));
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
            }
            return EntityToType.get(event_ee.getDamager());
        }
        if(event.getEntity().hasMetadata(Pokemon_RP.DAMAGE_KEY)){
            return Type.valueOf(event.getEntity().getMetadata(Pokemon_RP.DAMAGE_KEY).get(0).asString());
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
