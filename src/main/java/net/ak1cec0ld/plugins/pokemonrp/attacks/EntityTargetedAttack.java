package net.ak1cec0ld.plugins.pokemonrp.attacks;

import org.bukkit.entity.Entity;

public interface EntityTargetedAttack extends Attack{

    void execute(Entity sender, Entity target);
}
