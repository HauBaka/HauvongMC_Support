package com.HauvongMC_SP.Cmds;

import com.HauvongMC_SP.BedWars.PlayDeathCrySound;
import com.HauvongMC_SP.Menu.QuestMenu;
import com.HauvongMC_SP.Players.GetPlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaySoundCommand implements CommandExecutor {
    String rank;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (label.equalsIgnoreCase("playsound")) {
            Player p = ((Player) sender).getPlayer();
            rank = GetPlayerData.getInfo(p.getName(), "Rank");
            if (rank.equalsIgnoreCase("Moderator") || rank.equalsIgnoreCase("Admin") || rank.equalsIgnoreCase("Owner") || p.isOp()) {
                if (args.length > 0) PlayDeathCrySound.play(p, args[1]);
            }
        }
        return false;
    }
}