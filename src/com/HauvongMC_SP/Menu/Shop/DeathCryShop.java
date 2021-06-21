package com.HauvongMC_SP.Menu.Shop;

import com.HauvongMC_SP.Main;
import com.HauvongMC_SP.Players.Coins;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class DeathCryShop {
    private static ItemStack itemStack;
    private static ItemMeta itemMeta;
    private static List<String> itemLore, deathcrys, unlocked;
    private static Inventory inventory;
    private static int slot,start, test;
    private static String colorcode, rarity, name, deathcry, currentselect;
    public static void openMain(Player p, boolean goback, int page) {
        inventory = Bukkit.createInventory(p, 54, "Cửa hàng Tiếng khóc địa ngục");
        //coins
        itemStack = new ItemStack(Material.EMERALD);
        itemMeta= itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§6https://store.luckymcvn.ga");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§7Tổng số vàng:§6 " + Coins.getcoins(p));
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(50, itemStack);
        //cosmetics
        if (goback == true) {
            itemStack = new ItemStack(Material.ARROW);
            itemMeta= itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add("§7Quay lại Hàng của tôi");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName("§aQuay lại");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(48, itemStack);
        }
        //Killmessages
        currentselect = Main.deathcrysdata.getString("Players." + p.getName() + ".Current_Select");
        unlocked = Main.deathcrysdata.getStringList("Players." +  p.getName() + ".Unlocked");
        slot = 10;
        start = page*21-21;
        deathcrys = Main.getDeathcryslist();
        if (page > 1) {
            itemStack = new ItemStack(Material.ARROW);
            itemMeta = itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            test = page;
            test--;
            itemLore.add("§7Quay lại trang " + test);
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName("§aTrang trước");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(18, itemStack);
        }
        for (int i = start; i < deathcrys.size(); i++) {
            deathcry = deathcrys.get(i);
            name = deathcry.replace("_", " ");
            itemStack = new ItemStack(Material.getMaterial(Main.deathcrys.getInt("deathcrys." + deathcry + ".ID")));
            itemMeta = itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add("§8Tiếng khóc địa ngục");
            itemLore.add(" ");
            itemLore.add("§7Tiếng khóc địa ngục " + name + "");
            itemLore.add("§7sẽ phát lên khi bạn chết.");
            itemLore.add(" ");
            itemLore.add("§eNhấp chuột phải để xem!");
            itemLore.add(" ");
            rarity = Main.killmessages.getString("deathcrys." + deathcry + ".rarity");
            colorcode = "";
            switch (rarity) {
                case "COMMON":
                    colorcode = "§a";
                    break;
                case "RARE":
                    colorcode = "§b";
                    break;
                case "EPIC":
                    colorcode = "§d";
                    break;
                case "LEGENDARY":
                    colorcode = "§6";
                    break;
            }
            itemLore.add("§7Độ hiếm: " + colorcode + rarity);
            if (currentselect.equalsIgnoreCase(deathcry)) {
                itemLore.add(" ");
                itemLore.add("§aĐã chọn!");
            } else if (unlocked.contains(deathcry)) {
                itemLore.add(" ");
                itemLore.add("§eNhấp để chọn!");
            } else {
                itemLore.add("§7Giá:§e " + Main.deathcrys.getInt("deathcrys." + deathcry + ".price"));
                itemLore.add(" ");
                itemLore.add("§eNhấp vào để mua!");
            }
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName(colorcode + name);
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(slot, itemStack);
            slot++;
            if (slot == 17 || slot == 26 || slot == 35) slot += 2;
            if (slot >= 35) {
                itemStack = new ItemStack(Material.ARROW);
                itemMeta = itemStack.getItemMeta();
                itemLore = new ArrayList<>();
                page++;
                itemLore.add("§7Sang trang " + page);
                itemMeta.setLore(itemLore);
                itemMeta.setDisplayName("§aTrang sau");
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(26, itemStack);
                break;
            }
        }
        //
        //close
        itemStack = new ItemStack(Material.BARRIER, 1);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§cĐóng");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(49, itemStack);
        //
        p.openInventory(inventory);
    }
}
