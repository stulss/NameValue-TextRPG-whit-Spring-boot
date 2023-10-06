package repository;
import domain.Weapon;

import java.sql.*;
import java.util.*;

public class WeaponRepository {

    private Connection connection = null;

    public WeaponRepository() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:mem:test",
                    "sa",
                    "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------- < CREATE > --------------------------------
    public void createWeaponTable() {
        String tableSQL = "CREATE TABLE IF NOT EXISTS Weapon (" +
                "id LONG AUTO_INCREMENT PRIMARY KEY," +
                "gear INT NOT NULL," +
                "gold INT NOT NULL," +
                "itemId INT NOT NULL," +
                "lv INT NOT NULL)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(tableSQL)) {
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------------< UPDATE > -----------------------------
    public void weaponInitialize() {
        try {
            String insertSQL = "INSERT INTO Weapon (gear, gold, itemId, lv)" +
                    "VALUES" +
                    "(4, -50, 0, 1)," +
                    "(6, -100, 0, 2)," +
                    "(8, -150, 0, 3)," +
                    "(1, -30, 1, 1)," +
                    "(2, -60, 1, 2)," +
                    "(3, -90, 1, 3)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
            insertStatement.execute();
            insertStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --------------< READ >--------------------------------
    public Weapon findByItemIdLv(int itemId, int lv) {
        String selectSQL = "SELECT * FROM Weapon WHERE itemId=? AND lv=?";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {
            statement.setLong(1, itemId);
            statement.setInt(2, lv);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return new Weapon(
                        resultSet.getLong("id"),
                        resultSet.getInt("gear"),
                        resultSet.getInt("gold"),
                        resultSet.getInt("itemId"),
                        resultSet.getInt("lv"));
            }
            resultSet.close();
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // -------------- <UpDate> --------------------------------
    public void weaponUpdate(Weapon weapon){
        try {
            String updateSQL = "UPDATE Weapon SET gear=?," +
                    "gold=?," +
                    "lv=?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setInt(1, weapon.getGear());
            updateStatement.setInt(2, weapon.getGold());
            updateStatement.setInt(3, weapon.getLv());
            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}