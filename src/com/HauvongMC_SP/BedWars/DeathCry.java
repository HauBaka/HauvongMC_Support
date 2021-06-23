package com.HauvongMC_SP.BedWars;

import com.HauvongMC_SP.Main;
import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import com.andrei1058.bedwars.api.events.player.PlayerReSpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathCry implements Listener {
    @EventHandler
    public void playerKill(PlayerKillEvent event) {
        Main.deathcrysdata = YamlConfiguration.loadConfiguration(Main.deathcrydatafile);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                PlayDeathCrySound.play(event.getVictim().getPlayer(), Main.deathcrysdata.getString("Players." + event.getVictim().getPlayer().getName() + ".Current_Select"));
            }
        }, 3);
    }
}
