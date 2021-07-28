package com.HauvongMC_SP.Menu;

import com.HauvongMC_SP.Players.GetPlayerData;
import com.HauvongMC_SP.Players.SetPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static com.HauvongMC_SP.BedWars.Quest.RenewQuest;

public class QuestMenu implements Listener {
    private static Inventory inventory;
    private static ItemStack itemStack;
    private static ItemMeta itemMeta;
    private static List<String> lore;
    private static String status, click_to_start = "§bNhấp để bắt đầu nhiệm vụ này.", started = "§dBạn đã bắt đầu nhiệm vụ này.", completed = "§cBạn đã hoàn thành nhiệm vụ này.", lore1 = "§8Nhiệm vụ hàng ngày có thể được hoàn thành!", lore2 ="§8Một lần mỗi ngày.";
    public static void openMain(Player p) {
        RenewQuest(p);
        inventory = Bukkit.createInventory(p, 36, "Nhiệm vụ BedWars");
        click_to_start = "§eNhấp để bắt đầu nhiệm vụ này.";
        started = "§aBạn đã bắt đầu nhiệm vụ này.";
        completed = "§cBạn đã hoàn thành nhiệm vụ này.";
        lore1 = "§8Nhiệm vụ hàng ngày có thể được hoàn thành!";
        lore2 ="§8Một lần mỗi ngày.";
        //first win
        itemStack = null;
        status = GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_First_Win_of_the_Day");
        if (status.equalsIgnoreCase("0") || status.equalsIgnoreCase("1")) itemStack = new ItemStack(Material.PAPER);
        else if (status.equalsIgnoreCase("2")) itemStack = new ItemStack(Material.MAP);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Thắng 1 trận BedWars");
        if (status.equalsIgnoreCase("1")) lore.add("§9(§b" + GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_First_Win_of_the_Day_Progress") + "§9/§b1§9)");
        lore.add(" ");
        lore.add("§7Phần thưởng:");
        lore.add("§8+§3250 Bedwars Experience");
        lore.add("§8+§3150 Bedwars Coins");
        lore.add(lore1);
        lore.add(lore2);
        lore.add(" ");
        if (status.equalsIgnoreCase("0")) lore.add(click_to_start);
        else if (status.equalsIgnoreCase("1")) lore.add(started);
        else lore.add(completed);
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§dNhiệm vụ: Trận thắng đầu tiên trong ngày");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(11, itemStack);
        //BW_Sleep_Tight
        itemStack = null;
        status = GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_One_More_Game");
        if (status.equalsIgnoreCase("0") || status.equalsIgnoreCase("1")) itemStack = new ItemStack(Material.PAPER);
        else if (status.equalsIgnoreCase("2")) itemStack = new ItemStack(Material.MAP);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Chơi 2 trận BedWars");
        if (status.equalsIgnoreCase("1")) lore.add("§9(§e" + GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_One_More_Game_Progress") + "§9/§b2§9)");
        lore.add(" ");
        lore.add("§7Phần thưởng:");
        lore.add("§8+§31,000 Bedwars Experience");
        lore.add("§8+§3500 Bedwars Coins");
        lore.add(lore1);
        lore.add(lore2);
        lore.add(" ");
        if (status.equalsIgnoreCase("0")) lore.add(click_to_start);
        else if (status.equalsIgnoreCase("1")) lore.add(started);
        else lore.add(completed);
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§dNhiệm vụ: Một trận nữa!");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(12, itemStack);
        //BW_Bed_Removal_Co
        itemStack = null;
        status = GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_Bed_Removal_Co");
        if (status.equalsIgnoreCase("0") || status.equalsIgnoreCase("1")) itemStack = new ItemStack(Material.PAPER);
        else if (status.equalsIgnoreCase("2")) itemStack = new ItemStack(Material.MAP);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Phá 25 giường của kẻ địch");
        if (status.equalsIgnoreCase("1")) lore.add("§9(§b" + GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_Bed_Removal_Co_Progress") + "§9/§b25§9)");
        lore.add(" ");
        lore.add("§7Phần thưởng:");
        lore.add("§8+§35,000 Bedwars Experience");
        lore.add("§8+§35,000 Bedwars Coins");
        lore.add(lore1);
        lore.add(lore2);
        lore.add(" ");
        if (status.equalsIgnoreCase("0")) lore.add(click_to_start);
        else if (status.equalsIgnoreCase("1")) lore.add(started);
        else lore.add(completed);
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§dNhiệm vụ: Kẻ ngủ trộm");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(14, itemStack);
        //sleep tight
        itemStack = null;
        status = GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_Sleep_Tight");
        if (status.equalsIgnoreCase("0") || status.equalsIgnoreCase("1")) itemStack = new ItemStack(Material.PAPER);
        else if (status.equalsIgnoreCase("2")) itemStack = new ItemStack(Material.MAP);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Thắng 10 trận BedWars");
        if (status.equalsIgnoreCase("1")) lore.add("§9(§b" + GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_Sleep_Tight_Progress") + "§9/§b10§9)");
        lore.add(" ");
        lore.add("§7Phần thưởng:");
        lore.add("§8+§35,000 Bedwars Experience");
        lore.add("§8+§35,000 Bedwars Coins");
        lore.add(lore1);
        lore.add(lore2);
        lore.add(" ");
        if (status.equalsIgnoreCase("0")) lore.add(click_to_start);
        else if (status.equalsIgnoreCase("1")) lore.add(started);
        else lore.add(completed);
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§dNhiệm vụ: Người chơi hệ chiến!");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(15, itemStack);
        //
        int status1 = Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "quests", "Auto_Accept"));
        ItemStack AutoAccept = new ItemStack(Material.INK_SACK, 1, (short) 8);
        ItemMeta AutoAccept_Meta = AutoAccept.getItemMeta();
        List<String> AutoAccept_Lore = new ArrayList<>();
        if(p.hasPermission("sw.quest.autoaccept")) {
            if (status1 == 0) {
                AutoAccept_Meta.setDisplayName("§cTự động nhận nhiệm vụ: TẮT");
                AutoAccept_Lore.add("§7Nhấp để tự động chấp nhận");
                AutoAccept_Lore.add("§7bất cứ nhiệm vụ nào khi");
                AutoAccept_Lore.add("§7bạn tham gia máy chủ.");
                AutoAccept_Lore.add("§7");
                AutoAccept_Lore.add("§bNhấp để chuyển đổi!");
            } else {
                AutoAccept = new ItemStack(Material.INK_SACK, 1, (short) 10);
                AutoAccept_Meta.setDisplayName("§aTự động nhận nhiệm vụ: BẬT");
                AutoAccept_Lore.add("§7Nhấp tắt tự động chấp nhận");
                AutoAccept_Lore.add("§7bất cứ nhiệm vụ nào khi");
                AutoAccept_Lore.add("§7bạn tham gia máy chủ.");
                AutoAccept_Lore.add("§7");
                AutoAccept_Lore.add("§bNhấp để chuyển đổi!");
            }
        }
        else {
            AutoAccept_Meta.setDisplayName("§cTự động nhận nhiệm vụ: TẮT");
            AutoAccept_Lore.add("§7Nhấp để tự động chấp nhận");
            AutoAccept_Lore.add("§7bất cứ nhiệm vụ nào khi");
            AutoAccept_Lore.add("§7bạn tham gia máy chủ.");
            AutoAccept_Lore.add("§7");
            AutoAccept_Lore.add("§cYêu cầu §bMVP§c+");
        }
        AutoAccept_Meta.setLore(AutoAccept_Lore);
        AutoAccept.setItemMeta(AutoAccept_Meta);
        inventory.setItem(35, AutoAccept);
        //review
        itemStack = new ItemStack(Material.BED);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Xem tất cả các nhiệm vụ có sẵn và");
        lore.add("§7những thử thách mà bạn có thể hoàn thành");
        lore.add("§7khi chơi BedWars");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§dBedWars Nhiệm vụ & Thử thách");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(4, itemStack);
        p.openInventory(inventory);
    }

    @EventHandler
    public void invclick(InventoryClickEvent event) {
        if (event.getInventory().getName().equalsIgnoreCase("Nhiệm vụ BedWars")) {
            ItemStack i = event.getCurrentItem();
            if (i != null && i.hasItemMeta()) {
                Player p = (Player) event.getWhoClicked();
                String name = i.getItemMeta().getDisplayName();
                String lol;
                name = name.replace("§dNhiệm vụ: ", "").replace("§cTự động nhận nhiệm vụ: ", "").replace("§aTự động nhận nhiệm vụ: ", "");
                switch (name) {
                    default:
                        lol = "BW_First_Win_of_the_Day";
                        break;
                    case "Một trận nữa!":
                        lol = "BW_One_More_Game";
                        break;
                    case "Kẻ ngủ trộm":
                        lol = "BW_Bed_Removal_Co";
                        break;
                    case "Người chơi hệ chiến!":
                        lol = "BW_Sleep_Tight";
                        break;
                    case "BẬT":
                        lol = "autoaccept";
                        break;
                    case "TẮT":
                        lol = "autoaccept";
                        break;
                }
                if (i.getType().equals(Material.INK_SACK)) {
                    if (p.hasPermission("sw.quest.autoaccept")) {
                        if (GetPlayerData.getInfo2(p.getName(), "Name", "quests", "Auto_Accept").equalsIgnoreCase("1")) {
                            SetPlayerData.SetInfo(p.getName(), "quests", "Auto_Accept", "0");
                            p.sendMessage("§dBạn đã tắt chức năng tự động nhận nhiệm vụ!");
                        } else {
                            SetPlayerData.SetInfo(p.getName(), "quests", "Auto_Accept", "1");
                            p.sendMessage("§dBạn đã bật chức năng tự động nhận nhiệm vụ!");
                        }
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0f, 1.0f);
                    } else {
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
                        p.sendMessage("§cChức năng này chỉ áp dụng cho §bMVP§c+");
                    }
                    return;
                } else {
                    if (i.getType() == Material.BED) return;
                    String status =GetPlayerData.getInfo2(p.getName(), "Name", "quests", lol);
                    if (status.equalsIgnoreCase("0")) {
                        SetPlayerData.SetInfo(p.getName(), "quests", lol, "1");
                        p.sendMessage("§dĐã bắt đầu nhiệm vụ§6 " + name);
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0f, 1.0f);
                    } else if (status.equalsIgnoreCase("1")) {
                        p.sendMessage("§cBạn đã bắt đầu nhiệm vụ§6 " + name + "§c rồi!");
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    } else {
                        p.sendMessage("§cBạn đã hoàn thành nhiệm vụ§6 " + name + "§c rồi!");
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    }
                }
                QuestMenu.openMain(p);
            }
        }
    }
}
