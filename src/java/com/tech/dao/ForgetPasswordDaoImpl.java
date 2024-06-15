package com.tech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ForgetPasswordDaoImpl implements ForgetPasswordDao {
    private String result;
    @Override
    public String checkEmail(String email) {
        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "SELECT COUNT(*) AS emailCount FROM users WHERE email = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
           
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int emailCount = rs.getInt("emailCount");
                if (emailCount > 0) {
                    result="Email found";
                } else {
                    result="Email not found";
                }
            } else {
               result="Email not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result="Something went wrong!";
        }
        return result;
    }
}
