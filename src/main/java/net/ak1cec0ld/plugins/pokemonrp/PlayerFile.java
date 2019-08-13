package net.ak1cec0ld.plugins.pokemonrp;

import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;

public class PlayerFile {
    private static CustomYMLStorage yml;
    private static YamlConfiguration storage;

    PlayerFile(){
        yml = new CustomYMLStorage(Pokemon_RP.instance(),"PlayerStorage.yml","Pokemon_RP");
        storage = yml.getYamlConfiguration();
        yml.save();
    }

    public static List<Type> getTypes(String uuid){
        List<Type> temp = new ArrayList<>();
        for (String each : storage.getStringList(uuid+".types")){
            try {
                temp.add(Type.valueOf(each.toUpperCase()));
            } catch(IllegalArgumentException e){
                Pokemon_RP.debug("Illegal Type found for player "+ uuid + " : " + each);
            }
        }
        return temp;
    }
    static void addType(String uuid, Type type){
        List<String> current = storage.getStringList(uuid+".types");
        if(current.contains(type.toString()))return;
        current.add(type.toString());
        storage.set(uuid+".types",current);
    }
}
