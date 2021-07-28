package com.HauvongMC_SP.BedWars;

import com.HauvongMC_SP.Main;
import com.HauvongMC_SP.Players.GetPlayerData;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.gmail.filoghost.holographicdisplays.api.handler.TouchHandler;
import com.gmail.filoghost.holographicdisplays.api.line.TouchableLine;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leaderboards implements Listener {
    static HashMap<String, String> Solo_Kills_Top = new HashMap<>();
    static HashMap<String, String> Doubles_Kills_Top = new HashMap<>();
    static HashMap<String, String> Triple_Kills_Top = new HashMap<>();
    static HashMap<String, String> Quad_Kills_Top = new HashMap<>();
    static HashMap<String, String> Solo_Wins_Top = new HashMap<>();
    static HashMap<String, String> Doubles_Wins_Top = new HashMap<>();
    static HashMap<String, String> Triple_Wins_Top = new HashMap<>();
    static HashMap<String, String> Quad_Wins_Top = new HashMap<>();
    static HashMap<String, String> Solo_FinalKills_Top = new HashMap<>();
    static HashMap<String, String> Doubles_FinalKills_Top = new HashMap<>();
    static HashMap<String, String> Triple_FinalKills_Top = new HashMap<>();
    static HashMap<String, String> Quad_FinalKills_Top = new HashMap<>();
    static HashMap<String, String> Solo_BedBreak_Top = new HashMap<>();
    static HashMap<String, String> Doubles_BedBreak_Top = new HashMap<>();
    static HashMap<String, String> Triple_BedBreak_Top = new HashMap<>();
    static HashMap<String, String> Quad_BedBreak_Top = new HashMap<>();
    static HashMap<String, String> FourvFour_Kills_Top = new HashMap<>();
    static HashMap<String, String> FourvFour_Wins_Top = new HashMap<>();
    static HashMap<String, String> FourvFour_FinalKills_Top = new HashMap<>();
    static HashMap<String, String> FourvFour_BedBreak_Top = new HashMap<>();
    public static void Loop() {
        Solo_Kills_Top = new HashMap<>();
        Solo_Wins_Top = new HashMap<>();
        Solo_FinalKills_Top = new HashMap<>();
        Solo_BedBreak_Top = new HashMap<>();

        Doubles_Kills_Top = new HashMap<>();
        Doubles_Wins_Top = new HashMap<>();
        Doubles_FinalKills_Top = new HashMap<>();
        Doubles_BedBreak_Top = new HashMap<>();

        Triple_Kills_Top = new HashMap<>();
        Triple_Wins_Top = new HashMap<>();
        Triple_FinalKills_Top = new HashMap<>();
        Triple_BedBreak_Top = new HashMap<>();

        Quad_Kills_Top = new HashMap<>();
        Quad_Wins_Top = new HashMap<>();
        Quad_FinalKills_Top = new HashMap<>();
        Quad_BedBreak_Top = new HashMap<>();

        FourvFour_Kills_Top = new HashMap<>();
        FourvFour_Wins_Top = new HashMap<>();
        FourvFour_FinalKills_Top = new HashMap<>();
        FourvFour_BedBreak_Top = new HashMap<>();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                try {
                    PreparedStatement sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 1v1_Kills DESC LIMIT 10");
                    ResultSet rs = sql.executeQuery();
                    /** SOLO **/
                    Solo_Kills_Top.clear();
                    Solo_Wins_Top.clear();
                    Solo_BedBreak_Top.clear();
                    Solo_FinalKills_Top.clear();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Solo_Kills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("1v1_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 1v1_Wins DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Solo_Wins_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("1v1_Wins"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 1v1_Final_Kills DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Solo_FinalKills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("1v1_Final_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 1v1_Bed_Destroyed DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Solo_BedBreak_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("1v1_Bed_Destroyed"));
                    }
                    /** Doubles **/
                    Doubles_Kills_Top.clear();
                    Doubles_Wins_Top.clear();
                    Doubles_BedBreak_Top.clear();
                    Doubles_FinalKills_Top.clear();
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 2v2_Kills DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Doubles_Kills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("2v2_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 2v2_Wins DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Doubles_Wins_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("2v2_Wins"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 2v2_Final_Kills DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Doubles_FinalKills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("2v2_Final_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 2v2_Bed_Destroyed DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Doubles_BedBreak_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("2v2_Bed_Destroyed"));
                    }
                    /** Triple **/
                    Triple_Kills_Top.clear();
                    Triple_Wins_Top.clear();
                    Triple_BedBreak_Top.clear();
                    Triple_FinalKills_Top.clear();
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 3v3v3v3_Kills DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Triple_Kills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("3v3v3v3_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 3v3v3v3_Wins DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Triple_Wins_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("3v3v3v3_Wins"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 3v3v3v3_Final_Kills DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Triple_FinalKills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("3v3v3v3_Final_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 3v3v3v3_Bed_Destroyed DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Triple_BedBreak_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("3v3v3v3_Bed_Destroyed"));
                    }
                    /** Quad **/
                    Quad_Kills_Top.clear();
                    Quad_Wins_Top.clear();
                    Quad_BedBreak_Top.clear();
                    Quad_FinalKills_Top.clear();
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 4v4v4v4_Kills DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Quad_Kills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("4v4v4v4_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 4v4v4v4_Wins DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Quad_Wins_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("4v4v4v4_Wins"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 4v4v4v4_Final_Kills DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Quad_FinalKills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("4v4v4v4_Final_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 4v4v4v4_Bed_Destroyed DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        Quad_BedBreak_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("4v4v4v4_Bed_Destroyed"));
                    }
                    /** FourvFour **/
                    FourvFour_Kills_Top.clear();
                    FourvFour_Wins_Top.clear();
                    FourvFour_BedBreak_Top.clear();
                    FourvFour_FinalKills_Top.clear();
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 4v4_Kills DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        FourvFour_Kills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("4v4_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 4v4_Wins DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        FourvFour_Wins_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("4v4_Wins"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 4v4_Final_Kills DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        FourvFour_FinalKills_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("4v4_Final_Kills"));
                    }
                    sql = Main.getConnection().prepareStatement("SELECT * FROM bw_stats ORDER BY 4v4_Bed_Destroyed DESC LIMIT 10");
                    rs = sql.executeQuery();
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        FourvFour_BedBreak_Top.put(GetPlayerData.getInfo(name, "Prefix") + name + " " + GetPlayerData.getInfo(name, "Suffix"), rs.getString("4v4_Bed_Destroyed"));
                    }
                    System.out.println("[HauvongMC_Support] Đã tải lại hệ thống top");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        },0 , 6000);
    }
    public static void createLeaderboard(Player p) {
        int i = 0;
        List<Hologram> holograms = new ArrayList<>();
        for (Location loc : Main.leaderboards_location) {
            Hologram hologram = HologramsAPI.createHologram(Main.getPlugin(), loc);
            switch (i) {
                case 0:
                    hologram.appendTextLine("§9§lCấp Độ Bed Wars");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§b" + x + ". §f%ajlb_lb_bw1058_player_level_raw_" + x + "_prefix%%ajlb_lb_bw1058_player_level_raw_" + x + "_name% %ajlb_lb_bw1058_player_level_raw_1_suffix% §7- §b%ajlb_lb_bw1058_player_level_raw_" + x + "_value%");
                        hologram.appendTextLine("");
                    }
                    break;
                case 1:
                    hologram.appendTextLine("§9§lTổng Hạ Gục");
                    hologram.appendTextLine("§7Tất cả chế độ");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§b" + x +". §f%ajlb_lb_bw1058_stats_kills_" + x +"_prefix%%ajlb_lb_bw1058_stats_kills_" + x +"_name% %ajlb_lb_bw1058_stats_kills_" + x +"_suffix% §7- §b%ajlb_lb_bw1058_stats_kills_" + x +"_value%");
                        hologram.appendTextLine("");
                    }
                    hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                    hologram.appendTextLine("");
                    hologram.appendTextLine("§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                    TouchableLine topkills = (TouchableLine) hologram.getLine(hologram.size() - 3);
                    topkills.setTouchHandler(new TouchHandler()
                    {
                        @Override
                        public void onTouch(Player player)
                        {
                            final int[] dem = {0};
                            /* Solo */    if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ Đơn");
                            hologram.appendTextLine("");
                            dem[0] = 0;
                            Solo_Kills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            System.out.println("Đọc dùm t số này" + dem[0]);
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả§d§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* Doubles */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả§d§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ Đôi");
                            hologram.appendTextLine("");
                            dem[0] = 0;
                            Doubles_Kills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo§d§l Doubles§7 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* 3v3v3v3 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo§d§l Doubles§7 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ 3v3v3v3");
                            hologram.appendTextLine("");
                            dem[0] = 0;
                            Triple_Kills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles§d§l 3v3v3v3§7 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* 4v4v4v4 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles§d§l 3v3v3v3§7 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ 4v4v4v4");
                            hologram.appendTextLine("");
                            dem[0] = 0;
                            Quad_Kills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3§d§l 4v4v4v4§7 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* 4v4 */       } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3§d§l 4v4v4v4§7 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ 4v4");
                            hologram.appendTextLine("");
                            dem[0] = 0;
                            FourvFour_Kills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§d§l 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* all */        } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§d§l 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Tất cả chế độ");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§b" + x +". §f%ajlb_lb_bw1058_stats_kills_" + x +"_prefix%%ajlb_lb_bw1058_stats_kills_" + x +"_name% %ajlb_lb_bw1058_stats_kills_" + x +"_suffix% §7- §b%ajlb_lb_bw1058_stats_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                        }
                        }
                    });
                    break;
                case 2:
                    hologram.appendTextLine("§9§lTổng Chiến Thắng");
                    hologram.appendTextLine("§7Tất cả chế độ");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§b" + x +". §f%ajlb_lb_bw1058_stats_wins_" + x +"_prefix%%ajlb_lb_bw1058_stats_wins_" + x +"_name% %ajlb_lb_bw1058_stats_wins_" + x +"_suffix% §7- §b%ajlb_lb_bw1058_stats_wins_" + x +"_value%");
                        hologram.appendTextLine("");
                    }
                    hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                    hologram.appendTextLine("");
                    hologram.appendTextLine("§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                    TouchableLine topwins = (TouchableLine) hologram.getLine(hologram.size() - 3);
                    topwins.setTouchHandler(new TouchHandler()
                    {
                        @Override
                        public void onTouch(Player player)
                        {
                            final int[] dem = {0};
                            /* Solo */    if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ Đơn");
                            hologram.appendTextLine("");
                            Solo_Wins_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả§d§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* Doubles */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả§d§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ Đôi");
                            hologram.appendTextLine("");
                            Doubles_Wins_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo§d§l Doubles§7 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* 3v3v3v3 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo§d§l Doubles§7 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ 3v3v3v3");
                            hologram.appendTextLine("");
                            Triple_Wins_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles§d§l 3v3v3v3§7 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* 4v4v4v4 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles§d§l 3v3v3v3§7 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ 4v4v4v4");
                            hologram.appendTextLine("");
                            Quad_Wins_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3§d§l 4v4v4v4§7 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* 4v4 */       } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3§d§l 4v4v4v4§7 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ 4v4");
                            hologram.appendTextLine("");
                            FourvFour_Wins_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§d§l 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* all */        } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§d§l 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Tất cả chế độ");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§b" + x +". §f%ajlb_lb_bw1058_stats_wins_" + x +"_prefix%%ajlb_lb_bw1058_stats_wins_" + x +"_name% %ajlb_lb_bw1058_stats_wins_" + x +"_suffix% §7- §b%ajlb_lb_bw1058_stats_wins_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                        }
                        }
                    });
                    break;
                case 3:
                    hologram.appendTextLine("§9§lTổng Kết Liễu");
                    hologram.appendTextLine("§7Tất cả chế độ");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§b" + x +". §f%ajlb_lb_bw1058_stats_finalkills_" + x +"_prefix%%ajlb_lb_bw1058_stats_finalkills_" + x +"_name% %ajlb_lb_bw1058_stats_finalkills_" + x +"_suffix% §7- §b%ajlb_lb_bw1058_stats_finalkills_" + x +"_value%");
                        hologram.appendTextLine("");
                    }

                    hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                    hologram.appendTextLine("");
                    hologram.appendTextLine("§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                    TouchableLine topfinal_kills = (TouchableLine) hologram.getLine(hologram.size() - 3);
                    topfinal_kills.setTouchHandler(new TouchHandler()
                    {
                        @Override
                        public void onTouch(Player player)
                        {
                            final int[] dem = {0};
                            /* Solo */    if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ Đơn");
                            hologram.appendTextLine("");
                            Solo_FinalKills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả§d§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* Doubles */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả§d§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ Đôi");
                            hologram.appendTextLine("");
                            Doubles_FinalKills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo§d§l Doubles§7 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* 3v3v3v3 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo§d§l Doubles§7 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ 3v3v3v3");
                            hologram.appendTextLine("");
                            Triple_FinalKills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles§d§l 3v3v3v3§7 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* 4v4v4v4 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles§d§l 3v3v3v3§7 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ 4v4v4v4");
                            hologram.appendTextLine("");
                            Quad_FinalKills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3§d§l 4v4v4v4§7 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* 4v4 */       } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3§d§l 4v4v4v4§7 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ 4v4");
                            hologram.appendTextLine("");
                            FourvFour_FinalKills_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§d§l 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* all */        } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§d§l 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Tất cả chế độ");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§b" + x +". §f%ajlb_lb_bw1058_stats_finalkills_" + x +"_prefix%%ajlb_lb_bw1058_stats_finalkills_" + x +"_name% %ajlb_lb_bw1058_stats_finalkills_" + x +"_suffix% §7- §b%ajlb_lb_bw1058_stats_finalkills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                        }
                        }
                    });
                    break;
                case 4:
                    hologram.appendTextLine("§9§lTổng Giường Đã Phá");
                    hologram.appendTextLine("§7Tất cả chế độ");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§b" + x +". §f%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_prefix%%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_name% %ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_suffix% §7- §b%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_value%");
                        hologram.appendTextLine("");
                    }
                    hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                    hologram.appendTextLine("");
                    hologram.appendTextLine("§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                    TouchableLine topBed_Destroyed = (TouchableLine) hologram.getLine(hologram.size() - 3);
                    topBed_Destroyed.setTouchHandler(new TouchHandler()
                    {
                        @Override
                        public void onTouch(Player player)
                        {
                            final int[] dem = {0};
                            /* Solo */    if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ Đơn");
                            hologram.appendTextLine("");
                            Solo_BedBreak_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả§d§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* Doubles */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả§d§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ Đôi");
                            hologram.appendTextLine("");
                            Doubles_BedBreak_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo§d§l Doubles§7 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* 3v3v3v3 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo§d§l Doubles§7 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ 3v3v3v3");
                            hologram.appendTextLine("");
                            Triple_BedBreak_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles§d§l 3v3v3v3§7 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* 4v4v4v4 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles§d§l 3v3v3v3§7 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ 4v4v4v4");
                            hologram.appendTextLine("");
                            Quad_BedBreak_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3§d§l 4v4v4v4§7 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* 4v4 */       } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3§d§l 4v4v4v4§7 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ 4v4");
                            hologram.appendTextLine("");
                            FourvFour_BedBreak_Top.forEach((player1, kill) -> {
                                dem[0]++;
                                hologram.appendTextLine("§b" + dem[0] + "§7 " + player1 +" §7- §b" + kill);
                                hologram.appendTextLine("");
                            });
                            if (dem[0] == 0) dem[0] = 1;
                            if (dem[0] < 10) {
                                for (int i = dem[0]; i < 11; i++) {
                                    hologram.appendTextLine("§b" +i + "§7 Trống");
                                    hologram.appendTextLine("");
                                }
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§d§l 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* all */        } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§d§l 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§9§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Tất cả chế độ");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§b" + x +". §f%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_prefix%%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_name% %ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_suffix% §7- §b%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§3§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§d§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                        }
                        }
                    });
                    break;
            }
            hologram.setAllowPlaceholders(true);
            //
            Bukkit.getOnlinePlayers().forEach(player -> hologram.getVisibilityManager().hideTo(player));
            hologram.getVisibilityManager().showTo(p);
            holograms.add(hologram);
            //
            i++;
        }
        Main.leaderboards.put(p, holograms);
        for (Player p1 : Bukkit.getOnlinePlayers()) {
            if (p1 != p) {
                List<Hologram> hologramList = Main.leaderboards.get(p1);
                hologramList.forEach(hologram1 -> hologram1.getVisibilityManager().hideTo(p));
            }
        }
    }

    public static void removeLeaderboard(Player p) {
        List<Hologram> holograms = Main.leaderboards.get(p);
        for (Hologram hologram : holograms) hologram.delete();
        Main.leaderboards.remove(p);
    }

    @EventHandler
    public void playerinteract(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof ArmorStand) {
            Player player = (Player)event.getDamager();
            Location loc = event.getEntity().getLocation();
            if (loc.getX() == -12.500 && loc.getZ() == -28.500) player.sendMessage("lolll");
        }
    }
}
