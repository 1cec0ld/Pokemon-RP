package net.ak1cec0ld.plugins.pokemonrp.experience;

import net.ak1cec0ld.plugins.pokemonrp.Pokemon_RP;

import java.util.Map;
import java.util.TreeMap;

public class ExperienceTranslator {

    private static TreeMap<Long,Integer> expToLevelTable = new TreeMap<>();

    public ExperienceTranslator(){
        expToLevelTable.put(0L,1);
        int output = 0;
        long input = 1;
        for(int i = 1; i < 100; i++){
            while(output <= i){
                output = levelFunction(input);
                //Pokemon_RP.debug("test To Level: " + input + " " + output);
                input++;
            }
            expToLevelTable.put(input,output);
            Pokemon_RP.debug("exp To Level: " + input + " " + output);
        }
    }

    public static int level(long experience){
        return mappedValue(expToLevelTable, experience);
    }

    private static int mappedValue(TreeMap<Long, Integer> map2, long currentTime){
        Map.Entry<Long, Integer> e = map2.floorEntry(currentTime);
        if(e != null){
            e = map2.lowerEntry(currentTime);
        }
        return e == null ? 0 : e.getValue();
    }

    private static int levelFunction(long y){
        return (int) (((double)1/6)* (Math.pow((10 *Math.sqrt(81 *Math.pow(y,2) - 16695 *y + 1387600) + 90 *y - 9275),((double)1/3)) - (75 *Math.pow(5,((double)2/3)))/Math.pow((2 *Math.sqrt(81 *Math.pow(y,2) - 16695 *y + 1387600) + 18 *y - 1855),((double)1/3)) + 25));
    }
}
