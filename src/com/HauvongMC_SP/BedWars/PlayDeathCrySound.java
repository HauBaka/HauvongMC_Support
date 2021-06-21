package com.HauvongMC_SP.BedWars;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlayDeathCrySound {
    public static  void  play(Player p, String sound) {
        p.getWorld().playSound(p.getLocation(), Sound.valueOf(sound), 0.5f, 0.5f);
    }
}
