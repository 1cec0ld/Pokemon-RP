package net.ak1cec0ld.plugins.pokemonrp.attacks;

import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.entity.Entity;

import java.util.Random;

public interface Attack {
    Random r = new Random();

    String getName();

    Type getType();

    void execute(Entity sender);
}
