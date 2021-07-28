package com.HauvongMC_SP.Menu.Shop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.HauvongMC_SP.Players.Coins;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private static Inventory inventory;
    private static ItemStack itemStack;
    private static ItemMeta itemMeta;
    private static List<String> itemLore;
    public static void openMain(Player p) {
        inventory = Bukkit.createInventory(p, 54, "Cửa hàng Bed Wars");
        //coins
        itemStack = new ItemStack(Material.EMERALD);
        itemMeta= itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§3https://store.oao.net");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§7Tổng số vàng:§3 " + Coins.getcoins(p));
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(50, itemStack);
        //cosmetics
        itemStack = new ItemStack(Material.BED);
        itemMeta= itemStack.getItemMeta();
        itemLore = new ArrayList<>();
        itemLore.add("§7Bạn có thể làm cho bạn trông");
        itemLore.add("§7chất chơi hơn sau khi ghé vô");
        itemLore.add("§7đây. Các sản phẩm trong đây");
        itemLore.add("§7bạn cũng có thể tìm thấy trong");
        itemLore.add("§3Loot Chest§7 thay vì mua.");
        itemLore.add("§7");
        itemLore.add("§cCác sản phẩm trong đây chỉ có");
        itemLore.add("§ctác dụng làm ngầu và không");
        itemLore.add("§ccó tác dụng phụ (trừ lag server)");
        itemLore.add("§cnên đừng bảo sv pay to win :((");
        itemMeta.setLore(itemLore);
        itemMeta.setDisplayName("§dCửa hàng");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(22, itemStack);
        //close
        itemStack = new ItemStack(Material.BARRIER, 1);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§cĐóng");
        itemStack.setItemMeta(itemMeta);

        inventory.setItem(49, itemStack);
        p.openInventory(inventory);
    }
}
