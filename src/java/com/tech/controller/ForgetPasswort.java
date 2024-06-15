package com.tech.controller;

import com.tech.dao.ForgetPasswordDaoImpl;
import com.tech.service.otpServiceImpl;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ForgetPasswort extends HttpServlet {
    private String result;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String email=request.getParameter("email");
        HttpSession session=request.getSession();
        
        ForgetPasswordDaoImpl fpdi=new ForgetPasswordDaoImpl();
        result=fpdi.checkEmail(email);
        
        if(result.equals("Email found")){
           otpServiceImpl osi = new otpServiceImpl();
           String generatedOtp = osi.generateOtp();
           session.setAttribute("generatedOtp", generatedOtp);
           session.setAttribute("email", email);
           osi.SendEmail(email, generatedOtp);
           RequestDispatcher dispatcher = request.getRequestDispatcher("ForgetOtpVerify.jsp");
           dispatcher.forward(request, response);
        }else{
            session.setAttribute("msg", result);
            response.sendRedirect("ForgetPassword.jsp"); 
        }
        
    }


}
