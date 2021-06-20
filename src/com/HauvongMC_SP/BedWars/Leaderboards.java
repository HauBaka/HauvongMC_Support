package com.HauvongMC_SP.BedWars;

import com.HauvongMC_SP.Main;
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

import java.util.ArrayList;
import java.util.List;

public class Leaderboards implements Listener {
    public static void createLeaderboard(Player p) {
        int i = 0;
        List<Hologram> holograms = new ArrayList<>();
        for (Location loc : Main.leaderboards_location) {
            Hologram hologram = HologramsAPI.createHologram(Main.getPlugin(), loc);
            switch (i) {
                case 0:
                    hologram.appendTextLine("§b§lCấp Độ Bed Wars");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§e" + x + ". §f%ajlb_lb_bw1058_player_level_raw_" + x + "_prefix%%ajlb_lb_bw1058_player_level_raw_" + x + "_name% %ajlb_lb_bw1058_player_level_raw_1_suffix% §7- §e%ajlb_lb_bw1058_player_level_raw_" + x + "_value%");
                        hologram.appendTextLine("");
                    }
                    break;
                case 1:
                    hologram.appendTextLine("§b§lTổng Hạ Gục");
                    hologram.appendTextLine("§7Tất cả chế độ");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§e" + x +". §f%ajlb_lb_bw1058_stats_kills_" + x +"_prefix%%ajlb_lb_bw1058_stats_kills_" + x +"_name% %ajlb_lb_bw1058_stats_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_kills_" + x +"_value%");
                        hologram.appendTextLine("");
                    }
                    hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                    hologram.appendTextLine("");
                    hologram.appendTextLine("§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                    TouchableLine topkills = (TouchableLine) hologram.getLine(hologram.size() - 3);
                    topkills.setTouchHandler(new TouchHandler()
                    {
                        @Override
                        public void onTouch(Player player)
                        {
                            /* Solo */    if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ Đơn");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {

                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_solo_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_solo_kills_" + x +"_name% %ajlb_lb_hauvongmc_solo_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_solo_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả§a§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* Doubles */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả§a§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ Đôi");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_doubles_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_doubles_kills_" + x +"_name% %ajlb_lb_hauvongmc_doubles_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_doubles_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo§a§l Doubles§7 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* 3v3v3v3 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo§a§l Doubles§7 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ 3v3v3v3");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_3v3v3v3_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_3v3v3v3_kills_" + x +"_name% %ajlb_lb_hauvongmc_3v3v3v3_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_3v3v3v3_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles§a§l 3v3v3v3§7 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* 4v4v4v4 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles§a§l 3v3v3v3§7 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ 4v4v4v4");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_4v4v4v4_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_4v4v4v4_kills_" + x +"_name% %ajlb_lb_hauvongmc_4v4v4v4_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_4v4v4v4_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3§a§l 4v4v4v4§7 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* 4v4 */       } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3§a§l 4v4v4v4§7 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Chế độ 4v4");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_4v4_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_4v4_kills_" + x +"_name% %ajlb_lb_hauvongmc_4v4_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_4v4_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§a§l 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                            /* all */        } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§a§l 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Hạ Gục");
                            hologram.appendTextLine("§7Tất cả chế độ");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_bw1058_stats_kills_" + x +"_prefix%%ajlb_lb_bw1058_stats_kills_" + x +"_name% %ajlb_lb_bw1058_stats_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topkills.getTouchHandler());
                        }
                        }
                    });
                    break;
                case 2:
                    hologram.appendTextLine("§b§lTổng Chiến Thắng");
                    hologram.appendTextLine("§7Tất cả chế độ");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§e" + x +". §f%ajlb_lb_bw1058_stats_wins_" + x +"_prefix%%ajlb_lb_bw1058_stats_wins_" + x +"_name% %ajlb_lb_bw1058_stats_wins_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_wins_" + x +"_value%");
                        hologram.appendTextLine("");
                    }
                    hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                    hologram.appendTextLine("");
                    hologram.appendTextLine("§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                    TouchableLine topwins = (TouchableLine) hologram.getLine(hologram.size() - 3);
                    topwins.setTouchHandler(new TouchHandler()
                    {
                        @Override
                        public void onTouch(Player player)
                        {
                            /* Solo */    if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ Đơn");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {

                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_solo_win_" + x +"_prefix%%ajlb_lb_hauvongmc_solo_win_" + x +"_name% %ajlb_lb_hauvongmc_solo_win_" + x +"_suffix% §7- §e%ajlb_lb_hauvongmc_solo_win_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả§a§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* Doubles */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả§a§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ Đôi");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_doubles_win_" + x +"_prefix%%ajlb_lb_hauvongmc_doubles_win_" + x +"_name% %ajlb_lb_hauvongmc_doubles_win_" + x +"_suffix% §7- §e%ajlb_lb_hauvongmc_doubles_win_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo§a§l Doubles§7 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* 3v3v3v3 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo§a§l Doubles§7 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ 3v3v3v3");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_3v3v3v3_win_" + x +"_prefix%%ajlb_lb_hauvongmc_3v3v3v3_win_" + x +"_name% %ajlb_lb_hauvongmc_3v3v3v3_win_" + x +"_suffix% §7- §e%ajlb_lb_hauvongmc_3v3v3v3_win_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles§a§l 3v3v3v3§7 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* 4v4v4v4 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles§a§l 3v3v3v3§7 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ 4v4v4v4");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_4v4v4v4_win_" + x +"_prefix%%ajlb_lb_hauvongmc_4v4v4v4_win_" + x +"_name% %ajlb_lb_hauvongmc_4v4v4v4_win_" + x +"_suffix% §7- §e%ajlb_lb_hauvongmc_4v4v4v4_win_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3§a§l 4v4v4v4§7 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* 4v4 */       } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3§a§l 4v4v4v4§7 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Chế độ 4v4");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_4v4_win_" + x +"_prefix%%ajlb_lb_hauvongmc_4v4_win_" + x +"_name% %ajlb_lb_hauvongmc_4v4_win_" + x +"_suffix% §7- §e%ajlb_lb_hauvongmc_4v4_win_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§a§l 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                            /* all */        } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§a§l 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Chiến Thắng");
                            hologram.appendTextLine("§7Tất cả chế độ");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_bw1058_stats_wins_" + x +"_prefix%%ajlb_lb_bw1058_stats_wins_" + x +"_name% %ajlb_lb_bw1058_stats_wins_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_wins_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topwins.getTouchHandler());
                        }
                        }
                    });
                    break;
                case 3:
                    hologram.appendTextLine("§b§lTổng Kết Liễu");
                    hologram.appendTextLine("§7Tất cả chế độ");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§e" + x +". §f%ajlb_lb_bw1058_stats_finalkills_" + x +"_prefix%%ajlb_lb_bw1058_stats_finalkills_" + x +"_name% %ajlb_lb_bw1058_stats_finalkills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_finalkills_" + x +"_value%");
                        hologram.appendTextLine("");
                    }
                    hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                    hologram.appendTextLine("");
                    hologram.appendTextLine("§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                    TouchableLine topfinal_kills = (TouchableLine) hologram.getLine(hologram.size() - 3);
                    topfinal_kills.setTouchHandler(new TouchHandler()
                    {
                        @Override
                        public void onTouch(Player player)
                        {
                            /* Solo */    if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ Đơn");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {

                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_solo_final_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_solo_final_kills_" + x +"_name% %ajlb_lb_hauvongmc_solo_final_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_solo_final_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả§a§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* Doubles */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả§a§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ Đôi");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_doubles_final_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_doubles_final_kills_" + x +"_name% %ajlb_lb_hauvongmc_doubles_final_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_doubles_final_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo§a§l Doubles§7 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* 3v3v3v3 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo§a§l Doubles§7 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ 3v3v3v3");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_3v3v3v3_final_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_3v3v3v3_final_kills_" + x +"_name% %ajlb_lb_hauvongmc_3v3v3v3_final_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_3v3v3v3_final_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles§a§l 3v3v3v3§7 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* 4v4v4v4 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles§a§l 3v3v3v3§7 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ 4v4v4v4");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_4v4v4v4_final_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_4v4v4v4_final_kills_" + x +"_name% %ajlb_lb_hauvongmc_4v4v4v4_final_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_4v4v4v4_final_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3§a§l 4v4v4v4§7 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* 4v4 */       } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3§a§l 4v4v4v4§7 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Chế độ 4v4");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_4v4_final_kills_" + x +"_prefix%%ajlb_lb_hauvongmc_4v4_final_kills_" + x +"_name% %ajlb_lb_hauvongmc_4v4_final_kills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_4v4_final_kills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§a§l 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                            /* all */        } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§a§l 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Kết Liễu");
                            hologram.appendTextLine("§7Tất cả chế độ");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_bw1058_stats_finalkills_" + x +"_prefix%%ajlb_lb_bw1058_stats_finalkills_" + x +"_name% %ajlb_lb_bw1058_stats_finalkills_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_finalkills_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topfinal_kills.getTouchHandler());
                        }
                        }
                    });
                    break;
                case 4:
                    hologram.appendTextLine("§b§lTổng Giường Đã Phá");
                    hologram.appendTextLine("§7Tất cả chế độ");
                    hologram.appendTextLine("");
                    for (int x = 1; x < 11; x++) {
                        hologram.appendTextLine("§e" + x +". §f%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_prefix%%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_name% %ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_value%");
                        hologram.appendTextLine("");
                    }
                    hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                    hologram.appendTextLine("");
                    hologram.appendTextLine("§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
                    TouchableLine topBed_Destroyed = (TouchableLine) hologram.getLine(hologram.size() - 3);
                    topBed_Destroyed.setTouchHandler(new TouchHandler()
                    {
                        @Override
                        public void onTouch(Player player)
                        {
                            /* Solo */    if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ Đơn");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {

                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_solo_bed_" + x +"_prefix%%ajlb_lb_hauvongmc_solo_bed_" + x +"_name% %ajlb_lb_hauvongmc_solo_bed_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_solo_Bed_Destroyed_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả§a§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* Doubles */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả§a§l Solo§7 Doubles 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ Đôi");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_doubles_bed_" + x +"_prefix%%ajlb_lb_hauvongmc_doubles_bed_" + x +"_name% %ajlb_lb_hauvongmc_doubles_bed_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_doubles_Bed_Destroyed_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo§a§l Doubles§7 3v3v3v3 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* 3v3v3v3 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo§a§l Doubles§7 3v3v3v3 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ 3v3v3v3");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_3v3v3v3_bed_" + x +"_prefix%%ajlb_lb_hauvongmc_3v3v3v3_bed_" + x +"_name% %ajlb_lb_hauvongmc_3v3v3v3_bed_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_3v3v3v3_Bed_Destroyed_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles§a§l 3v3v3v3§7 4v4v4v4 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* 4v4v4v4 */    } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles§a§l 3v3v3v3§7 4v4v4v4 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ 4v4v4v4");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_4v4v4v4_bed_" + x +"_prefix%%ajlb_lb_hauvongmc_4v4v4v4_bed_" + x +"_name% %ajlb_lb_hauvongmc_4v4v4v4_bed_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_4v4v4v4_Bed_Destroyed_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3§a§l 4v4v4v4§7 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* 4v4 */       } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3§a§l 4v4v4v4§7 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Chế độ 4v4");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_hauvongmc_4v4_bed_" + x +"_prefix%%ajlb_lb_hauvongmc_4v4_bed_" + x +"_name% %ajlb_lb_hauvongmc_4v4_bed_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_4v4_Bed_Destroyed_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§a§l 4v4");
                            TouchableLine test = (TouchableLine) hologram.getLine(hologram.size() - 3);
                            test.setTouchHandler(topBed_Destroyed.getTouchHandler());
                            /* all */        } else if (hologram.getLine(hologram.size() - 1).toString().equalsIgnoreCase("CraftTextLine [text=§7Tất cả Solo Doubles 3v3v3v3 4v4v4v4§a§l 4v4]")) {
                            player.playSound(p.getLocation(), Sound.NOTE_STICKS, 1.0f, 1.0f);
                            hologram.clearLines();
                            hologram.appendTextLine("§b§lTổng Giường Đã Phá");
                            hologram.appendTextLine("§7Tất cả chế độ");
                            hologram.appendTextLine("");
                            for (int x = 1; x < 11; x++) {
                                hologram.appendTextLine("§e" + x +". §f%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_prefix%%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_name% %ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_suffix% §7- §e%ajlb_lb_bw1058_stats_bedsdestroyed_" + x +"_value%");
                                hologram.appendTextLine("");
                            }
                            hologram.appendTextLine("§6§lNhấp để chuyển đổi!");
                            hologram.appendTextLine("");
                            hologram.appendTextLine("§a§lTất cả§7 Solo Doubles 3v3v3v3 4v4v4v4 4v4");
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
