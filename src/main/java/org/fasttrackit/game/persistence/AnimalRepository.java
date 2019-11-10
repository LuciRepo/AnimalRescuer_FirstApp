package org.fasttrackit.game.persistence;

import org.fasttrackit.game.helper.DBHelper;
import org.fasttrackit.game.pojo.Animal;

import java.sql.*;
import java.util.ArrayList;

public class AnimalRepository {
    public Animal createAnimal(Animal animal) throws SQLException{
        Connection con= DBHelper.getConnection();
        String insertString="INSERT INTO animal(id,name,age,healthLevel,hungerLevel,moodLevel,weight,color) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=con.prepareStatement(insertString);
        stmt.setInt(1,animal.getId());
        stmt.setString(2,animal.getName());
        stmt.setInt(3,animal.getAge());
        stmt.setInt(4,animal.getHealthLevel());
        stmt.setInt(5,animal.getHungerLevel());
        stmt.setInt(6,animal.getMoodLevel());
        stmt.setDouble(7,animal.getWeight());
        stmt.setString(8,animal.getColour());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
        return animal;
    }
    public ArrayList<Animal> getAnimal() throws SQLException{
        Connection con=DBHelper.getConnection();
        String selectString="SELECT * FROM animal";
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(selectString);
        ArrayList<Animal> result=new ArrayList<>();
        while (rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            int age=rs.getInt("age");
            int healthLevel=rs.getInt("healthLevel");
            int hungerLevel=rs.getInt("hungerLevel");
            int moodLevel=rs.getInt("moodLevel");
            double weight=rs.getDouble("weight");
            String color=rs.getString("color");
            Animal animal=new Animal(id,name,age,healthLevel,hungerLevel,moodLevel,weight,color);
            result.add(animal);
        }
        DBHelper.closeConnection(con);
        return result;
    }
    public void updateAnimal(Animal animal)throws SQLException{
        Connection con=DBHelper.getConnection();
        String updateString="UPDATE animal SET id=?,age=?,healthLevel=?,hungerLevel=?,moodLevel=?,weight=?,color=? WHERE name=?";
        PreparedStatement stmt=con.prepareStatement(updateString);
        stmt.setInt(1,animal.getId());
        stmt.setInt(2,animal.getAge());
        stmt.setInt(3,animal.getHealthLevel());
        stmt.setInt(4,animal.getHungerLevel());
        stmt.setInt(5,animal.getMoodLevel());
        stmt.setDouble(6,animal.getWeight());
        stmt.setString(7,animal.getColour());
        stmt.setString(8,animal.getName());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    public AnimalRepository() {
    }
}
