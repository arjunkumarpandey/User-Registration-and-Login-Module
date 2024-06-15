package com.tech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {
    private String result;
    @Override
    public String getDao(String email, String password) {
        
        try {
            Connection con = ConnectionProvider.getConnection();
            String q = "SELECT password FROM users WHERE email = ?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, email);
           
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(password)){
                    result="Login Successfully";
                }else{
                    result="Incorrect Password!";
                }    
            } else {
                result="User not found!";
            }
        } catch (Exception e) {            
            e.printStackTrace();
            result = "Error occurred during login!";
        }
        return result;
    }
    
}
