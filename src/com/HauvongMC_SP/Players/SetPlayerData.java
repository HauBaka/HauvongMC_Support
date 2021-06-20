package com.HauvongMC_SP.Players;

import com.HauvongMC_SP.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetPlayerData {


    public static void SetInfo(String player, String database, String type, String value) {
        Connection connection = Main.getConnection();
        try {
            Statement sql = connection.createStatement();
            sql.executeUpdate("UPDATE " + database + " SET " + type + " = '" + value + "' WHERE Name = '" + player + "'");
            sql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
