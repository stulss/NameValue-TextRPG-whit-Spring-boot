package repository;
import domain.Weapon;

import java.sql.*;
import java.util.*;

public class WeaponRepository {

    private Connection connection = null;

    public WeaponRepository() {
        try {
            Class.forName("org.h2.Driver");
            connection =DriverManager.getConnection(
                    "jdbc:h2:mem:test",
                    "sa",
                    "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------- <Create> --------------------------------
    public void createWeaponTable() {
        String tableSQL = "CREATE TABLE IF NOT EXISTS Weapon (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "gear INT ARRAY NOT NULL," +
                "gold INT ARRAY NOT NULL," +
                "lv INT ARRAY NOT NULL)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(tableSQL)) {
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save (Weapon weapon) {
        try {
            if (weapon.getId() == null)
            {
                String insertSQL = "INSERT INTO Weapon (gear, gold, lv) VALUES (?,?,?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
                insertStatement.setInt(1, Weapon.);

                insertStatement.execute();
                insertStatement.close();
            }

            }
        }catch (SQLException e) {
            e.printStackTrace();
    }


}
