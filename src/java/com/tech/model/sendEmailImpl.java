package com.tech.model;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmailImpl implements sendEmmail {

    @Override
    public String getRandom() {
        Random rnd=new Random(); 
        int number=rnd.nextInt(999999);
        
        return String.format("%06d",number);
    }

    @Override
    public boolean SendEmail(String toEmail, String otp) {
        boolean flag=false;
        
        String fromEmail="gmailexample@gmail.com";
        // for password Go to Google->Manage your google account->Search(App Password->create app name-> save->copy password-> paste here
        String password="********";
        
        try {
            Properties pr=new Properties();
            // for mail use
            pr.put("mail.smtp.auth", true);
            pr.put("mail.smtp.starttls.enable",true);
            
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.port", "587");

            /*for gamil use 
            pr.put("mail.smtp.socketFactory.port", "465");          
            pr.put("mail.smtp.socketFactory.class","jakarta.net.ssl.SSLSocketFactory");*/
            
            Session session=Session.getInstance(pr,new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fromEmail,password);
                }
            });

            Message mess=new MimeMessage(session);
            
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            
            mess.setSubject("Email verification code");
            mess.setText("Registeration successfully. Please verify your account using this code: "+otp);
            
            Transport.send(mess);
            
            flag=true;
            
        } catch (Exception e) {
            e.printStackTrace();
           // System.err.println("Error occurred while sending email: " + e.getMessage());
        }
        
        return flag;
    }
    
}