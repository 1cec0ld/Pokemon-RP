package net.ak1cec0ld.plugins.pokemonrp.types;

import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Type {
    NORMAL,
    FIRE,
    WATER,
    ELECTRIC,
    GRASS,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    DARK,
    STEEL,
    FAIRY;

    private List<Type> doubleDamage;
    private List<Type> halfDamage;
    private List<Type> zeroDamage;

    static {
        populateDoubleDamage();
        populateHalfDamage();
        populateZeroDamage();
    }

    public boolean dealsDoubleDamageTo(Type versus){
        return this.doubleDamage != null && this.doubleDamage.contains(versus);
    }
    public boolean dealsHalfDamageTo(Type versus){
        return this.halfDamage != null && this.halfDamage.contains(versus);
    }
    public boolean dealsZeroDamageTo(Type versus){
        return this.zeroDamage != null && this.zeroDamage.contains(versus);
    }

    private static void populateDoubleDamage(){
        FIRE.doubleDamage = Arrays.asList(GRASS,ICE,BUG,STEEL);
        WATER.doubleDamage = Arrays.asList(FIRE,GROUND,ROCK);
        ELECTRIC.doubleDamage = Arrays.asList(WATER,FLYING);
        GRASS.doubleDamage = Arrays.asList(WATER,GROUND,ROCK);
        ICE.doubleDamage = Arrays.asList(GRASS,GROUND,FLYING,DRAGON);
        FIGHTING.doubleDamage = Arrays.asList(NORMAL,ICE,ROCK,DARK,STEEL);
        POISON.doubleDamage = Arrays.asList(GRASS,FAIRY);
        GROUND.doubleDamage = Arrays.asList(FIRE,ELECTRIC,POISON,ROCK,STEEL);
        FLYING.doubleDamage = Arrays.asList(GRASS,FIGHTING,BUG);
        PSYCHIC.doubleDamage = Arrays.asList(FIGHTING,POISON);
        BUG.doubleDamage = Arrays.asList(GRASS,PSYCHIC,DARK);
        ROCK.doubleDamage = Arrays.asList(FIRE,ICE,FLYING,BUG);
        GHOST.doubleDamage = Arrays.asList(PSYCHIC,GHOST);
        DRAGON.doubleDamage = Collections.singletonList(DRAGON);
        DARK.doubleDamage = Arrays.asList(PSYCHIC,GHOST);
        STEEL.doubleDamage = Arrays.asList(ICE,ROCK,FAIRY);
        FAIRY.doubleDamage = Arrays.asList(FIGHTING,DRAGON,DARK);
    }
    private static void populateHalfDamage(){
        NORMAL.halfDamage = Arrays.asList(ROCK,STEEL);
        FIRE.halfDamage = Arrays.asList(FIRE,WATER,ROCK,DRAGON);
        WATER.halfDamage = Arrays.asList(WATER,GRASS,DRAGON);
        ELECTRIC.halfDamage = Arrays.asList(ELECTRIC,GRASS,DRAGON);
        GRASS.halfDamage = Arrays.asList(FIRE,GRASS,POISON,FLYING,BUG,DRAGON,STEEL);
        ICE.halfDamage = Arrays.asList(FIRE,WATER,ICE,STEEL);
        FIGHTING.halfDamage = Arrays.asList(POISON,FLYING,PSYCHIC,BUG,FAIRY);
        POISON.halfDamage = Arrays.asList(POISON,GROUND,ROCK,GHOST);
        GROUND.halfDamage = Arrays.asList(GRASS,BUG);
        FLYING.halfDamage = Arrays.asList(ELECTRIC,ROCK,STEEL);
        PSYCHIC.halfDamage = Arrays.asList(PSYCHIC,STEEL);
        BUG.halfDamage = Arrays.asList(FIRE,FIGHTING,POISON,FLYING,GHOST,STEEL,FAIRY);
        ROCK.halfDamage = Arrays.asList(FIGHTING,GROUND,STEEL);
        GHOST.halfDamage = Collections.singletonList(DARK);
        DRAGON.halfDamage = Collections.singletonList(STEEL);
        DARK.halfDamage = Arrays.asList(FIGHTING,DARK,FAIRY);
        STEEL.halfDamage = Arrays.asList(FIRE,WATER,ELECTRIC,STEEL);
        FAIRY.halfDamage = Arrays.asList(FIRE,POISON,STEEL);
    }
    private static void populateZeroDamage(){
        NORMAL.zeroDamage = Collections.singletonList(GHOST);
        ELECTRIC.zeroDamage = Collections.singletonList(GROUND);
        FIGHTING.zeroDamage = Collections.singletonList(GHOST);
        POISON.zeroDamage = Collections.singletonList(STEEL);
        GROUND.zeroDamage = Collections.singletonList(FLYING);
        PSYCHIC.zeroDamage = Collections.singletonList(DARK);
        GHOST.zeroDamage = Collections.singletonList(NORMAL);
        DRAGON.zeroDamage = Collections.singletonList(FAIRY);
    }
    public static List<String> stringValues(){
        List<String> values = new ArrayList<>();
        for(Type each : values()){
            values.add(each.name());
        }
        return values;
    }
}
