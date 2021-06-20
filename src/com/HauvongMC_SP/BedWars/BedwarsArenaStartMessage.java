package com.HauvongMC_SP.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;


import com.HauvongMC_SP.API.Reflection;
import com.HauvongMC_SP.API.Reflection.*;
import com.HauvongMC_SP.API.Reflection.JSONMessage;
import com.HauvongMC_SP.API.Reflection.JSONMessage.ChatExtra;
import com.HauvongMC_SP.API.Reflection.JSONMessage.ClickEventType;
import com.HauvongMC_SP.API.Reflection.JSONMessage.HoverEventType;
import com.HauvongMC_SP.Main;
import java.io.File;

public class BedwarsArenaStartMessage implements Listener {
    File file = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC_Support").getDataFolder(), "BedwarsArenaStartMessage.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(file);
    String minPlayersPassedText = config.getString("minPlayersPassedText").replaceAll("&", "§");;
    String minPlayersPassedTulip = config.getString("minPlayersPassedTulip").replaceAll("&", "§");
    String arenaStartingText = config.getString("arenaStartingText").replaceAll("&", "§");
    String arenaStartingTulip = config.getString("arenaStartingTulip").replaceAll("&", "§");
    String lobbyWorld = config.getString("lobbyWorldName").trim(); //saaaa
    @EventHandler
    public void onArenaStart(GameStateChangeEvent e) {
        Arena Arena = (com.andrei1058.bedwars.arena.Arena) e.getArena();
        String ArenaName = Arena.getDisplayName();
        String ArenaGroup = Arena.getGroup();
        GameState ArenaStatus = e.getNewState();
        World lobby = Bukkit.getWorld(lobbyWorld);
        if (ArenaStatus == GameState.waiting) {
            if (Arena.getPlayers().size() >= config.getInt("minPlayers")) {
            	new BukkitRunnable() {

    				public void run() {
    					
    					String arena = "";
    		            switch (ArenaGroup) {
    		                case "Solo":
    		                    arena = "1v1";
    		                    break;
    		                case "Doubles":
    		                    arena = "2v2";
    		                    break;
    		                case "3v3v3v3":
    		                    arena = "3v3v3v3";
    		                    break;
    		                case "4v4v4v4":
    		                    arena = "4v4v4v4";
    		                    break;
    		                case "Cancau":
    		                    arena = "cancau";
    		                    break;
    		            }
    					
                    	lobby.getPlayers().forEach(player -> player.sendMessage(" "));
                        JSONMessage joinmsg = new JSONMessage("");
                        ChatExtra addon = new ChatExtra(arenaStartingText.replace("{arena}", ArenaName).replace("{arenagroup}", ArenaGroup));
                        addon.addClickEvent(ClickEventType.RUN_COMMAND, "/bw join " + ArenaName.toLowerCase() + arena);
                        addon.addHoverEvent(HoverEventType.SHOW_TEXT, arenaStartingTulip.replace("{arena}", ArenaName).replace("{arenagroup}", ArenaGroup));
                        joinmsg.addExtra(addon);
                        lobby.getPlayers().forEach(player -> Reflection.sendChatPacket(player, joinmsg.toString()));
                        lobby.getPlayers().forEach(player -> player.sendMessage(" "));
                    }
                }.runTaskLater(Main.getPlugin(), 10);
            }
        } else if (ArenaStatus == GameState.starting) {
        	new BukkitRunnable() {

				public void run() {
					
					String arena = "";
		            switch (ArenaGroup) {
		                case "Solo":
		                    arena = "1v1";
		                    break;
		                case "Doubles":
		                    arena = "2v2";
		                    break;
		                case "3v3v3v3":
		                    arena = "3v3v3v3";
		                    break;
		                case "4v4v4v4":
		                    arena = "4v4v4v4";
		                    break;
		                case "Cancau":
		                    arena = "cancau";
		                    break;
		            }
					
                	lobby.getPlayers().forEach(player -> player.sendMessage(" "));
                    JSONMessage joinmsg = new JSONMessage("");
                    ChatExtra addon = new ChatExtra(arenaStartingText.replace("{arena}", ArenaName).replace("{arenagroup}", ArenaGroup));
                    addon.addClickEvent(ClickEventType.RUN_COMMAND, "/bw join " + ArenaName.toLowerCase() + arena);
                    addon.addHoverEvent(HoverEventType.SHOW_TEXT, arenaStartingTulip.replace("{arena}", ArenaName).replace("{arenagroup}", ArenaGroup));
                    joinmsg.addExtra(addon);
                    lobby.getPlayers().forEach(player -> Reflection.sendChatPacket(player, joinmsg.toString()));
                    lobby.getPlayers().forEach(player -> player.sendMessage(" "));
                }
            }.runTaskLater(Main.getPlugin(), 10);
        }
    }
}
