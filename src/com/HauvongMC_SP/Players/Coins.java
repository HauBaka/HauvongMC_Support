package com.HauvongMC_SP.Players;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.IUser;
import net.ess3.api.MaxMoneyException;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

import static org.bukkit.Bukkit.getServer;

public class Coins {
    public static BigDecimal getcoins(Player p) {
        Essentials ess = (Essentials) getServer().getPluginManager().getPlugin("Essentials");
        IUser iUser = ess.getUser(p);
        return iUser.getMoney();
    }
    public static void addCoins(Player p, int Value) {
        Essentials ess = (Essentials) getServer().getPluginManager().getPlugin("Essentials");
        IUser iUser = ess.getUser(p);
        try {
            iUser.giveMoney(BigDecimal.valueOf(Value));
        } catch (MaxMoneyException e) {
            e.printStackTrace();
        }
    }

    public static void removeCoins(Player p, int Value) {
        Essentials ess = (Essentials) getServer().getPluginManager().getPlugin("Essentials");
        IUser iUser = ess.getUser(p);
        iUser.takeMoney(BigDecimal.valueOf(Value));
    }
}
