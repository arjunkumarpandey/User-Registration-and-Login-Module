package com.tech.controller;

import com.tech.entities.User;
import com.tech.service.otpServiceImpl;
import com.tech.service.RegisterServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "VerifyOtp", urlPatterns = {"/VerifyOtp"})
public class VerifyOtp extends HttpServlet {
    private String result;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String resend = request.getParameter("resend");

        if ("true".equals(resend)) {
            User user = (User) session.getAttribute("user");

            if (user != null) {
                otpServiceImpl osi = new otpServiceImpl();
                String generatedOtp = osi.generateOtp();
                session.setAttribute("generatedOtp", generatedOtp);
                osi.SendEmail(user.getEmail(), generatedOtp);

                session.setAttribute("msg", "A new OTP has been sent to your email.");
            } else {
                session.setAttribute("msg", "Session expired or invalid user data.");
            }
            response.sendRedirect("otpVerify.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            session.setAttribute("msg", "Session expired or invalid user data.");
            response.sendRedirect("otpVerify.jsp");
            return;
        }

        String otp = request.getParameter("otp");
        String generatedOtp = (String) session.getAttribute("generatedOtp");

        if (generatedOtp == null) {
            session.setAttribute("msg", "OTP expired or not generated.");
            response.sendRedirect("otpVerify.jsp");
            return;
        }

        if (otp != null && otp.equals(generatedOtp)) {
            RegisterServiceImpl rsi = new RegisterServiceImpl();
            result = rsi.RegisterService2(user);

            if ("Register Successfully".equals(result)) {
                session.setAttribute("msg", result);
                response.sendRedirect("LoginPage.jsp");
            } else {
                session.setAttribute("msg", result);
                response.sendRedirect("otpVerify.jsp");
            }
        } else {
            session.setAttribute("msg", "Incorrect OTP!");
            response.sendRedirect("otpVerify.jsp");
        }
    }
}
