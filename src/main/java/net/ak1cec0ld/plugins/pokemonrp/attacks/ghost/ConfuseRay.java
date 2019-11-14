package net.ak1cec0ld.plugins.pokemonrp.attacks.ghost;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.attacks.EntityTargetedAttack;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import net.ak1cec0ld.plugins.pokemonrp.types.converters.EntityToType;
import org.bukkit.entity.Entity;
import org.bukkit.metadata.FixedMetadataValue;

public class ConfuseRay implements EntityTargetedAttack {
    public static String CONFUSION_KEY = "confused";

    public String getName() {
        return "Confuse Ray";
    }

    public Type getType() {
        return Type.GHOST;
    }

    public void execute(Entity sender){
        execute(sender,null);
    }

    public void execute(Entity sender, Entity target){
        if(target==null)return;
        Type targetType = EntityToType.get(target);
        if(getType().dealsZeroDamageTo(targetType)){
            sender.sendMessage("It doesn't affect enemy " + targetType.toString().toLowerCase() + " type...");
        } else {
            sender.sendMessage("You used Confuse Ray used on " + target.getName());
            target.setMetadata(CONFUSION_KEY, new FixedMetadataValue(Pokemon_RP.instance(), r.nextInt(5)+1));
        }
    }
}
