package net.ak1cec0ld.plugins.pokemonrp.organization;


import java.util.HashMap;
import java.util.UUID;

public class SessionManager {
    private static HashMap<UUID, RolePlayer> onlinePlayers = new HashMap<>();


    public static RolePlayer getRolePlayerByUUID(UUID id){
        return onlinePlayers.getOrDefault(id, null);
    }

    public static void removeRolePlayerByUUID(UUID id){
        onlinePlayers.remove(id);
    }

    public static void addRolePlayerByUUID(UUID id){
        onlinePlayers.put(id, new RolePlayer(id));
    }

}
