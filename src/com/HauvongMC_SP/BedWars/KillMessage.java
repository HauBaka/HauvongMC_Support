package com.HauvongMC_SP.BedWars;

import com.HauvongMC_SP.Main;
import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.team.TeamColor;
import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.function.Function;

public class KillMessage implements Listener {
    private static String currentselect, message;
    private static EntityDamageEvent.DamageCause cause;
    TeamColor teamColor;
    @EventHandler
    public void kill(PlayerKillEvent event) {
        cause = event.getVictim().getLastDamageCause().getCause();
        currentselect = Main.killmessagesdata.getString("Players." + event.getKiller().getName() + ".Current_Select");
        message = Main.killmessages.getString("killmessages." + currentselect + ".texts.Melee");
        if (cause.equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
            message = Main.killmessages.getString("killmessages." + currentselect + ".texts.Melee");
        } else if (cause.equals(EntityDamageEvent.DamageCause.VOID)) {
            message = Main.killmessages.getString("killmessages." + currentselect + ".texts.Void");
        } else if (cause.equals(EntityDamageEvent.DamageCause.FALL)) {
            message = Main.killmessages.getString("killmessages." + currentselect + ".texts.Fall");
        } else if (cause.equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
            message = Main.killmessages.getString("killmessages." + currentselect + ".texts.Shot");
        } else if (cause.equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) || cause.equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) {
            message = "%victim §eđã bị nổ tung bởi %killer";
        } else if (cause.equals(EntityDamageEvent.DamageCause.DROWNING)) {
            message = "%victim§e đã chết đuối bởi %killer";
        }
        teamColor = BedWars.getAPI().getArenaUtil().getArenaByPlayer(event.getVictim()).getTeam(event.getVictim()).getColor();
        Function<Player, String> lol = (player) -> {
            return message.replace("%victim", teamtocolor(BedWars.getAPI().getArenaUtil().getArenaByPlayer(event.getVictim()).getTeam(event.getVictim()).getColor().toString()) + event.getVictim().getName()).replace("%killer", teamtocolor(BedWars.getAPI().getArenaUtil().getArenaByPlayer(event.getKiller()).getTeam(event.getKiller()).getColor().toString()) + event.getKiller().getName());
        };
        lol.apply(event.getKiller());
        event.setMessage(lol);
        System.out.println("killer current select: " + currentselect + " cause: " + cause.toString());
    }

    public static String teamtocolor(String teamtostring) {
        System.out.println("team can doi mau: " + teamtostring);
        switch (teamtostring) {
            case "Red":
                return "§c";
            case "Blue":
                return "§9";
            case "GREEN":
                return "§a";
            case "YELLOW":
                return "§e";
            case "AQUA":
                return "§b";
            case "WHITE":
                return "§f";
            case "PINK":
                return "§d";
            case "GRAY":
                return "§8";
        }
        return null;
    }
}
