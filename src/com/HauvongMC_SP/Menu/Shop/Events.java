package com.HauvongMC_SP.Menu.Shop;

import com.HauvongMC_SP.BedWars.PlayDeathCrySound;
import com.HauvongMC_SP.Main;
import com.HauvongMC_SP.Players.Coins;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Events implements Listener {
    private static List<String> unlocked;
    @EventHandler
    public void inclick(InventoryClickEvent event) {
        if (event.getInventory().getName().equalsIgnoreCase("Cửa hàng Bed Wars") || event.getInventory().getName().equalsIgnoreCase("Hàng của tôi") || event.getInventory().getName().equalsIgnoreCase("Cửa hàng KillMessage") || event.getInventory().getName().equalsIgnoreCase("Xác nhận mua Tin nhắn giết người") || event.getInventory().getName().equalsIgnoreCase("Cửa hàng Tiếng khóc địa ngục") || event.getInventory().getName().equalsIgnoreCase("Xác nhận mua Tiếng khóc địa ngục")) {
            ItemStack i = event.getCurrentItem();
            if (i != null && i.hasItemMeta()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§cĐóng"))  {
                    event.getWhoClicked().closeInventory();
                    return;
                }
                Player p = (Player) event.getWhoClicked();
                 if (event.getInventory().getName().equalsIgnoreCase("Cửa hàng Bed Wars")) {
                     if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aCửa hàng")) {
                         ShopMenu.openMain(p, true);
                     }
                 } else if (event.getInventory().getName().equalsIgnoreCase("Hàng của tôi")) {
                    if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aKill Message")) {
                        KillMessageShop.openMain(p, true, 1);
                    } else  if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTiếng khóc địa ngục")) {
                         DeathCryShop.openMain(p, true, 1);
                     } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                        MainMenu.openMain(p);
                    }
                 } else if (event.getInventory().getName().equalsIgnoreCase("Cửa hàng KillMessage")) {
                     if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang trước")) {
                         int page = Integer.parseInt(i.getItemMeta().getLore().get(i.getItemMeta().getLore().size() -1).replace("§7Quay lại trang ", ""));
                            KillMessageShop.openMain(p, true, page);
                     } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang sau")) {
                         int page = Integer.parseInt(i.getItemMeta().getLore().get(i.getItemMeta().getLore().size() -1).replace("§7Sang trang ", ""));
                         KillMessageShop.openMain(p, true, page);
                     } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                         ShopMenu.openMain(p, true);
                     } else {
                         if (event.getCurrentItem().getType() == Material.EMERALD) return;

                         Main.killmessagesdata = YamlConfiguration.loadConfiguration(Main.killmessagedatafile);
                         String name = i.getItemMeta().getDisplayName().replace("§a", "").replace("§b", "").replace("§6", "").replace("§d", "").replace(" ", "_");
                         if (event.isRightClick()) {
                             PermissionUser user = PermissionsEx.getUser(p);
                             p.closeInventory();
                             p.sendMessage("§e§l▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
                             p.sendMessage("");
                             p.sendMessage("");
                             p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.killmessages.getString("killmessages." + name + ".texts.Melee").replaceAll("%victim", ChatColor.translateAlternateColorCodes('&', "&cHauvongMC")).replaceAll("%killer", user.getSuffix() + String.valueOf(p.getName()))));
                             p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.killmessages.getString("killmessages." + name + ".texts.Void").replaceAll("%victim", ChatColor.translateAlternateColorCodes('&', "&cHauvongMC")).replaceAll("%killer", user.getSuffix() + String.valueOf(p.getName()))));
                             p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.killmessages.getString("killmessages." + name + ".texts.Fall").replaceAll("%victim", ChatColor.translateAlternateColorCodes('&', "&cHauvongMC")).replaceAll("%killer", user.getSuffix() + String.valueOf(p.getName()))));
                             p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.killmessages.getString("killmessages." + name + ".texts.Shot").replaceAll("%victim", ChatColor.translateAlternateColorCodes('&', "&cHauvongMC")).replaceAll("%killer", user.getSuffix() + String.valueOf(p.getName()))));
                             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eXuất hiện trên màn hình nạn nhân: " + Main.killmessages.getString("killmessages." + name + ".Screen")));
                             p.sendMessage("");
                             p.sendMessage("");
                             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));
                             return;
                         }
                         List<String> unlocked = Main.killmessagesdata.getStringList("Players." + p.getName() + ".Unlocked");
                         String current = Main.killmessagesdata.getString("Players." + p.getName() + ".Current_Select");
                         if (name.equalsIgnoreCase(current)) {
                             p.sendMessage("§cBạn đã chọn " + i.getItemMeta().getDisplayName() +"§c rồi!");
                             p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                         } else if (unlocked.contains(name)) {
                             Main.killmessagesdata.set("Players." + p.getName() + ".Current_Select", name);
                             try {
                                 Main.killmessagesdata.save(Main.killmessagedatafile);
                             } catch (IOException e) {
                                 e.printStackTrace();
                             }
                             p.sendMessage("§aĐã chọn " + i.getItemMeta().getDisplayName() +"§a!");
                             p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                             KillMessageShop.openMain(p, true, 1);
                         } else {
                             double price = Main.killmessages.getDouble("killmessages." + name + ".price");
                             if (price <=  Coins.getcoins(p).doubleValue()) {
                                ConfirmBuy.openMain(p, "KillMessage", price, i.getItemMeta().getDisplayName());
                             } else {
                                 p.sendMessage("§cBạn không đủ tiền!");
                                 p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                             }
                         }
                     }
                 } else if (event.getInventory().getName().equalsIgnoreCase("Xác nhận mua Tin nhắn giết người")) {
                     Main.killmessagesdata = YamlConfiguration.loadConfiguration(Main.killmessagedatafile);
                     if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aXác nhận")) {
                         unlocked = Main.killmessagesdata.getStringList("Players." + p.getName() + ".Unlocked");
                         String item = i.getItemMeta().getLore().get(i.getItemMeta().getLore().size() - 2).replace("§7Mở khóa: ", "").replace("§a", "").replace("§b", "").replace("§6", "").replace("§d", "").replace(" ", "_");
                         unlocked.add(unlocked.size(), item);
                         int price = Integer.parseInt(i.getItemMeta().getLore().get(i.getItemMeta().getLore().size() - 1).replace("§7Giá:§e ", "").replace(".0", ""));
                         Main.killmessagesdata.set("Players." + p.getName() + ".Unlocked", unlocked);
                         try {
                             Coins.removeCoins(p, price);
                             Main.killmessagesdata.save(Main.killmessagedatafile);
                             KillMessageShop.openMain(p, true, 1);
                             p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                             p.sendMessage("§aĐã mua " + item + "§a!");
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     } else {
                        KillMessageShop.openMain(p, true, 1);
                     }
                 } else if (event.getInventory().getName().equalsIgnoreCase("Cửa hàng Tiếng khóc địa ngục")) {
                     p.sendMessage("true");
                     if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang trước")) {
                         int page = Integer.parseInt(i.getItemMeta().getLore().get(i.getItemMeta().getLore().size() -1).replace("§7Quay lại trang ", ""));
                         DeathCryShop.openMain(p, true, page);
                     } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang sau")) {
                         int page = Integer.parseInt(i.getItemMeta().getLore().get(i.getItemMeta().getLore().size() -1).replace("§7Sang trang ", ""));
                         DeathCryShop.openMain(p, true, page);
                     } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                         ShopMenu.openMain(p, true);
                     } else {
                         if (event.getCurrentItem().getType() == Material.EMERALD) return;
                         Main.deathcrysdata = YamlConfiguration.loadConfiguration(Main.deathcrydatafile);
                         String name = i.getItemMeta().getDisplayName().replace("§a", "").replace("§b", "").replace("§6", "").replace("§d", "").replace(" ", "_");
                         if (event.isRightClick()) {
                             PlayDeathCrySound.play(p, name);
                            return;
                         }
                         List<String> unlocked = Main.deathcrysdata.getStringList("Players." + p.getName() + ".Unlocked");
                         String current = Main.deathcrysdata.getString("Players." + p.getName() + ".Current_Select");
                         if (name.equalsIgnoreCase(current)) {
                             p.sendMessage("§cBạn đã chọn " + i.getItemMeta().getDisplayName() +"§c rồi!");
                             p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                         } else if (unlocked.contains(name)) {
                             Main.deathcrysdata.set("Players." + p.getName() + ".Current_Select", name);
                             try {
                                 Main.deathcrysdata.save(Main.deathcrydatafile);
                             } catch (IOException e) {
                                 e.printStackTrace();
                             }
                             p.sendMessage("§aĐã chọn " + i.getItemMeta().getDisplayName() +"§a!");
                             p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                             DeathCryShop.openMain(p, true, 1);
                         } else {
                             double price = Main.deathcrys.getDouble("deathcrys." + name + ".price");
                             if (price <=  Coins.getcoins(p).doubleValue()) {
                                 ConfirmBuy.openMain(p, "DeathCry", price, i.getItemMeta().getDisplayName());
                             } else {
                                 p.sendMessage("§cBạn không đủ tiền!");
                                 p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.5f, 0.5f);
                             }
                         }
                     }
                 } else if (event.getInventory().getName().equalsIgnoreCase("Xác nhận mua Tiếng khóc địa ngục")) {
                     Main.deathcrysdata = YamlConfiguration.loadConfiguration(Main.deathcrydatafile);
                     if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aXác nhận")) {
                         unlocked = Main.deathcrysdata.getStringList("Players." + p.getName() + ".Unlocked");
                         String item = i.getItemMeta().getLore().get(i.getItemMeta().getLore().size() - 2).replace("§7Mở khóa: ", "").replace("§a", "").replace("§b", "").replace("§6", "").replace("§d", "").replace(" ", "_");
                         unlocked.add(unlocked.size(), item);
                         int price = Integer.parseInt(i.getItemMeta().getLore().get(i.getItemMeta().getLore().size() - 1).replace("§7Giá:§e ", "").replace(".0", ""));
                         Main.deathcrysdata.set("Players." + p.getName() + ".Unlocked", unlocked);
                         try {
                             Coins.removeCoins(p, price);
                             Main.deathcrysdata.save(Main.deathcrydatafile);
                             DeathCryShop.openMain(p, true, 1);
                             p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0.5f, 0.5f);
                             p.sendMessage("§aĐã mua " + item + "§a!");
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     } else {
                         DeathCryShop.openMain(p, true, 1);
                     }
                 }
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void playerjoin(PlayerJoinEvent event) {
        Main.killmessagesdata = YamlConfiguration.loadConfiguration(Main.killmessagedatafile);
        if (Main.killmessagesdata.getString("Players." + event.getPlayer().getName() + ".Current_Select") == null) {
            Main.killmessagesdata.set("Players." + event.getPlayer().getName() + ".Current_Select", "Default");
            unlocked = new ArrayList<>();
            unlocked.add(unlocked.size(), "Default");
            Main.killmessagesdata.set("Players." + event.getPlayer().getName() + ".Unlocked", unlocked);
            try {
                Main.killmessagesdata.save(Main.killmessagedatafile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Main.deathcrysdata = YamlConfiguration.loadConfiguration(Main.killmessagedatafile);
        if (Main.killmessagesdata.getString("Players." + event.getPlayer().getName() + ".Current_Select") == null) {
            Main.killmessagesdata.set("Players." + event.getPlayer().getName() + ".Current_Select", "Default");
            unlocked = new ArrayList<>();
            unlocked.add(unlocked.size(), "Default");
            Main.killmessagesdata.set("Players." + event.getPlayer().getName() + ".Unlocked", unlocked);
            try {
                Main.killmessagesdata.save(Main.killmessagedatafile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
