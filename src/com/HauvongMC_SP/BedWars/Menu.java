package com.HauvongMC_SP.BedWars;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import com.andrei1058.bedwars.api.events.player.PlayerBedBreakEvent;
import com.andrei1058.bedwars.api.events.player.PlayerLeaveArenaEvent;
import com.andrei1058.bedwars.api.language.Language;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Menu implements Listener, CommandExecutor {

    @EventHandler
    public void invclick(InventoryClickEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase("Dịch chuyển")) {
            e.setCancelled(true);
            ItemStack i = e.getCurrentItem();
            if (i != null && i.hasItemMeta() && e.getSlot() > 9 && i.getType().equals(Material.SKULL_ITEM)) {
                Player p = (Player) e.getWhoClicked();
                String name = i.getItemMeta().getDisplayName();
                List<String> names = Arrays.asList(name.split(" "));
                String clickname = "";
                if (names.size() == 1) {
                    clickname = names.get(0).replace("§7", "").replace("§c", "")
                            .replace("§a", "").replace("§9", "").replace("§e", "")
                            .replace("§b", "").replace("§f", "").replace("§d", "").replace("§8", "");
                } else {
                    clickname = names.get(1);
                }
                Player p1 = Bukkit.getPlayer(clickname);
                if (e.isLeftClick()) {
                    p.teleport(p1);
                }
                else {
                    p.performCommand("report " + p1.getName());
                }
            }
        }
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event) {
    	Leaderboards.createLeaderboard(event.getPlayer());
    }
    
    @EventHandler
    public void PlayerQuit(PlayerQuitEvent event) {
    	Leaderboards.removeLeaderboard(event.getPlayer());
    }
    @EventHandler
    public void heal(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player) {
            IArena arena = Arena.getArenaByName(event.getEntity().getWorld().getName());
            if (arena != null) {
                for (Player p : arena.getSpectators()) {
                    if (p.getOpenInventory().getTitle().equalsIgnoreCase("Dịch chuyển")) {
                        updateinv(p);
                    }
                }
            }
        }
    }


    @EventHandler
    public void breakbed(PlayerBedBreakEvent event) {
        IArena arena = Arena.getArenaByName(event.getPlayer().getWorld().getName());
        if (arena != null) {
            for (Player p : arena.getSpectators()) {
                if (p.getOpenInventory().getTitle().equalsIgnoreCase("Dịch chuyển")) {
                    updateinv(p);
                }
            }
        }

    }

    @EventHandler
    public void onPlayerLeave(PlayerLeaveArenaEvent paramPlayerLeaveArenaEvent) {
        if (paramPlayerLeaveArenaEvent.getArena().isPlayer(paramPlayerLeaveArenaEvent.getPlayer()))
            for (Player p : paramPlayerLeaveArenaEvent.getArena().getSpectators()) {
                if (p.getOpenInventory().getTitle().equalsIgnoreCase("Dịch chuyển")) {
                    updateinv(p);
                }
            }
    }

    @EventHandler
    public void damage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {

            IArena arena = Arena.getArenaByName(event.getEntity().getWorld().getName());
            if (arena != null) {
                for (Player p : arena.getSpectators()) {
                    if (p.getOpenInventory().getTitle().equalsIgnoreCase("Dịch chuyển")) {
                        updateinv(p);
                    }
                }
            }

        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("specmenu")) {
            if (!(sender instanceof  Player)) return false;
            Player p = ((Player) sender).getPlayer();
            if (p.getWorld().getName().equalsIgnoreCase("world")) {
                return false;
            } else {
                IArena arena = Arena.getArenaByName(p.getWorld().getName());
                if (!(arena.isSpectator(p))) {
                    p.sendMessage("úm ba la xì bùa kìa con bướmmmmmmm");
                    return false;
                }
                openinv(p);
            }
        }
        return false;
    }

    private static void openinv(Player p) {
        IArena arena = Arena.getArenaByName(p.getWorld().getName());
        Inventory inventory = Bukkit.createInventory(p, 54, "Dịch chuyển");
        int[] borders = {0, 9, 18, 27, 36, 45};
        List<Integer> alive = new ArrayList<>(), dead = new ArrayList<>();

        int slot = 1;
        for (ITeam iTeam : arena.getTeams()) {
            if (!(iTeam.isBedDestroyed())) {
                int lol = slot+45;
                alive.add(lol);
            } else {
                int lol = slot+45;
                dead.add(lol);
            }
            String name = iTeam.getName();
            ItemStack team;
            String colorcode;
            switch (name) {
                default:
                    team = new ItemStack(Material.WOOL, 1, (short) 14);
                    colorcode = "§c";
                    break;
                case "Green":
                    team = new ItemStack(Material.WOOL, 1, (short) 5);
                    colorcode = "§a";
                    break;
                case "Blue":
                    team = new ItemStack(Material.WOOL, 1, (short) 11);
                    colorcode = "§9";
                    break;
                case "Yellow":
                    team = new ItemStack(Material.WOOL, 1, (short) 4);
                    colorcode = "§e";
                    break;
                case "Aqua":
                    team = new ItemStack(Material.WOOL, 1, (short) 3);
                    colorcode = "§b";
                    break;
                case "White":
                    team = new ItemStack(Material.WOOL, 1, (short) 0);
                    colorcode = "§f";
                    break;
                case "Pink":
                    team = new ItemStack(Material.WOOL, 1, (short) 2);
                    colorcode = "§d";
                    break;
                case "Gray":
                    team = new ItemStack(Material.WOOL, 1, (short) 7);
                    colorcode = "§8";
                    break;
            }
            ItemMeta itemMeta = team.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add("§eThành viên:");
            for (Player member : iTeam.getMembers()) {
                lore.add(colorcode + member.getDisplayName());
            }
            lore.add(" ");
            itemMeta.setLore(lore);
            itemMeta.setDisplayName("§6Đội " + colorcode + iTeam.getDisplayName(Language.getDefaultLanguage()));
            team.setItemMeta(itemMeta);
            inventory.setItem(slot, team);
            int backup = slot;
            slot++;
            for (Player member : iTeam.getMembers()) {
                if (!(member.isFlying()) && !(member.getAllowFlight())) {
                    ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                    SkullMeta head = (SkullMeta) itemStack.getItemMeta();
                    head.setOwner(member.getName());
                    List<String> itemLore = new ArrayList<>();
                    itemLore.add("§fMáu: §e" + (int) member.getHealth() + "§7/§a" + (int) member.getMaxHealth());
                    Location loc = member.getLocation();
                    itemLore.add("§fVị trí: §e" + (int) loc.getX() + ", " + (int) loc.getY() + ", " + (int) loc.getZ());
                    itemLore.add("");
                    itemLore.add("§eNhấp chuột trái để dịch chuyển đến!");
                    itemLore.add("§eNhấp chuột phải để tố cáo!");
                    head.setDisplayName(colorcode + member.getDisplayName());
                    head.setLore(itemLore);
                    itemStack.setItemMeta(head);
                    backup += 9;
                    inventory.setItem(backup, itemStack);
                }
            }
        }
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
        ItemMeta glassmeta = glass.getItemMeta();
        glassmeta.setDisplayName("§fLuckyMCVN.Ga");
        glass.setItemMeta(glassmeta);
        for (int i = 0; i < borders.length; i++) {
            inventory.setItem(borders[i], glass);
        }
        ItemStack alive1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
        ItemMeta alivemeta = glass.getItemMeta();
        alivemeta.setDisplayName("§aLuckyMCVN.Ga");
        alive1.setItemMeta(alivemeta);
        for (int i = 0; i <alive.size(); i++) {
            inventory.setItem(alive.get(i), alive1);
        }
        ItemStack dead1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
        ItemMeta deadmeta = glass.getItemMeta();
        deadmeta.setDisplayName("§cLuckyMCVN.Ga");
        dead1.setItemMeta(deadmeta);
        for (int i = 0; i <dead.size(); i++) {
            inventory.setItem(dead.get(i), dead1);
        }
        p.openInventory(inventory);
    }


    public static void updateinv(Player p) {
        IArena arena = Arena.getArenaByName(p.getWorld().getName());
        InventoryView inventory = p.getOpenInventory();
        if (inventory == null) return;
        int[] borders = {0, 9, 18, 27, 36, 45};
        List<Integer> alive = new ArrayList<>(), dead = new ArrayList<>();

        int slot = 1;
        for (ITeam iTeam : arena.getTeams()) {
            if (!(iTeam.isBedDestroyed())) {
                int lol = slot+45;
                alive.add(lol);
            } else {
                int lol = slot+45;
                dead.add(lol);
            }
            String name = iTeam.getName();
            ItemStack team;
            String colorcode;
            switch (name) {
                default:
                    team = new ItemStack(Material.WOOL, 1, (short) 14);
                    colorcode = "§c";
                    break;
                case "Green":
                    team = new ItemStack(Material.WOOL, 1, (short) 5);
                    colorcode = "§a";
                    break;
                case "Blue":
                    team = new ItemStack(Material.WOOL, 1, (short) 11);
                    colorcode = "§9";
                    break;
                case "Yellow":
                    team = new ItemStack(Material.WOOL, 1, (short) 4);
                    colorcode = "§e";
                    break;
                case "Aqua":
                    team = new ItemStack(Material.WOOL, 1, (short) 3);
                    colorcode = "§b";
                    break;
                case "White":
                    team = new ItemStack(Material.WOOL, 1, (short) 0);
                    colorcode = "§f";
                    break;
                case "Pink":
                    team = new ItemStack(Material.WOOL, 1, (short) 2);
                    colorcode = "§d";
                    break;
                case "Gray":
                    team = new ItemStack(Material.WOOL, 1, (short) 7);
                    colorcode = "§8";
                    break;
            }
            ItemMeta itemMeta = team.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add("§eThành viên:");
            for (Player member : iTeam.getMembers()) {
                lore.add(colorcode + member.getDisplayName());
            }
            lore.add(" ");
            itemMeta.setLore(lore);
            itemMeta.setDisplayName("§6Đội " + colorcode + iTeam.getDisplayName(Language.getDefaultLanguage()));
            team.setItemMeta(itemMeta);
            inventory.setItem(slot, team);
            int backup = slot;
            slot++;
            for (Player member : iTeam.getMembers()) {
                if (!(member.isFlying()) && !(member.getAllowFlight())) {
                    ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                    SkullMeta head = (SkullMeta) itemStack.getItemMeta();
                    head.setOwner(member.getName());
                    List<String> itemLore = new ArrayList<>();
                    itemLore.add("§fMáu: §e" + (int) member.getHealth() + "§7/§a" + (int) member.getMaxHealth());
                    Location loc = member.getLocation();
                    itemLore.add("§fVị trí: §e" + (int) loc.getX() + ", " + (int) loc.getY() + ", " + (int) loc.getZ());
                    itemLore.add("");
                    itemLore.add("§eNhấp chuột trái để dịch chuyển đến!");
                    itemLore.add("§eNhấp chuột phải để tố cáo!");
                    head.setDisplayName(colorcode + member.getDisplayName());
                    head.setLore(itemLore);
                    itemStack.setItemMeta(head);
                    backup += 9;
                    inventory.setItem(backup, itemStack);
                }
            }
        }
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
        ItemMeta glassmeta = glass.getItemMeta();
        glassmeta.setDisplayName("§fLuckyMCVN.Ga");
        glass.setItemMeta(glassmeta);
        for (int i = 0; i < borders.length; i++) {
            inventory.setItem(borders[i], glass);
        }
        ItemStack alive1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
        ItemMeta alivemeta = glass.getItemMeta();
        alivemeta.setDisplayName("§aLuckyMCVN.Ga");
        alive1.setItemMeta(alivemeta);
        for (int i = 0; i <alive.size(); i++) {
            inventory.setItem(alive.get(i), alive1);
        }
        ItemStack dead1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
        ItemMeta deadmeta = glass.getItemMeta();
        deadmeta.setDisplayName("§cLuckyMCVN.Ga");
        dead1.setItemMeta(deadmeta);
        for (int i = 0; i <dead.size(); i++) {
            inventory.setItem(dead.get(i), dead1);
        }
    }
}
