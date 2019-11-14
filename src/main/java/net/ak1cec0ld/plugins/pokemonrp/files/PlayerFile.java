package net.ak1cec0ld.plugins.pokemonrp.files;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;
import net.ak1cec0ld.plugins.pokemonrp.types.Type;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerFile {
    private static CustomYMLStorage yml;
    private static YamlConfiguration storage;

    public PlayerFile(){
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
    public static void addType(String uuid, Type type){
        List<String> current = storage.getStringList(uuid+".types");
        if(current.contains(type.toString()))return;
        current.add(type.toString());
        storage.set(uuid+".types",current);
        yml.save();
    }
    public static boolean removeType(String uuid, Type type){
        List<String> current = storage.getStringList(uuid+".types");
        if(!current.contains(type.toString()))return false;
        current.remove(type.toString().toUpperCase());
        storage.set(uuid+".types",current);
        yml.save();
        return true;
    }
    public static void setType(String uuid, Type type){
        storage.set(uuid+".types", Arrays.asList(type.toString()));
        yml.save();
    }
    public static void resetType(String uuid){
        storage.set(uuid+".types",null);
    }
    public static void reload(){
        yml.reload();
        storage = yml.getYamlConfiguration();
    }
    public static void setExp(String uuid, Type type, int exp){
        storage.set(uuid+ "." +type.toString()+ ".exp",exp);
        yml.save();
    }
    public static void addExp(String uuid, Type type, int exp){
        int oldExp = storage.getInt(uuid+ "." +type.toString()+ ".exp",0);
        storage.set(uuid+ "." +type.toString()+ ".exp", oldExp+exp);
        yml.save();
    }
    public static int getLevel(String uuid, Type type){
        int exp = storage.getInt(uuid+ "." +type.toString()+ ".exp",0);
        return Math.min(levelFunction(exp),100);
    }
    public static int getExp(String uuid, Type type){
        return storage.getInt(uuid+ "." +type.toString()+ ".exp",0);
    }

    private static int levelFunction(int y){
        return (int) (((double)1/6)* (Math.pow((10 *Math.sqrt(81 *Math.pow(y,2) - 16695 *y + 1387600) + 90 *y - 9275),((double)1/3)) - (75 *Math.pow(5,((double)2/3)))/Math.pow((2 *Math.sqrt(81 *Math.pow(y,2) - 16695 *y + 1387600) + 18 *y - 1855),((double)1/3)) + 25));
    }
}
