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
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "sword INT ARRAY NOT NULL," +
                "armor INT ARRAY NOT NULL," +
                "swordgold INT ARRAY NOT NULL," +
                "armorgold INT ARRAY NOT NULL," +
                "lv INT ARRAY NOT NULL)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(tableSQL)) {
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        // ---------------< UPDATE > -----------------------------