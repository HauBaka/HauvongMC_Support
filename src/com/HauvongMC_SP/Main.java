package com.HauvongMC_SP;

import com.HauvongMC_SP.BedWars.*;
import com.HauvongMC_SP.Cmds.GameMenuCommand;
import com.HauvongMC_SP.Cmds.PlaySoundCommand;
import com.HauvongMC_SP.Cmds.QuestCommand;
import com.HauvongMC_SP.Cmds.ShopCommand;
import com.HauvongMC_SP.Menu.GamePlayMenu;
import com.HauvongMC_SP.Menu.QuestMenu;
import com.HauvongMC_SP.Menu.Shop.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.gmail.filoghost.holographicdisplays.api.Hologram;

public class Main extends JavaPlugin {
	public static HashMap<Player, List<Hologram>> leaderboards = new HashMap<>();
	public static List<Location> leaderboards_location = new ArrayList<>();
	public static List<String> killmessageslist = new ArrayList<>(), deathcryslist = new ArrayList<>();
    public static FileConfiguration killmessages, deathcrys, deathcrysdata;
    public static FileConfiguration killmessagesdata;
    public static File configfile, killmessagesfile, killmessagedatafile, deathcryfile, deathcrydatafile;
    private static Plugin plugin;
    @Override
    public void onEnable() {
    	plugin = this;
        registerevents();
        leaderboards_location = new ArrayList<>();
        this.getCommand("specmenu").setExecutor(new Menu());
        this.getCommand("playgame").setExecutor(new GameMenuCommand());
        this.getCommand("quest").setExecutor(new QuestCommand());
        this.getCommand("playsound").setExecutor(new PlaySoundCommand());
        mysqlSetup();
        this.getCommand("shopkeeper").setExecutor(new ShopCommand());
        mysqlSetup();
        configfile = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC_Support").getDataFolder(), "killmessages.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configfile);
        killmessageslist = config.getStringList("Lists");
        //
        killmessagesfile = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC_Support").getDataFolder(), "killmessages.yml");
        killmessagedatafile = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC_Support").getDataFolder(), "killmessagesdata.yml");
        killmessages = YamlConfiguration.loadConfiguration(killmessagesfile);
        killmessagesdata = YamlConfiguration.loadConfiguration(killmessagedatafile);
        //
        deathcryfile  = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC_Support").getDataFolder(), "deathcrys.yml");
        deathcrydatafile  = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC_Support").getDataFolder(), "deathcrysdata.yml");
        deathcrys = YamlConfiguration.loadConfiguration(deathcryfile);
        deathcrysdata = YamlConfiguration.loadConfiguration(deathcrydatafile);
        deathcryslist = deathcrys.getStringList("Lists");
        Leaderboards.Loop();
                registerLeaderboardsLocation();
    }

    private void registerLeaderboardsLocation() {
    	World world = Bukkit.getWorld("world");
        leaderboards_location.add(new Location(world, 5.500, 77, -26.000));//top level-0
        leaderboards_location.add(new Location(world, -11.500, 77, -28.500));//top kills-1
        leaderboards_location.add(new Location(world, -6.500, 77, -28.500));//top final kills-2
        leaderboards_location.add(new Location(world, -1.500, 77, -28.500));//top wins-3
        leaderboards_location.add(new Location(world, 3.500, 77, -28.500));//top bed destroy-4
    }
    
    public static List<String> getkillmessageslist() {
        return killmessageslist;
    }

    public static List<String> getDeathcryslist() { return deathcryslist; }


    private void registerevents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new BedwarsArenaStartMessage(),  this);
        pm.registerEvents(new Menu(),  this);
        pm.registerEvents(new QuestMenu(),  this);
        pm.registerEvents(new MoreInfo(),  this);
        pm.registerEvents(new Quest(),  this);
        pm.registerEvents(new GamePlayMenu(),  this);
        pm.registerEvents(new MoreInfo(), this);
        new PAPIHook().register();
        pm.registerEvents(new Leaderboards(),  this);
        pm.registerEvents(new Events(), this);
        pm.registerEvents(new KillMessage(),  this);
        pm.registerEvents(new DeathCry(),  this);
    }
    
    public static Connection connection;
    public String host, database, username, password;
    public int port;
    private static File file;
    public void mysqlSetup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("HauvongMC_Support").getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        host = config.getString("mysql.host");
        port = config.getInt("mysql.port");
        database = config.getString("mysql.database");
        username = config.getString("mysql.user");
        password = config.getString("mysql.password");
        if (password == null) {
            password = "";
        }
        try{
            synchronized (this){
                if(getConnection() != null && !getConnection().isClosed()){
                    return;
                }
                Class.forName("com.mysql.jdbc.Driver");
                setConnection( DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password));
                connection = DriverManager.getConnection("jdbc:mysql://"+ this.host + ":" + this.port + "/" + this.database,this.username, this.password);
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[HauvongMC &8-&e SQL&a]&b Connected &djdbc:mysql://" + host + ":" + port + "/" + database + ", " + username + ", " + password));
            }
        }catch(SQLException e){
            e.printStackTrace();
            this.getPluginLoader().disablePlugin(this);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Plugin getPlugin() {return plugin;}
    public static Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
