package com.HauvongMC_SP.BedWars;

import com.HauvongMC_SP.Main;
import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DeathCry implements Listener {
    @EventHandler
    public void playerKill(PlayerKillEvent event) {
        PlayDeathCrySound.play(event.getVictim(), Main.deathcrysdata.getString("Players." + event.getVictim().getName() + ".Current_Select"));
    }
}
