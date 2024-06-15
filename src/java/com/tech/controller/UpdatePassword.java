package com.tech.controller;

import com.tech.dao.UpdatePasswordDaoImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdatePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        String email = (String) session.getAttribute("email");
        
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        
        if (!password.equals(confirmPassword)) {
            session.setAttribute("msg", "Passwords do not match"); 
            response.sendRedirect("UpdatePassword.jsp");
            return;
        }
        
        if (password.length() < 5 || password.length() > 25) {
            session.setAttribute("msg", "Password must be between 5 to 25 characters"); 
            response.sendRedirect("UpdatePassword.jsp");
            return;
        }
        UpdatePasswordDaoImpl updi = new UpdatePasswordDaoImpl();
        String result = updi.changePassword(email, password);
        
        if (result.equals("Password Changed Successfully")) {
            session.setAttribute("msg", result); 
            response.sendRedirect("LoginPage.jsp");
        } else {
            session.setAttribute("msg", result); 
            response.sendRedirect("UpdatePassword.jsp");
        }
    }
}
