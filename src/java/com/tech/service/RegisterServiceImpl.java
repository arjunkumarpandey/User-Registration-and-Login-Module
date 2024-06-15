package com.tech.service;

import com.tech.dao.RegisterDaoImpl;
import com.tech.entities.User;
import com.tech.validation.RegisterValidationImpl;
import java.time.LocalDateTime;

public class RegisterServiceImpl implements RegisterService {
    private String result;
    @Override
    public String RegisterService1(User user){
        
        try{
            RegisterValidationImpl rsi=new RegisterValidationImpl();
            result=rsi.registerValidation(user);
            
        }catch(Exception e){
            result="SERVICE ERROR!";
            e.printStackTrace();
        }
  
        return result;
    }

    @Override
    public String RegisterService2(User user) {
       try{
           String datetime=LocalDateTime.now().toString();
           RegisterDaoImpl rdi=new RegisterDaoImpl();
           result=rdi.saveDao(user,datetime); 
        }catch(Exception e){
            result="SERVICE ERROR!";
            e.printStackTrace();
        }
        return result;
    }
}
