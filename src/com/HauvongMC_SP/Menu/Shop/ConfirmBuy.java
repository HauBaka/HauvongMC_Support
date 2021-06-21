package com.HauvongMC_SP.Menu.Shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ConfirmBuy {
    private static Inventory inventory;
    private static ItemStack itemStack;
    private static ItemMeta itemMeta;
    private static List<String> itemLore;
    public static void openMain(Player p, String type, double price, String item) {
        if (type.equalsIgnoreCase("KillMessage")) {
            inventory = Bukkit.createInventory(p, 27, "Xác nhận mua Tin nhắn giết người");
            //
            itemStack = new ItemStack(Material.STAINED_CLAY, 1, (short) 13);
            itemMeta= itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add("§7Mở khóa: " + item);
            itemLore.add("§7Giá:§e " + price);
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName("§aXác nhận");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(11, itemStack);
            //
            itemStack = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
            itemMeta= itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName("§cHủy");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(15, itemStack);
            //
            p.openInventory(inventory);
        } else if (type.equalsIgnoreCase("DeathCry")) {
            inventory = Bukkit.createInventory(p, 27, "Xác nhận mua Tiếng khóc địa ngục");
            //
            itemStack = new ItemStack(Material.STAINED_CLAY, 1, (short) 13);
            itemMeta= itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add("§7Mở khóa: " + item);
            itemLore.add("§7Giá:§e " + price);
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName("§aXác nhận");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(11, itemStack);
            //
            itemStack = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
            itemMeta= itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName("§cHủy");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(15, itemStack);
            //
            p.openInventory(inventory);
        }
    }
}
