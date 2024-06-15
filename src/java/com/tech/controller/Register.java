package com.tech.controller;

import com.tech.entities.User;
import com.tech.service.RegisterServiceImpl;
import com.tech.service.otpServiceImpl;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    private String result;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
       HttpSession session=request.getSession();
 
       String name=request.getParameter("name");
       String email=request.getParameter("email");
       String phone=request.getParameter("phone");
       String password=request.getParameter("password");
       String cnf_password=request.getParameter("cnf_password");
       
       if (!password.equals(cnf_password)) {
            session.setAttribute("msg", "Passwords do not match");
            session.setAttribute("name", name);
            session.setAttribute("email", email);
            session.setAttribute("phone", phone);
            response.sendRedirect("RegisterPage.jsp");
            return;
        }
       
       User user=new User(name,email,phone,password,cnf_password);
         
       RegisterServiceImpl rsi=new RegisterServiceImpl();
       result=rsi.RegisterService1(user);
       
       if("Valid".equals(result)){
           
            otpServiceImpl osi = new otpServiceImpl();
            String generatedOtp = osi.generateOtp();
            session.setAttribute("generatedOtp", generatedOtp);
            session.setAttribute("user", user);

            // Send OTP to user
            osi.SendEmail(user.getEmail(), generatedOtp);

            RequestDispatcher dispatcher = request.getRequestDispatcher("otpVerify.jsp");
            dispatcher.forward(request, response);
           
           /* Forward to OTP verification
            session.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("otpVerify.jsp");
            dispatcher.forward(request, response);  */          
       }else{
            session.setAttribute("name", user.getName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("phone", user.getPhone());
            session.setAttribute("msg", result);
            response.sendRedirect("RegisterPage.jsp");        }   
    }
}
