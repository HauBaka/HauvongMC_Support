package com.HauvongMC_SP.BedWars;

import com.HauvongMC_SP.Main;
import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathCry implements Listener {
    @EventHandler
    public void playerKill(PlayerDeathEvent event) {
        PlayDeathCrySound.play(event.getEntity().getPlayer(), Main.deathcrysdata.getString("Players." + event.getEntity().getPlayer().getName() + ".Current_Select"));
    }
}
