package com.HauvongMC_SP.Cmds;

import com.HauvongMC_SP.Menu.GamePlayMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class GameMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player p = ((Player) sender).getPlayer();
        if (p.getWorld().getName().equalsIgnoreCase("world")) {
        	if (label.equalsIgnoreCase("playgame")) {
        		if (args.length > 0) {
        			GamePlayMenu.openMain(p, args[0]);
        		} else GamePlayMenu.openMain(p, "Solo");
        	}
        
        } else p.sendMessage("§cBạn chỉ có thể sử dụng lệnh này ở sảnh chờ!");
        return false;
    }
}
