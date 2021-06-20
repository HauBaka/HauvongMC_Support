package com.HauvongMC_SP.Cmds;

import com.HauvongMC_SP.Menu.Shop.MainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        if (label.equalsIgnoreCase("shopkeeper")) {
            MainMenu.openMain(((Player) sender).getPlayer());
        }
        return false;
    }
}
