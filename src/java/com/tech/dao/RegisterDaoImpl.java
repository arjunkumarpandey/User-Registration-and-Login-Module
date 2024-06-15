package com.tech.dao;

import com.tech.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDaoImpl implements RegisterDao {
    private String result;
    @Override
    public String saveDao(User user, String datetime) {
        try {
            Connection con=ConnectionProvider.getConnection();
            String q="insert into users(name,email,phone,password,datetime) values(?,?,?,?,?)";
            
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, datetime);
            
            int executeUpdate=pstmt.executeUpdate();
            
            if(executeUpdate==1){
                result="Register Successfully";
            }else{
                result="Something went wrong!";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            result="Something went wrong!";
        }
        return result;
    }
    
}
