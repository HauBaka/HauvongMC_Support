package com.HauvongMC_SP.Players;

import com.HauvongMC_SP.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GetPlayerData {
    public static boolean isOnline(String player) {
        Connection connection = Main.getConnection();
        try {
            PreparedStatement rowQuery = connection.prepareStatement("SELECT * FROM `players` WHERE Name = '" + player + "'");
            ResultSet rs = rowQuery.executeQuery();
            int online = 0;
            if (rs.next()) {
                online = rs.getInt("Online_Status");
            }
            if (online == 0) {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public static String getInfo(String p, String info) {
        String value = null;
        Connection connection = Main.getConnection();
        try {
            PreparedStatement rowQuery = connection.prepareStatement("SELECT * FROM `players` WHERE Name = '" + p + "'");
            ResultSet rs = rowQuery.executeQuery();
            if (rs.next()) {
                value = rs.getString(info);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }
    public static String getInfo2(String target, String hint, String database, String type) {
        String value = null;
        Connection connection = Main.getConnection();
        try {
            PreparedStatement rowQuery = connection.prepareStatement("SELECT * FROM `" + database + "` WHERE " + hint + " = '" + target + "'");
            ResultSet rs = rowQuery.executeQuery();
            if (rs.next()) {
                value = rs.getString(type);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }

}
