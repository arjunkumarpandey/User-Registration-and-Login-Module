package com.tech.controller;

import com.tech.service.otpServiceImpl;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ForgetOtpVerify extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String resend = request.getParameter("resend");
        if (resend != null && resend.equals("true")) {
            String email = (String) session.getAttribute("email");
            if (email != null) {
                // Generate new OTP
                otpServiceImpl osi = new otpServiceImpl();
                String newGeneratedOtp = osi.generateOtp();
                session.setAttribute("generatedOtp", newGeneratedOtp);
                // Send the new OTP to the user's email
                osi.SendEmail(email, newGeneratedOtp);
                session.setAttribute("msg", "A new OTP has been sent to your email.");
            } else {
                session.setAttribute("msg", "Session expired or invalid user data.");
            }
            response.sendRedirect("ForgetOtpVerify.jsp");
            return;
        }
        // Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("ForgetOtpVerify.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String otp = request.getParameter("otp");
        String generatedOtp = (String) session.getAttribute("generatedOtp");
        if (generatedOtp == null) {
            session.setAttribute("msg", "OTP expired or not generated.");
            response.sendRedirect("ForgetOtpVerify.jsp");
            return;
        }
        String email = (String) session.getAttribute("email");
        if (email == null) {
            session.setAttribute("msg", "Session expired or invalid user data.");
            response.sendRedirect("ForgetOtpVerify.jsp");
            return;
        }

        if (otp != null && otp.equals(generatedOtp)) {
            session.setAttribute("email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdatePassword.jsp");
            dispatcher.forward(request, response);
        } else {
            session.setAttribute("msg", "Incorrect OTP!");
            response.sendRedirect("ForgetOtpVerify.jsp");
        }
    }
}
