package com.tech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePasswordDaoImpl implements UpdatePasswordDao {

    @Override
    public String changePassword(String email, String password) {
        String result = "Something went wrong!";
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            con = ConnectionProvider.getConnection();
            String query = "UPDATE users SET password = ? WHERE email = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, password);
            pstmt.setString(2, email);
           
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                result = "Password Changed Successfully";
            } else {
                result = "No user found with that email"; 
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Database error: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            result = "Something went wrong!";
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }  
        return result;
    }

}
