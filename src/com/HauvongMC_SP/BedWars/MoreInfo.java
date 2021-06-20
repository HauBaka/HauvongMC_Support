package com.HauvongMC_SP.BedWars;

import com.HauvongMC_SP.Players.GetPlayerData;
import com.HauvongMC_SP.Players.SetPlayerData;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import com.andrei1058.bedwars.api.events.player.PlayerBedBreakEvent;
import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.UUID;
public class MoreInfo implements Listener {
    private static  IArena iArena;
    private static Player p, p1;
    private static int currentkills, currentdeaths, currentwins, currentloses, currents;
    private static String a;
    @EventHandler
    public void kill(PlayerKillEvent event) {
        iArena = event.getArena();
        if (iArena != null) {
            String group = iArena.getGroup();
            String mode = "";
            switch (group) {
                case "Solo":
                    mode = "1v1";
                    break;
                case "Doubles":
                    mode = "2v2";
                    break;
                case "3v3v3v3":
                    mode = "3v3v3v3";
                    break;
                case "4v4v4v4":
                    mode = "4v4v4v4";
                    break;
                case "4v4":
                    mode = "4v4";
                    break;
            }
            if (mode.equalsIgnoreCase("")) return;
            p = event.getKiller();
            if (p != null) {
                a = GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", mode+"_Kills");
                if (a == null || a.equalsIgnoreCase("") || a.equalsIgnoreCase(" ")) a = "0";
                currentkills = Integer.parseInt(a);
                currentkills++;
                SetPlayerData.SetInfo(p.getName(), "bw_stats", mode+"_Kills",  currentkills + "");
                if (event.getCause().isFinalKill()) {
                    a = GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", mode+"_Final_Kills");
                    if (a == null || a.equalsIgnoreCase("") || a.equalsIgnoreCase(" ")) a = "0";
                    currentkills = Integer.parseInt(a);
                    currentkills++;
                    SetPlayerData.SetInfo(p.getName(), "bw_stats", mode+"_Final_Kills",  currentkills + "");
                }
            }
            p1 = event.getVictim();
            if (p1 != null) {
                a = GetPlayerData.getInfo2(p1.getName(), "Name", "bw_stats", mode+"_Deaths");
                if (a == null || a.equalsIgnoreCase("") || a.equalsIgnoreCase(" ")) a = "0";
                currentdeaths = Integer.parseInt(a);
                currentdeaths++;
                SetPlayerData.SetInfo(p1.getName(), "bw_stats", mode+"_Deaths",  currentdeaths + "");
                if (event.getCause().isFinalKill()) {
                    a = GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", mode+"_Final_Deaths");
                    if (a == null || a.equalsIgnoreCase("") || a.equalsIgnoreCase(" ")) a = "0";
                    currentdeaths = Integer.parseInt(a);
                    currentdeaths++;
                    SetPlayerData.SetInfo(p.getName(), "bw_stats", mode+"_Final_Deaths",  currentdeaths + "");
                }
            }

        }
    }

    @EventHandler
    public void win(GameEndEvent event) {
        iArena = event.getArena();
        if (iArena != null) {
            String group = iArena.getGroup();
            String mode = "";
            switch (group) {
                case "Solo":
                    mode = "1v1";
                    break;
                case "Doubles":
                    mode = "2v2";
                    break;
                case "3v3v3v3":
                    mode = "3v3v3v3";
                    break;
                case "4v4v4v4":
                    mode = "4v4v4v4";
                    break;
                case "4v4":
                    mode = "4v4";
                    break;
            }
            if (mode.equalsIgnoreCase("")) return;
            List<UUID> Winners = event.getWinners();
            for (UUID uuid : Winners) {
                p = Bukkit.getPlayer(uuid);
                if (p != null) {
                    a = GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", mode+"_Wins");
                    if (a == null || a.equalsIgnoreCase("") || a.equalsIgnoreCase(" ")) a = "0";
                    currentwins = Integer.parseInt(a);
                    currentwins++;
                    SetPlayerData.SetInfo(p.getName(), "bw_stats", mode+"_Wins", currentwins + "");
                }
            }
            List<UUID> Losers = event.getLosers();
            for (UUID uuid : Losers) {
                p = Bukkit.getPlayer(uuid);
                if (p != null) {
                    a = GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", mode+"_Loses");
                    if (a == null || a.equalsIgnoreCase("") || a.equalsIgnoreCase(" ")) a = "0";
                    currentloses = Integer.parseInt(a);
                    currentloses++;
                    SetPlayerData.SetInfo(p.getName(), "bw_stats", mode+"_Loses", currentloses + "");
                }
            }
        }
    }

    @EventHandler
    public void beddestroy(PlayerBedBreakEvent event) {
        iArena = event.getArena();
        if (iArena != null) {
            String group = iArena.getGroup();
            String mode = "";
            switch (group) {
                case "Solo":
                    mode = "1v1";
                    break;
                case "Doubles":
                    mode = "2v2";
                    break;
                case "3v3v3v3":
                    mode = "3v3v3v3";
                    break;
                case "4v4v4v4":
                    mode = "4v4v4v4";
                    break;
                case "4v4":
                    mode = "4v4";
                    break;
            }
            if (mode.equalsIgnoreCase("")) return;
            if (!(event.getPlayerTeam().getName().equalsIgnoreCase(event.getVictimTeam().getName()))) {
                p = event.getPlayer();
                if (p != null) {
                    a = GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", mode+"_Bed_Destroyed");
                    if (a == null || a.equalsIgnoreCase("") || a.equalsIgnoreCase(" ")) a = "0";
                    currents = Integer.parseInt(a);
                    currents++;
                    SetPlayerData.SetInfo(p.getName(), "bw_stats", mode+"_Bed_Destroyed", currents + "");
                }
            }
        }
    }
}
