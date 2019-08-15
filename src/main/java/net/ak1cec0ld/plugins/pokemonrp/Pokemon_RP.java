package net.ak1cec0ld.plugins.pokemonrp;

import net.ak1cec0ld.plugins.pokemonrp.commands.PRP;
import net.ak1cec0ld.plugins.pokemonrp.commands.PRPType;
import net.ak1cec0ld.plugins.pokemonrp.files.PlayerFile;
import net.ak1cec0ld.plugins.pokemonrp.listeners.Damage;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Pokemon_RP extends JavaPlugin{
    private static Pokemon_RP instance;

    public void onEnable(){
        instance = this;


        new PlayerFile();
        new PRP();
        new PRPType();
        new Damage();

    }

    public static Pokemon_RP instance(){
        return instance;
    }
    public static void msgActionBar(Player player, String message, ChatColor color){
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(message).color(color).create());
    }
    public static void debug(String string){
        Bukkit.getLogger().info("[Pokemon_RP-debug] " + string);
    }
}
