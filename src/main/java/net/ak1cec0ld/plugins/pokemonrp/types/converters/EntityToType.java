package net.ak1cec0ld.plugins.pokemonrp.types.converters;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.files.PlayerFile;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

import static net.ak1cec0ld.plugins.pokemonrp.types.Type.*;

public class EntityToType {

    private static final Map<EntityType, Type> map = new HashMap<>();
    static{
        map.put(EntityType.AREA_EFFECT_CLOUD,       PSYCHIC);
        map.put(EntityType.ARMOR_STAND,             NORMAL);
        map.put(EntityType.ARROW,                   NORMAL);
        map.put(EntityType.BAT,                     POISON);
        map.put(EntityType.BLAZE,                   FIRE);
        map.put(EntityType.BOAT,                    WATER);
        map.put(EntityType.CAT,                     NORMAL);
        map.put(EntityType.CAVE_SPIDER,             BUG);
        map.put(EntityType.CHICKEN,                 FLYING);
        map.put(EntityType.COD,                     WATER);
        map.put(EntityType.COW,                     NORMAL);
        map.put(EntityType.CREEPER,                 ELECTRIC);
        map.put(EntityType.DOLPHIN,                 WATER);
        map.put(EntityType.DONKEY,                  NORMAL);
        map.put(EntityType.DRAGON_FIREBALL,         DRAGON);
        map.put(EntityType.DROPPED_ITEM,            NORMAL);
        map.put(EntityType.DROWNED,                 WATER);
        map.put(EntityType.EGG,                     FAIRY);
        map.put(EntityType.ELDER_GUARDIAN,          PSYCHIC);
        map.put(EntityType.ENDER_CRYSTAL,           DRAGON);
        map.put(EntityType.ENDER_DRAGON,            DRAGON);
        map.put(EntityType.ENDER_PEARL,             PSYCHIC);
        map.put(EntityType.ENDER_SIGNAL,            PSYCHIC);
        map.put(EntityType.ENDERMAN,                PSYCHIC);
        map.put(EntityType.ENDERMITE,               BUG);
        map.put(EntityType.EVOKER,                  FAIRY);
        map.put(EntityType.EVOKER_FANGS,            GROUND);
        map.put(EntityType.EXPERIENCE_ORB,          FAIRY);
        map.put(EntityType.FALLING_BLOCK,           ROCK);
        map.put(EntityType.FIREBALL,                FIRE);
        map.put(EntityType.FIREWORK,                FIRE);
        map.put(EntityType.FISHING_HOOK,            WATER);
        map.put(EntityType.FOX,                     NORMAL);
        map.put(EntityType.GHAST,                   GHOST);
        map.put(EntityType.GIANT,                   DRAGON);
        map.put(EntityType.GUARDIAN,                WATER);
        map.put(EntityType.HORSE,                   NORMAL);
        map.put(EntityType.HUSK,                    GROUND);
        map.put(EntityType.ILLUSIONER,              PSYCHIC);
        map.put(EntityType.IRON_GOLEM,              STEEL);
        map.put(EntityType.ITEM_FRAME,              NORMAL);
        map.put(EntityType.LEASH_HITCH,             NORMAL);
        map.put(EntityType.LIGHTNING,               ELECTRIC);
        map.put(EntityType.LLAMA,                   FAIRY);
        map.put(EntityType.LLAMA_SPIT,              NORMAL);
        map.put(EntityType.MAGMA_CUBE,              FIRE);
        map.put(EntityType.MINECART,                STEEL);
        map.put(EntityType.MINECART_CHEST,          GROUND);
        map.put(EntityType.MINECART_COMMAND,        ELECTRIC);
        map.put(EntityType.MINECART_FURNACE,        FIRE);
        map.put(EntityType.MINECART_HOPPER,         STEEL);
        map.put(EntityType.MINECART_MOB_SPAWNER,    BUG);
        map.put(EntityType.MINECART_TNT,            ROCK);
        map.put(EntityType.MULE,                    NORMAL);
        map.put(EntityType.MUSHROOM_COW,            GRASS);
        map.put(EntityType.OCELOT,                  NORMAL);
        map.put(EntityType.PAINTING,                NORMAL);
        map.put(EntityType.PANDA,                   NORMAL);
        map.put(EntityType.PARROT,                  FLYING);
        map.put(EntityType.PHANTOM,                 FLYING);
        map.put(EntityType.PIG,                     NORMAL);
        map.put(EntityType.PIG_ZOMBIE,              FIRE);
        map.put(EntityType.PILLAGER,                FIGHTING);
        map.put(EntityType.PLAYER,                  NORMAL);
        map.put(EntityType.POLAR_BEAR,              ICE);
        map.put(EntityType.PRIMED_TNT,              ELECTRIC);
        map.put(EntityType.PUFFERFISH,              POISON);
        map.put(EntityType.RABBIT,                  NORMAL);
        map.put(EntityType.RAVAGER,                 GROUND);
        map.put(EntityType.SALMON,                  WATER);
        map.put(EntityType.SHEEP,                   NORMAL);
        map.put(EntityType.SHULKER,                 PSYCHIC);
        map.put(EntityType.SHULKER_BULLET,          PSYCHIC);
        map.put(EntityType.SILVERFISH,              BUG);
        map.put(EntityType.SKELETON,                GHOST);
        map.put(EntityType.SKELETON_HORSE,          GHOST);
        map.put(EntityType.SLIME,                   POISON);
        map.put(EntityType.SMALL_FIREBALL,          FIRE);
        map.put(EntityType.SNOWBALL,                ICE);
        map.put(EntityType.SNOWMAN,                 ICE);
        map.put(EntityType.SPECTRAL_ARROW,          FAIRY);
        map.put(EntityType.SPIDER,                  BUG);
        map.put(EntityType.SPLASH_POTION,           PSYCHIC);
        map.put(EntityType.SQUID,                   POISON);
        map.put(EntityType.STRAY,                   ICE);
        map.put(EntityType.THROWN_EXP_BOTTLE,       FAIRY);
        map.put(EntityType.TRADER_LLAMA,            FAIRY);
        map.put(EntityType.TRIDENT,                 STEEL);
        map.put(EntityType.TROPICAL_FISH,           WATER);
        map.put(EntityType.TURTLE,                  WATER);
        map.put(EntityType.UNKNOWN,                 FAIRY);
        map.put(EntityType.VEX,                     GHOST);
        map.put(EntityType.VILLAGER,                NORMAL);
        map.put(EntityType.VINDICATOR,              FIGHTING);
        map.put(EntityType.WANDERING_TRADER,        NORMAL);
        map.put(EntityType.WITCH,                   PSYCHIC);
        map.put(EntityType.WITHER,                  DARK);
        map.put(EntityType.WITHER_SKELETON,         DARK);
        map.put(EntityType.WITHER_SKULL,            DARK);
        map.put(EntityType.WOLF,                    NORMAL);
        map.put(EntityType.ZOMBIE,                  FIGHTING);
        map.put(EntityType.ZOMBIE_HORSE,            FIGHTING);
        map.put(EntityType.ZOMBIE_VILLAGER,         DARK);
    }

    public static Type get(Entity cause){
        if(!map.keySet().contains(cause.getType()))return null;
        if(cause.getType().equals(EntityType.PLAYER))
        try {
            return PlayerFile.getTypes(cause.getUniqueId().toString()).get(0);
        } catch (Exception e){
            Pokemon_RP.debug("Unknown Player caused damage, no valid mapping to Type");
            return NORMAL;
        }
        try {
            return map.get(cause.getType());
        } catch (Exception e){
            Pokemon_RP.debug("Unknown Entity caused damage, no valid mapping to Type: "+ cause.getType().toString());
            return NORMAL;
        }
    }
}
