package net.ak1cec0ld.plugins.pokemonrp.attacks;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface LocationTargetedAttack extends Attack{



    void execute(Entity sender, Location target);

}
