package com.HauvongMC_SP.Menu;

import com.HauvongMC_SP.Main;
import com.HauvongMC_SP.Players.GetPlayerData;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import com.andrei1058.bedwars.api.events.player.PlayerLeaveArenaEvent;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GamePlayMenu implements Listener {
    private static Inventory inventory;
    private static ItemStack itemStack;
    private static ItemMeta itemMeta;
    private static List<String> itemLore, lore;
    private static String rank;
    private static IArena iArena;
    private static List<IArena> arenas;
    private static int slot, start;
    private static FireworkEffectMeta fireworkEffectMeta;
    private static FireworkEffect aa;
    private static GameState status;
    public static void openMain(Player p, String mode) {
        String name;
        switch (mode) {
            default:
                name = mode;
                break;
            case "Daugiai":
                name = "Đấu Giải";
                break;
            case "Cancau":
                name = "Cần Câu";
                break;
            case "2v2":
                name = "Doubles";
                break;
            case "1v1":
                name = "Solo";
                break;
        }
        inventory = Bukkit.createInventory(p, 36, "Chơi Bed Wars");
        //bed
        itemStack = new ItemStack(Material.BED);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Chơi Bed Wars chế độ " + name);
        lore.add(" ");
        lore.add("§eNhấp để chơi!");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§aBed Wars (" + name + ")");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(12, itemStack);
        //map selector
        itemStack = new ItemStack(Material.SIGN);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Chọn bản đồ mà bạn muốn chơi");
        lore.add("§7từ danh sách của máy chủ");
        lore.add(" ");
        lore.add("§eChuột-phải để mở danh sách trận đã bắt đầu!");
        lore.add("§eChuột-trái để mở danh sách trận đang chờ/bắt đầu!");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§aChọn bản đồ (" + name + ")");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(14, itemStack);
        //rejoin
        itemStack = new ItemStack(Material.ENDER_PEARL);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Nhấp vào để quay lại trận đấu");
        lore.add("§7mà bạn vừa bị mất kết nối.");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§cNhấp vào đây để tham gia lại");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(35, itemStack);
        //close
        itemStack = new ItemStack(Material.BARRIER);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§cĐóng");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(31, itemStack);
        p.openInventory(inventory);
    }

    public static void openMapSelector(Player p, String mode, int page) {
        String name;
        switch (mode) {
            default:
                name = mode;
                break;
            case "Daugiai":
                name = "Đấu Giải";
                break;
            case "Cancau":
                name = "Cần Câu";
                break;
            case "2v2":
                name = "Doubles";
                break;
            case "1v1":
                name = "Solo";
                break;
        }
        inventory = Bukkit.createInventory(p, 54, "Bed Wars " + name);
        rank = GetPlayerData.getInfo(p.getName(), "Rank");
        //back
        itemStack = new ItemStack(Material.ARROW);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Quay lại Chơi Bed Wars");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§aQuay lại");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(49, itemStack);
        //list arena system
        arenas = new ArrayList<>();
        for (IArena iArena : Arena.getArenas()) {
            if (iArena.getStatus().equals(GameState.starting) && iArena.getGroup().equalsIgnoreCase(mode)) {
                arenas.add(iArena);
            }
        }
        for (IArena iArena : Arena.getArenas()) {
            if (!(arenas.contains(iArena))) {
                if (iArena.getStatus().equals(GameState.waiting) && iArena.getGroup().equalsIgnoreCase(mode)) {
                    if (iArena.getPlayers().size() > 0) arenas.add(iArena);
                }
            }
        }
        for (IArena iArena : Arena.getArenas()) {
            if (!(arenas.contains(iArena))) {
                if (iArena.getStatus().equals(GameState.waiting) && iArena.getGroup().equalsIgnoreCase(mode)) {
                    arenas.add(iArena);
                }
            }
        }
        slot = 10;
        start = page * 21 - 21;
        if (page > 1) {
            itemStack = new ItemStack(Material.ARROW);
            itemMeta = itemStack.getItemMeta();
            lore = new ArrayList<>();
            lore.add("§7Quay lại trang " + (page-1));
            itemMeta.setLore(lore);
            itemMeta.setDisplayName("§aTrang trước");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(18, itemStack);
        }
        for (int i = start; i < arenas.size(); i++) {
            if (arenas.get(i).getStatus().equals(GameState.playing)) {
                i++;
                if (i >= arenas.size()) break;
            }
            if (slot >= 35) {
                page++;
                itemStack = new ItemStack(Material.ARROW);
                itemMeta = itemStack.getItemMeta();
                lore = new ArrayList<>();
                lore.add("§7Sang trang " + page);
                itemMeta.setLore(lore);
                itemMeta.setDisplayName("§aTrang sau");
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(26, itemStack);
                break;
            }
            itemStack = new ItemStack(Material.FIREWORK_CHARGE);
            fireworkEffectMeta = (FireworkEffectMeta) itemStack.getItemMeta();
            aa = FireworkEffect.builder().withColor(Color.GREEN).build();
            status = arenas.get(i).getStatus();
            if (status.equals(GameState.starting)) {
                aa = FireworkEffect.builder().withColor(Color.ORANGE).build();
            } else if (arenas.get(i).getPlayers().size() > 0) {
                aa = FireworkEffect.builder().withColor(Color.YELLOW).build();
            }
            String STS = status.name();
            
            String arena = "";
            switch (STS) {
                case "waiting":
                    arena = "§aĐang chờ";
                    break;
                case "starting":
                    arena = "§6Đang bắt đầu";
                    break;
                case "playing":
                    arena = "§cĐang chơi";
                    break;
                case "restarting":
                    arena = "§cKết thúc";
                    break;
            }
            fireworkEffectMeta.setEffect(aa);
            lore = new ArrayList<>();
            lore.add("§8" + name);
            lore.add(" ");
            lore.add("§7Trạng thái: " + arena);
            lore.add("§7Người chơi: §e" + arenas.get(i).getPlayers().size() + "§b/§e"+ arenas.get(i).getMaxPlayers());
            lore.add("");
            if ((rank.equalsIgnoreCase("Default")) || (rank.equalsIgnoreCase("VIP")) || (rank.equalsIgnoreCase("VIP+")) || (rank.equalsIgnoreCase("MVP"))) {
                lore.add("§cBạn cần có rank §bMVP§c+");
            } else  lore.add("§eNhấp để tham gia!");
            fireworkEffectMeta.setLore(lore);
            fireworkEffectMeta.setDisplayName("§a" + arenas.get(i).getDisplayName());
            itemStack.setItemMeta(fireworkEffectMeta);
            inventory.setItem(slot, itemStack);
            slot++;
            if (slot == 8 || slot == 17 || slot == 26) slot+=2;

        }
        itemStack = new ItemStack(Material.ARROW);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Quay lại Chơi Bed Wars");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§aQuay lại");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(49, itemStack);
        p.openInventory(inventory);
    }

    public static void openStartedMap(Player p, String mode, int page) {
        String name;
        switch (mode) {
            default:
                name = mode;
                break;
            case "Daugiai":
                name = "Đấu Giải";
                break;
            case "Cancau":
                name = "Cần Câu";
                break;
            case "2v2":
                name = "Doubles";
                break;
            case "1v1":
                name = "Solo";
                break;
        }
        inventory = Bukkit.createInventory(p, 54, "Bed Wars§0 " + name);
        rank = GetPlayerData.getInfo(p.getName(), "Rank");
        //back
        itemStack = new ItemStack(Material.ARROW);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Quay lại Chơi Bed Wars");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§aQuay lại");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(49, itemStack);
        //list arena system
        arenas = new ArrayList<>();
        for (IArena iArena : Arena.getArenas()) {
            if (iArena.getStatus().equals(GameState.playing) && iArena.getGroup().equalsIgnoreCase(mode)) {
                arenas.add(iArena);
            }
        }
        slot = 10;
        start = page * 21 - 21;
        if (page > 1) {
            itemStack = new ItemStack(Material.ARROW);
            itemMeta = itemStack.getItemMeta();
            lore = new ArrayList<>();
            lore.add("§7Quay lại trang " + (page-1));
            itemMeta.setLore(lore);
            itemMeta.setDisplayName("§aTrang trước");
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(18, itemStack);
        }
        for (int i = start; i < arenas.size(); i++) {
            if (slot >= 35) {
                page++;
                itemStack = new ItemStack(Material.ARROW);
                itemMeta = itemStack.getItemMeta();
                lore = new ArrayList<>();
                lore.add("§7Sang trang " + page);
                itemMeta.setLore(lore);
                itemMeta.setDisplayName("§aTrang sau");
                itemStack.setItemMeta(itemMeta);
                inventory.setItem(26, itemStack);
                break;
            }
            itemStack = new ItemStack(Material.FIREWORK_CHARGE);
            fireworkEffectMeta = (FireworkEffectMeta) itemStack.getItemMeta();
            aa = FireworkEffect.builder().withColor(Color.RED).build();
            status = arenas.get(i).getStatus();
            String STS = status.name();
            
            String arena = "";
            switch (STS) {
                case "waiting":
                    arena = "§aĐang chờ";
                    break;
                case "starting":
                    arena = "§6Đang bắt đầu";
                    break;
                case "playing":
                    arena = "§cĐang chơi";
                    break;
                case "restarting":
                    arena = "§cKết thúc";
                    break;
            }
            fireworkEffectMeta.setEffect(aa);
            lore = new ArrayList<>();
            lore.add("§8" + name);
            lore.add(" ");
            lore.add("§7Trạng thái: " + arena);
            lore.add("§7Người chơi: §e" + arenas.get(i).getPlayers().size() + "§b/§e"+ arenas.get(i).getMaxPlayers());
            lore.add("");
            lore.add("§eNhấp để theo dõi!");
            fireworkEffectMeta.setLore(lore);
            fireworkEffectMeta.setDisplayName("§c" + arenas.get(i).getDisplayName());
            itemStack.setItemMeta(fireworkEffectMeta);
            inventory.setItem(slot, itemStack);
            slot++;
            if (slot == 8 || slot == 17 || slot == 26) slot+=2;

        }
        itemStack = new ItemStack(Material.ARROW);
        itemMeta = itemStack.getItemMeta();
        lore = new ArrayList<>();
        lore.add("§7Quay lại Chơi Bed Wars");
        itemMeta.setLore(lore);
        itemMeta.setDisplayName("§aQuay lại");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(49, itemStack);
        p.openInventory(inventory);
    }

    @EventHandler
    public void invlick(InventoryClickEvent event) {
        if (event.getInventory().getName().equalsIgnoreCase("Chơi Bed Wars")) {
            ItemStack i = event.getCurrentItem();
            if (i != null && i.hasItemMeta()) {
                Player p = (Player) event.getWhoClicked();
                String mode = event.getInventory().getItem(12).getItemMeta().getDisplayName().replace("§aBed Wars (", "").replace(")", "");
                switch (mode) {
                    default:
                        mode = mode;
                        break;
                    case "Đấu Giải":
                        mode = "Daugiai";
                        break;
                    case "Cần Câu":
                        mode = "Cancau";
                        break;
                }
                if (i.getType().equals(Material.BED)) {
                    p.performCommand("bw join " + mode);
                } else if (i.getType().equals(Material.SIGN)) {
                    if (event.isLeftClick()) {
                        GamePlayMenu.openMapSelector(p, mode, 1);
                    } else GamePlayMenu.openStartedMap(p, mode, 1);
                } else if (i.getType().equals(Material.ENDER_PEARL)) {
                    p.performCommand("rejoin");

                } else p.getOpenInventory().close();
            }
        } else if (event.getInventory().getName().contains("Bed Wars ") || event.getInventory().getName().contains("Bed Wars§0")) {
            ItemStack i = event.getCurrentItem();
            if (i != null && i.hasItemMeta()) {
                Player p = (Player) event.getWhoClicked();
                String mode = event.getInventory().getName().replace("Bed Wars ", "").replace("Bed Wars§0 ", "");
                switch (mode) {
                    default:
                        mode = mode;
                        break;
                    case "Đấu Giải":
                        mode = "Daugiai";
                        break;
                    case "Cần Câu":
                        mode = "Cancau";
                        break;
                    case "Solo":
                        mode = "1v1";
                        break;
                    case "Doubles":
                        mode = "2v2";
                        break;
                }
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aQuay lại")) {
                    openMain(p, mode);
                    return;
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang sau")) {
                    List<String> lore = i.getItemMeta().getLore();
                    int page = Integer.parseInt(lore.get(lore.size() - 1).replace("§7Sang trang ", ""));
                    openMapSelector(p, mode, page);
                    return;
                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aTrang trước")) {
                    List<String> lore = i.getItemMeta().getLore();
                    int page = Integer.parseInt(lore.get(lore.size() - 1).replace("§7Quay lại trang ", ""));
                    openMapSelector(p, mode, page);
                    return;
                }  else {
                    String rank = GetPlayerData.getInfo(p.getName(), "Rank");
                    if (i.getItemMeta().getDisplayName().contains("§a")) {
                        if ((rank.equalsIgnoreCase("Default")) || (rank.equalsIgnoreCase("VIP")) || (rank.equalsIgnoreCase("VIP+")) || (rank.equalsIgnoreCase("MVP"))) {
                            p.sendMessage("§cBạn cần có rank §bMVP§c+ §c để có thể sử dụng!");
                            return;
                        }
                        String name = i.getItemMeta().getDisplayName().replace("§a", "") + mode;
                        name = name.toLowerCase(Locale.ROOT);
                        p.getOpenInventory().close();
                        p.performCommand("bw join " + name);
                    } else {
                        String name = i.getItemMeta().getDisplayName().replace("§c", "") + mode;
                        name = name.toLowerCase(Locale.ROOT);
                        p.getOpenInventory().close();
                        p.performCommand("bw join " + name);
                    }
                }
            }
        }
    }

    @EventHandler
    public void playerjoingame(PlayerJoinArenaEvent event) {
        for (Player p : Bukkit.getWorld("world").getPlayers()) {
            InventoryView inventory = p.getOpenInventory();
            if (inventory != null && inventory.getTitle().contains("Bed Wars ")) {
                String mode = inventory.getTitle().replace("Bed Wars ", "");
                switch (mode) {
                    default:
                        mode = mode;
                        break;
                    case "Đấu Giải":
                        mode = "Daugiai";
                        break;
                    case "Cần Câu":
                        mode = "Cancau";
                        break;
                    case "Solo":
                        mode = "1v1";
                        break;
                    case "Doubles":
                        mode = "2v2";
                        break;
                }
                String finalMode = mode;
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        openMapSelector(p, finalMode, 1);
                    }
                }, 1);
            }
        }
    }

    @EventHandler
    public void gamestatechange(GameStateChangeEvent event) {
        if (event.getNewState().equals(GameState.playing) || event.getNewState().equals(GameState.restarting)) {
            for (Player p : Bukkit.getWorld("world").getPlayers()) {
                InventoryView inventory = p.getOpenInventory();
                if (inventory != null && inventory.getTitle().contains("Bed Wars§0")) {
                    String mode = inventory.getTitle().replace("Bed Wars§0 ", "");
                    switch (mode) {
                        default:
                            mode = mode;
                            break;
                        case "Đấu Giải":
                            mode = "Daugiai";
                            break;
                        case "Cần Câu":
                            mode = "Cancau";
                            break;
                    }
                    String finalMode = mode;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            openStartedMap(p, finalMode, 1);
                        }
                    }, 1);
                }
            }
        }
        if (event.getNewState().equals(GameState.starting) || event.getNewState().equals(GameState.waiting) || event.getNewState().equals(GameState.playing)) {
            for (Player p : Bukkit.getWorld("world").getPlayers()) {
                InventoryView inventory = p.getOpenInventory();
                if (inventory != null && inventory.getTitle().contains("Bed Wars ")) {
                    String mode = inventory.getTitle().replace("Bed Wars ", "");
                    switch (mode) {
                        default:
                            mode = mode;
                            break;
                        case "Đấu Giải":
                            mode = "Daugiai";
                            break;
                        case "Cần Câu":
                            mode = "Cancau";
                            break;
                    }
                    String finalMode = mode;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            openMapSelector(p, finalMode, 1);
                        }
                    }, 1);
                }
            }
        }
    }

    @EventHandler
    public void playerleave(PlayerLeaveArenaEvent event) {
        if (!event.getArena().getStatus().equals(GameState.restarting) && !event.getArena().getStatus().equals(GameState.playing)) {
            for (Player p : Bukkit.getWorld("world").getPlayers()) {
                InventoryView inventory = p.getOpenInventory();
                if (inventory != null && inventory.getTitle().contains("Bed Wars ")) {
                    String mode = inventory.getTitle().replace("Bed Wars ", "");
                    switch (mode) {
                        default:
                            mode = mode;
                            break;
                        case "Đấu Giải":
                            mode = "Daugiai";
                            break;
                        case "Cần Câu":
                            mode = "Cancau";
                            break;
                    }
                    String finalMode = mode;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            openMapSelector(p, finalMode, 1);
                        }
                    }, 1);
                }
            }
        }
    }
}
