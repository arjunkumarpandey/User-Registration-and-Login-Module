package com.tech.controller;

import com.tech.dao.LoginDaoImpl;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {
    String result;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        HttpSession session=request.getSession();
        
        LoginDaoImpl ldi=new LoginDaoImpl();
        result=ldi.getDao(email, password);
        
        if (result.equals("Login Successfully")) {
            session.setAttribute("success", email);
            response.sendRedirect("index.jsp");
        } else {
            session.setAttribute("msg", result);
            response.sendRedirect("LoginPage.jsp"); 
        }
    }

}
