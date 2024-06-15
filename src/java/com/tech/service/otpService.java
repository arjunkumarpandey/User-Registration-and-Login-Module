package com.tech.service;
public interface otpService {
    public String VerifyOtp(String email,String otp);
    public boolean SendEmail(String email, String otp);
}
