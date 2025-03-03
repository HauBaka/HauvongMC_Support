package com.HauvongMC_SP.Menu.Shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.HauvongMC_SP.Players.Coins;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ShopMenu {
    private static Inventory inventory;
    private static ItemStack itemStack;
    private static ItemMeta itemMeta;
    private static SkullMeta head;
    private static List<String> itemLore;
    public static void openMain(Player p, boolean goback) {
        inventory = Bukkit.createInventory(p, 54, "Hàng của tôi");
        //Killmessage
        itemStack = new ItemStack(Material.SIGN);
        itemMeta= itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§dKill Message");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(20, itemStack);
        //death crys
        itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        head = (SkullMeta) itemStack.getItemMeta();
        head.setOwner("HauvongMC");
        itemLore = new ArrayList<>();
        itemLore.add("");
        head.setLore(itemLore);
        head.setDisplayName("§dTiếng khóc địa ngục");
        itemStack.setItemMeta(head);
        inventory.setItem(24, itemStack);
        //coins
        itemStack = new ItemStack(Material.EMERALD);
        itemMeta= itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§3https://store.oao.net");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§7Tổng số vàng:§3 " + Coins.getcoins(p));
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(49, itemStack);
        //cosmetics
        if (goback == true) {
            itemStack = new ItemStack(Material.ARROW);
            itemMeta= itemStack.getItemMeta();
            itemLore = new ArrayList<>();
            itemLore.add("§7Quay lại Cửa hàng Bed Wars");
            itemMeta.setLore(itemLore);
            itemMeta.setDisplayName("§dQuay lại");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(48, itemStack);
        }
        //
        //close
        itemStack = new ItemStack(Material.BARRIER, 1);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§cĐóng");
        itemStack.setItemMeta(itemMeta);

        itemStack.setItemMeta(itemMeta);

        inventory.setItem(49, itemStack);
        //
        p.openInventory(inventory);
    }
}
