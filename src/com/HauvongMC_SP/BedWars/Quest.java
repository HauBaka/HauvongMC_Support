package com.HauvongMC_SP.BedWars;

import com.HauvongMC_SP.Main;
import com.HauvongMC_SP.Players.GetPlayerData;
import com.HauvongMC_SP.Players.SetPlayerData;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import com.andrei1058.bedwars.api.events.player.PlayerBedBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
public class Quest implements Listener {
    @EventHandler
    public void win(GameEndEvent event) {
        Date now = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyyy");
        String lich = date.format(now);
        String[] day = lich.split("/");
        for (UUID uuid : event.getAliveWinners()) {
            Player p = Bukkit.getPlayer(uuid);
            //BW_First_Win_of_the_Day
            String Win_of_the_Day = GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_First_Win_of_the_Day");
            if (Win_of_the_Day.equalsIgnoreCase("1")) {
                SetPlayerData.SetInfo(p.getName(), "quests", "BW_First_Win_of_the_Day", "2");
                SetPlayerData.SetInfo(p.getName(), "quests", "BW_First_Win_of_the_Day_Date", day[0]);
                p.sendMessage("§aNhiệm vụ hàng ngày: Khởi động!");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + p.getName() + " 150");
                p.sendMessage("§8+§d250 Kinh nghiệm Bed Wars");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "bw level giveXp " + p.getName() + " 250");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mysterydust add " + p.getName() + " 15");
            }
            //BW_Sleep_Tight
            String BW_Sleep_Tight = GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_Sleep_Tight");
            if (BW_Sleep_Tight.equalsIgnoreCase("1")) {
                int BW_Sleep_Tight_Progress = Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_Sleep_Tight_Progress"));
                BW_Sleep_Tight_Progress++;
                SetPlayerData.SetInfo(p.getName(), "quests", "BW_Sleep_Tight_Progress", BW_Sleep_Tight_Progress + "");
                if (BW_Sleep_Tight_Progress >= 10) {
                    SetPlayerData.SetInfo(p.getName(), "quests", "BW_Sleep_Tight", "2");
                    SetPlayerData.SetInfo(p.getName(), "quests", "BW_Sleep_Tight_Date", day[0]);
                    p.sendMessage("§aNhiệm vụ hàng ngày: Người chơi hệ chiến!");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + p.getName() + " 5000");
                    p.sendMessage("§8+§35,000 Kinh nghiệm Bed Wars");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "bw level giveXp " + p.getName() + " 5000");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mysterydust add " + p.getName() + " 35");
                }
            }
        }
    }

    @EventHandler
    public void start(GameStateChangeEvent event) {
        if (event.getNewState().equals(GameState.playing)) {
            Date now = new Date();
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyyy");
            String lich = date.format(now);
            String[] day = lich.split("/");
            List<Player> players = event.getArena().getPlayers();
            for (Player p : players) {
                String BW_One_More_Game = GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_One_More_Game");
                if (BW_One_More_Game.equalsIgnoreCase("1")) {
                    int BW_One_More_Game_Progress = Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_One_More_Game_Progress"));
                    BW_One_More_Game_Progress++;
                    SetPlayerData.SetInfo(p.getName(), "quests", "BW_One_More_Game_Progress", BW_One_More_Game_Progress + "");
                    if (BW_One_More_Game_Progress >= 2) {
                        SetPlayerData.SetInfo(p.getName(), "quests", "BW_One_More_Game", "2");
                        SetPlayerData.SetInfo(p.getName(), "quests", "BW_One_More_Game_Date", day[0]);
                        p.sendMessage("§aNhiệm vụ hàng ngày: Một trận nữa!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + p.getName() + " 500");
                        p.sendMessage("§8+§31,000 Kinh nghiệm Bed Wars");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "bw level giveXp " + p.getName() + " 1000");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mysterydust add " + p.getName() + " 35");
                    }
                }
            }
        }
    }

    @EventHandler
    public void breakbed(PlayerBedBreakEvent event) {
        Player p = event.getPlayer();
        String BW_Bed_Removal_Co = GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_Bed_Removal_Co");
        Date now = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyyy");
        String lich = date.format(now);
        String[] day = lich.split("/");
        if (BW_Bed_Removal_Co.equalsIgnoreCase("1")) {
            int BW_Bed_Removal_Co_Progress = Integer.parseInt(GetPlayerData.getInfo2(p.getName(), "Name", "quests", "BW_Bed_Removal_Co_Progress"));
            BW_Bed_Removal_Co_Progress++;
            SetPlayerData.SetInfo(p.getName(), "quests", "BW_Bed_Removal_Co_Progress", BW_Bed_Removal_Co_Progress +"");
            if (BW_Bed_Removal_Co_Progress >= 25) {
                SetPlayerData.SetInfo(p.getName(), "quests", "BW_Bed_Removal_Co", "2");
                SetPlayerData.SetInfo(p.getName(), "quests", "BW_Bed_Removal_Co_Date", day[0]);
                p.sendMessage("§aNhiệm vụ hàng ngày: Kẻ ngủ trộm!");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + p.getName() + " 5000");
                p.sendMessage("§8+§35,000 Kinh nghiệm Bed Wars");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "bw level giveXp " + p.getName() + " 5000");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mysterydust add " + p.getName() + " 35");
            }
        }
    }

    @EventHandler
    public void playjoin(PlayerJoinEvent event) {
        RenewQuest(event.getPlayer());
    }
    private static void AddProfile(Player p) {
        Connection connection = Main.getConnection();
        try {
            Statement sql = connection.createStatement();
            sql.executeUpdate("INSERT INTO quests (Name, " +
                    "Auto_Accept, " +
                    "SW_Solo_Kills, " +
                    "SW_Solo_Kills_Progress, " +
                    "SW_Solo_Kills_Date, " +
                    "SW_Solo_Win, " +
                    "SW_Solo_Win_Progress, " +
                    "SW_Solo_Win_Date, " +
                    "SW_Team_Kills, " +
                    "SW_Team_Kills_Progress, " +
                    "SW_Team_Kills_Date, " +
                    "SW_Team_Win, " +
                    "SW_Team_Win_Progress, " +
                    "SW_Team_Win_Date, " +
                    "SW_Weekly_Kills, " +
                    "SW_Weekly_Kills_Progress, " +
                    "SW_Weekly_Kills_Date, " +
                    "SW_Tokens, " +
                    "SW_Tokens_Progress, " +
                    "SW_Tokens_Date, " +
                    "SW_Free_Loot_Chest, " +
                    "SW_Free_Loot_Chest_Progress, " +
                    "SW_Free_Loot_Chest_Date, " +
                    "BW_First_Win_of_the_Day, " +
                    "BW_First_Win_of_the_Day_Progress, " +
                    "BW_First_Win_of_the_Day_Date, " +
                    "BW_One_More_Game, " +
                    "BW_One_More_Game_Progress, " +
                    "BW_One_More_Game_Date, " +
                    "BW_Bed_Removal_Co, " +
                    "BW_Bed_Removal_Co_Progress, " +
                    "BW_Bed_Removal_Co_Date, " +
                    "BW_Sleep_Tight, " +
                    "BW_Sleep_Tight_Progress, " +
                    "BW_Sleep_Tight_Date) VALUES (" +
                    "'" + p.getName() + "', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)");
            sql.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void RenewQuest(Player p) {//0 = not, 1= start, 2 = end
        String autoaccept = GetPlayerData.getInfo2(p.getName(), "Name", "quests", "Auto_Accept");
        Long now =  System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(now);
        String[] split = date.split("/");
        List<String> Lists = new ArrayList<>();
        Lists.add("SW_Solo_Kills");
        Lists.add("SW_Solo_Win");
        Lists.add("SW_Team_Kills");
        Lists.add("SW_Team_Win");
        Lists.add("SW_Weekly_Kills");
        Lists.add("SW_Tokens");
        Lists.add("SW_Free_Loot_Chest");
        Lists.add("BW_First_Win_of_the_Day");
        Lists.add("BW_One_More_Game");
        Lists.add("BW_Bed_Removal_Co");
        Lists.add("BW_Sleep_Tight");
        if (GetPlayerData.getInfo2(p.getName(), "Name", "quests", Lists.get(0)) == null) {
            AddProfile(p);
        }
        for (int i = 0; i < Lists.size(); i++) {
            if (GetPlayerData.getInfo2(p.getName(), "Name", "quests", Lists.get(i)).equalsIgnoreCase("2")) {
                if (!GetPlayerData.getInfo2(p.getName(), "Name", "quests", Lists.get(i) + "_Date").equalsIgnoreCase(split[0])) {
                    if (autoaccept.equalsIgnoreCase("1")) {
                        SetPlayerData.SetInfo(p.getName(), "quests", Lists.get(i), "0");
                    } else {
                        SetPlayerData.SetInfo(p.getName(), "quests", Lists.get(i), "1");
                    }
                    SetPlayerData.SetInfo(p.getName(), "quests", Lists.get(i) +"_Progress", "0");
                }
            }
        }
    }
}
