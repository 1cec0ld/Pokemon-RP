package net.ak1cec0ld.plugins.pokemonrp.types.converters;

import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.HashMap;
import java.util.Map;

import static net.ak1cec0ld.plugins.pokemonrp.types.Type.*;

public class DamageCauseToType {

    private static final Map<EntityDamageEvent.DamageCause, Type> map = new HashMap<>();
    static{
        map.put(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION,      ROCK);
        map.put(EntityDamageEvent.DamageCause.CONTACT,              GRASS);
        map.put(EntityDamageEvent.DamageCause.CRAMMING,             NORMAL);
        map.put(EntityDamageEvent.DamageCause.CUSTOM,               FAIRY);
        map.put(EntityDamageEvent.DamageCause.DRAGON_BREATH,        DRAGON);
        map.put(EntityDamageEvent.DamageCause.DROWNING,             WATER);
        map.put(EntityDamageEvent.DamageCause.DRYOUT,               GRASS);
        map.put(EntityDamageEvent.DamageCause.ENTITY_ATTACK,        NORMAL);
        map.put(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION,     NORMAL);
        map.put(EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK,  FIGHTING);
        map.put(EntityDamageEvent.DamageCause.FALL,                 FLYING);
        map.put(EntityDamageEvent.DamageCause.FALLING_BLOCK,        ROCK);
        map.put(EntityDamageEvent.DamageCause.FIRE,                 FIRE);
        map.put(EntityDamageEvent.DamageCause.FIRE_TICK,            FIRE);
        map.put(EntityDamageEvent.DamageCause.FLY_INTO_WALL,        FLYING);
        map.put(EntityDamageEvent.DamageCause.HOT_FLOOR,            FIRE);
        map.put(EntityDamageEvent.DamageCause.LAVA,                 FIRE);
        map.put(EntityDamageEvent.DamageCause.LIGHTNING,            ELECTRIC);
        map.put(EntityDamageEvent.DamageCause.MAGIC,                PSYCHIC);
        map.put(EntityDamageEvent.DamageCause.MELTING,              ICE);
        map.put(EntityDamageEvent.DamageCause.POISON,               POISON);
        map.put(EntityDamageEvent.DamageCause.PROJECTILE,           DARK);
        map.put(EntityDamageEvent.DamageCause.STARVATION,           BUG);
        map.put(EntityDamageEvent.DamageCause.SUFFOCATION,          GROUND);
        map.put(EntityDamageEvent.DamageCause.SUICIDE,              GHOST);
        map.put(EntityDamageEvent.DamageCause.THORNS,               STEEL);
        map.put(EntityDamageEvent.DamageCause.VOID,                 GHOST);
        map.put(EntityDamageEvent.DamageCause.WITHER,               DARK);
    }

    public static Type get(EntityDamageEvent.DamageCause cause){
        if(!map.keySet().contains(cause))return null;
        return map.get(cause);
    }
}
