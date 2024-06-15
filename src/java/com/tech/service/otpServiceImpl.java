package com.tech.service;

import com.tech.model.sendEmailImpl;

public class otpServiceImpl implements otpService {
    String result;
    @Override
    public String VerifyOtp(String email, String otp) {
        // This method can remain as is or can be adjusted based on other needs
        return null;
    }

    public String generateOtp() {
        sendEmailImpl sei = new sendEmailImpl();
        return sei.getRandom();
    }

    @Override
    public boolean SendEmail(String email, String otp) {
        sendEmailImpl sei = new sendEmailImpl();
        return sei.SendEmail(email, otp);
    }
}
