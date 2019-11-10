package org.fasttrackit.game.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Properties;

public class DBHelper {
    public static Connection getConnection(){
        Properties connectionProp=new Properties();
        connectionProp.put("user","Lus");
        connectionProp.put("password","Lus");
        String connString="jdbc:mysql://localhost:3306/animal_rescuer";
        try{
            Connection con= DriverManager.getConnection(connString,connectionProp);
            System.out.println("Conexiunea a fost deschisa");
            return con;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void closeConnection(Connection con){
        try{
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
