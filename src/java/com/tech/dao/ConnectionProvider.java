package com.tech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionProvider {
   private static Connection con;
    public static Connection getConnection(){
        try{
            if(con == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginModule", "root", "Arjun@123");
            }          
        } catch(Exception e){
            e.printStackTrace();
        }

        return con;
    }
}