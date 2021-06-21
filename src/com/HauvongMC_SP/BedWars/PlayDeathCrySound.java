package com.HauvongMC_SP.BedWars;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlayDeathCrySound {
    public static  void  play(Player p, String sound) {
        String music = null;
        switch (sound) {
            case "Bazinga":
                music = "BLAZE_BREATH";
                break;
            case "Deflated_Toy":
                music = "BAT_DEATH";
                break;
            case "Enderman":
                music = "ENDERMAN_DEATH";
                break;
            case "Dinosaur":
                music = "CAT_MEOW";
                break;
            case "Robot_Mouse":
                music = "";
                break;
            case "Pig":
                music = "PIG_DEATH";
                break;
            case "Sad_Puppy":
                music = "WOLF_DEATH";
                break;
            case "Grumpy_Villager":
                music = "VILALGER_DEATH";
                break;
            case "Monster_Burp":
                music = "ZOMBIE_DEATH";
                break;
            case "Fireball":
                music = "GHAST_FIREBALL";
                break;
            case "Dry_bones":
                music = "SKELETON_DEATH";
                break;
            case "Ding":
                music = "ORB_PICKUP";
                break;
            case "Splash":
                music = "SPLASH2";
                break;
            case "Bat":
                music = "BAT_DEATH";
                break;
            case "Aww":
                music = "WOLF_WHINE";
                break;
            case "Gone":
                music = "DONKEY_DEATH";
                break;
            case "Howl":
                music = "WOLF_HOWL";
                break;
            case "Firework":
                music = "FIREWORK_LAUNCH";
                break;
            case "Dragon_Roar":
                music = "ENDERDRAGON_GROWL";
                break;
            case "Default":
                music = "SLIME_WALK";
                break;
        }
        if (music == null) music = "SLIME_WALK";
        p.playSound(p.getLocation(), Sound.valueOf(music), 0.5f, 0.5f);
    }
}
