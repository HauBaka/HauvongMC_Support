package com.HauvongMC_SP.BedWars;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

import com.HauvongMC_SP.Main;
import com.HauvongMC_SP.Players.GetPlayerData;

public class PAPIHook extends PlaceholderExpansion {
  public boolean persist() {
    return true;
  }
  
  public String getIdentifier() {
    return "hauvongmc";
  }
  
  public String getAuthor() {
    return "HauVongMC";
  }
  
  public String getVersion() {
    return Main.getPlugin().getDescription().getVersion();
  }
  
  public boolean canRegister() {
    return true;
  }
  
  public String Tag(Player p) {
	String tag = GetPlayerData.getInfo2(GetPlayerData.getInfo(p.getName(), "Guild"), "Name", "guilds", "Tag");
	if (tag != null) {
		return " " + tag;
	}
	return "";
  }
  
  public String onPlaceholderRequest(Player p, String identifier) {
    if (p == null)
      return ""; 
    if (identifier.equalsIgnoreCase("solo_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "1v1_Kills"); 
    if (identifier.equalsIgnoreCase("solo_final_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "1v1_Final_Kills"); 
    if (identifier.equalsIgnoreCase("solo_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "1v1_Deaths"); 
    if (identifier.equalsIgnoreCase("solo_final_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "1v1_Final_Deaths"); 
    if (identifier.equalsIgnoreCase("solo_win"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "1v1_Wins"); 
    if (identifier.equalsIgnoreCase("solo_loses"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "1v1_Loses"); 
    if (identifier.equalsIgnoreCase("solo_bed"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "1v1_Bed_Destroyed"); 
    if (identifier.equalsIgnoreCase("doubles_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "2v2_Kills"); 
    if (identifier.equalsIgnoreCase("doubles_final_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "2v2_Final_Kills"); 
    if (identifier.equalsIgnoreCase("doubles_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "2v2_Deaths"); 
    if (identifier.equalsIgnoreCase("doubles_final_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "2v2_Final_Deaths"); 
    if (identifier.equalsIgnoreCase("doubles_win"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "2v2_Wins"); 
    if (identifier.equalsIgnoreCase("doubles_loses"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "2v2_Loses"); 
    if (identifier.equalsIgnoreCase("doubles_bed"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "2v2_Bed_Destroyed"); 
    if (identifier.equalsIgnoreCase("3v3v3v3_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "3v3v3v3_Kills"); 
    if (identifier.equalsIgnoreCase("3v3v3v3_final_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "3v3v3v3_Final_Kills"); 
    if (identifier.equalsIgnoreCase("3v3v3v3_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "3v3v3v3_Deaths"); 
    if (identifier.equalsIgnoreCase("3v3v3v3_final_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "3v3v3v3_Final_Deaths"); 
    if (identifier.equalsIgnoreCase("3v3v3v3_win"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "3v3v3v3_Wins"); 
    if (identifier.equalsIgnoreCase("3v3v3v3_loses"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "3v3v3v3_Loses"); 
    if (identifier.equalsIgnoreCase("3v3v3v3_bed"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "3v3v3v3_Bed_Destroyed"); 
    if (identifier.equalsIgnoreCase("4v4v4v4_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4v4v4_Kills"); 
    if (identifier.equalsIgnoreCase("4v4v4v4_final_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4v4v4_Final_Kills"); 
    if (identifier.equalsIgnoreCase("4v4v4v4_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4v4v4_Deaths"); 
    if (identifier.equalsIgnoreCase("4v4v4v4_final_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4v4v4_Final_Deaths"); 
    if (identifier.equalsIgnoreCase("4v4v4v4_win"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4v4v4_Wins"); 
    if (identifier.equalsIgnoreCase("4v4v4v4_loses"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4v4v4_Loses"); 
    if (identifier.equalsIgnoreCase("4v4v4v4_bed"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4v4v4_Bed_Destroyed"); 
    if (identifier.equalsIgnoreCase("4v4_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4_Kills"); 
    if (identifier.equalsIgnoreCase("4v4_final_kills"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4_Final_Kills"); 
    if (identifier.equalsIgnoreCase("4v4_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4_Deaths"); 
    if (identifier.equalsIgnoreCase("4v4_final_deaths"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4_Final_Deaths"); 
    if (identifier.equalsIgnoreCase("4v4_win"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4_Wins"); 
    if (identifier.equalsIgnoreCase("4v4_loses"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4_Loses"); 
    if (identifier.equalsIgnoreCase("4v4_bed"))
        return "" + GetPlayerData.getInfo2(p.getName(), "Name", "bw_stats", "4v4_Bed_Destroyed"); 
    if (identifier.equalsIgnoreCase("tag"))
        return "" + Tag(p);
    return null;
  }
}
