package com.HauvongMC_SP.BedWars;

import com.HauvongMC_SP.Main;
import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import com.andrei1058.bedwars.api.events.player.PlayerReSpawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathCry implements Listener {
    @EventHandler
    public void playerKill(PlayerReSpawnEvent event) {
        PlayDeathCrySound.play(event.getPlayer(), Main.deathcrysdata.getString("Players." + event.getPlayer().getName() + ".Current_Select"));
    }
}
