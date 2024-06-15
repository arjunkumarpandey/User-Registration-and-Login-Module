package com.tech.test;

import com.tech.model.sendEmailImpl;



public class Main {
    public static void main(String[] args){
       sendEmailImpl emailSender = new sendEmailImpl();
        String otp = emailSender.getRandom();
        boolean result = emailSender.SendEmail("arjunkumarpandey626@gmail.com", otp);
        
        if (result) {
            System.out.println("Email sent successfully with OTP: " + otp);
        } else {
            System.out.println("Failed to send email.");
        }
    }
}
