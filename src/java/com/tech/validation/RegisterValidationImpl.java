package com.tech.validation;

import com.tech.entities.User;

public class RegisterValidationImpl implements RegisterValidation {
    private String result;
    @Override
    public String registerValidation(User user) {
        
        int name_len=user.getName().length();
        int phone_len=user.getPhone().length();
        int pass_len=user.getPassword().length();
        
        
        if(user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPhone().isEmpty() || user.getPassword().isEmpty() || user.getCnf_password().isEmpty()) {
            result="All fields are required";
        }else if(name_len<3 || name_len>26){
            result="Name size in betwwen 3 to 25";
        }else if(phone_len!=10){
            result="Number should be 10 digits";
        }else if(pass_len<5 || pass_len>26){
            result="PassWord size in between 5 to 25"; 
        }else{
           result="Valid"; 
        }
        return result;
    }
}
