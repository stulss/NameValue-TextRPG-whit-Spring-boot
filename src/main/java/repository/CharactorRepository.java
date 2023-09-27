package Repository;

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
        String tableSQL = "CREATE TABLE IF NOT EXISTS User (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "maxHp VARCHAR(255) NOT NULL," +
                "hp VARCHAR(255) NOT NULL," +
                "atk VARCHAR(255) NOT NULL," +
                "def VARCHAR(255) NOT NULL," +
                "speed VARCHAR(255) NOT NULL," +
                "gold VARCHAR(255) NOT NULL)";
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
                String insertSQL = "INSERT INTO Charactor (name, maxHp, hp, atk, def, speed, gold) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
                insertStatement.setString(1, charactor.getName());
                insertStatement.setInt(2, charactor.getMaxHp());
                insertStatement.setInt(3, charactor.getHp());
                insertStatement.setInt(4, charactor.getAtk());
                insertStatement.setInt(5, charactor.getDef());
                insertStatement.setInt(6, charactor.getSpeed());
                insertStatement.setInt(7, charactor.getGold());

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
                        resultSet.getInt("gold"));
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
            updateStatement.setString(1, charactor.getname());
            updateStatement.setLong(2, charactor.getid());

            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update_maxHp(Charactor charactor){
        try {
            String updateSQL = "UPDATE Charactor SET maxHp = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setInt(1, charactor.getmaxHp());
            updateStatement.setLong(2, charactor.getid());

            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update_hp(Charactor charactor){
        try{
            String updateSQL = "UPDATE Charactor SET hp = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setInt(1, charactor.gethp());
            updateStatement.setLong(2, charactor.getid());

            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update_atk(Charactor charactor){
        try{
            String updateSQL = "UPDATE Charactor SET atk = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setInt(1, charactor.getatk());
            updateStatement.setLong(2, charactor.getid());

            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update_def(Charactor charactor){
        try{
            String updateSQL = "UPDATE Charactor SET def = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setInt(1, charactor.getdef());
            updateStatement.setLong(2, charactor.getid());

            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update_gold(Charactor charactor){
        try{
            String updateSQL = "UPDATE Charactor SET gold = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setInt(1, charactor.getgold());
            updateStatement.setLong(2, charactor.getid());

            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update_speed(Charactor charactor){
        try{
            String updateSQL = "UPDATE Charactor SET speed = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setInt(1, charactor.getspeed());
            updateStatement.setLong(2, charactor.getid());

            updateStatement.executeUpdate();
            updateStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }



    // -------------- <Delete> --------------------------------



}
