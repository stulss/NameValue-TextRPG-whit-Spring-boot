package repository;

import domain.Charactor;

import java.sql.*;
import java.util.*;

// DB 접근
public class CharactorRepository {

    private Connection connection = null;

    public CharactorRepository() {
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:mem:test",
                    "sa",
                    "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------- <Create> --------------------------------
    public void createTable(){
        String tableSQL = "CREATE TABLE IF NOT EXISTS Charactor (" +
                "id LONG AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "maxHp INT NOT NULL," +
                "hp INT NOT NULL," +
                "atk INT NOT NULL," +
                "def INT NOT NULL," +
                "speed INT NOT NULL," +
                "gold INT NOT NULL," +
                "swordLv INT NOT NULL," +
                "armorLv INT NOT NULL)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(tableSQL)) {
                statement.execute();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Charactor charactor) {

        try{
                String insertSQL = "INSERT INTO Charactor (name, maxHp, hp, atk, def, speed, gold, swordLv, armorLv) " +
                        "VALUES (?, 30, 30, 2, 0, 10, 0, 0, 0)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
                insertStatement.setString(1, charactor.getName());

                insertStatement.execute();
                insertStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        try {
            String insertSQL = "INSERT INTO Charactor (name, maxHp, hp, atk, def, speed, gold, swordLv, armorLv) " +
                    "VALUES " +
                    "('',30,30,2,0,10,0,0,0)," +
                    "('',0,0,0,0,0,0,0,0) ";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
            insertStatement.execute();
            insertStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------------- <Select> --------------------------------
    public Charactor findById(Long id) {
        String selectSQL = "SELECT * FROM Charactor WHERE ID=?";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Charactor(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("maxHp"),
                        resultSet.getInt("hp"),
                        resultSet.getInt("atk"),
                        resultSet.getInt("def"),
                        resultSet.getInt("speed"),
                        resultSet.getInt("gold"),
                        resultSet.getInt("swordLv"),
                        resultSet.getInt("armorLv"));
            }

            resultSet.close();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // -------------- <UpDate> --------------------------------
    public void update_name(Charactor charactor){
        try {
            String updateSQL = "UPDATE Charactor SET name = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setString(1, charactor.getName());
            updateStatement.setLong(2, charactor.getId());

            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Charactor charactor) {
        try {
            String updateSQL = "UPDATE Charactor SET name=?," +
                    "maxHp=?," +
                    "hp=?," +
                    "atk=?," +
                    "def=?," +
                    "speed=?," +
                    "gold=?," +
                    "swordLV=?," +
                    "armorLv=? " +
                    "WHERE id=?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setString(1, charactor.getName());
            updateStatement.setInt(2, charactor.getMaxHp());
            updateStatement.setInt(3, charactor.getHp());
            updateStatement.setInt(4, charactor.getAtk());
            updateStatement.setInt(5, charactor.getDef());
            updateStatement.setInt(6, charactor.getSpeed());
            updateStatement.setInt(7, charactor.getGold());
            updateStatement.setInt(8, charactor.getSwordLv());
            updateStatement.setInt(9, charactor.getArmorLv());
            updateStatement.setLong(10, charactor.getId());

            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
