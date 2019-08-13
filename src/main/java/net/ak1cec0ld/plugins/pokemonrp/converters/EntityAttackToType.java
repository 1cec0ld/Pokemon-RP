package net.ak1cec0ld.plugins.pokemonrp.converters;

import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class EntityAttackToType {

    private static final Map<EntityType, Type> map = new HashMap<>();
    static{
        map.put(EntityType.AREA_EFFECT_CLOUD,       null);
        map.put(EntityType.ARMOR_STAND,             null);
        map.put(EntityType.ARROW,                   null);
        map.put(EntityType.BAT,                     null);
        map.put(EntityType.BLAZE,                   null);
        map.put(EntityType.BOAT,                    null);
        map.put(EntityType.CAT,                     null);
        map.put(EntityType.CAVE_SPIDER,             null);
        map.put(EntityType.CHICKEN,                 null);
        map.put(EntityType.COD,                     null);
        map.put(EntityType.COW,                     null);
        map.put(EntityType.CREEPER,                 null);
        map.put(EntityType.DOLPHIN,                 null);
        map.put(EntityType.DONKEY,                  null);
        map.put(EntityType.DRAGON_FIREBALL,         null);
        map.put(EntityType.DROPPED_ITEM,            null);
        map.put(EntityType.DROWNED,                 null);
        map.put(EntityType.EGG,                     null);
        map.put(EntityType.ELDER_GUARDIAN,          null);
        map.put(EntityType.ENDER_CRYSTAL,           null);
        map.put(EntityType.ENDER_DRAGON,            null);
        map.put(EntityType.ENDER_PEARL,             null);
        map.put(EntityType.ENDER_SIGNAL,            null);
        map.put(EntityType.ENDERMAN,                null);
        map.put(EntityType.ENDERMITE,               null);
        map.put(EntityType.EVOKER,                  null);
        map.put(EntityType.EVOKER_FANGS,            null);
        map.put(EntityType.EXPERIENCE_ORB,          null);
        map.put(EntityType.FALLING_BLOCK,           null);
        map.put(EntityType.FIREBALL,                null);
        map.put(EntityType.FIREWORK,                null);
        map.put(EntityType.FISHING_HOOK,            null);
        map.put(EntityType.FOX,                     null);
        map.put(EntityType.GHAST,                   null);
        map.put(EntityType.GIANT,                   null);
        map.put(EntityType.GUARDIAN,                null);
        map.put(EntityType.HORSE,                   null);
        map.put(EntityType.HUSK,                    null);
        map.put(EntityType.ILLUSIONER,              null);
        map.put(EntityType.IRON_GOLEM,              null);
        map.put(EntityType.ITEM_FRAME,              null);
        map.put(EntityType.LEASH_HITCH,             null);
        map.put(EntityType.LIGHTNING,               null);
        map.put(EntityType.LLAMA,                   null);
        map.put(EntityType.LLAMA_SPIT,              null);
        map.put(EntityType.MAGMA_CUBE,              null);
        map.put(EntityType.MINECART,                null);
        map.put(EntityType.MINECART_CHEST,          null);
        map.put(EntityType.MINECART_COMMAND,        null);
        map.put(EntityType.MINECART_FURNACE,        null);
        map.put(EntityType.MINECART_HOPPER,         null);
        map.put(EntityType.MINECART_MOB_SPAWNER,    null);
        map.put(EntityType.MINECART_TNT,            null);
        map.put(EntityType.MULE,                    null);
        map.put(EntityType.MUSHROOM_COW,            null);
        map.put(EntityType.OCELOT,                  null);
        map.put(EntityType.PAINTING,                null);
        map.put(EntityType.PANDA,                   null);
        map.put(EntityType.PARROT,                  null);
        map.put(EntityType.PHANTOM,                 null);
        map.put(EntityType.PIG,                     null);
        map.put(EntityType.PIG_ZOMBIE,              null);
        map.put(EntityType.PILLAGER,                null);
        map.put(EntityType.PLAYER,                  null);
        map.put(EntityType.POLAR_BEAR,              null);
        
    }

    public static Type get(EntityType cause){
        if(!map.keySet().contains(cause))return null;
        return map.get(cause);
    }
}
