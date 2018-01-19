package com.shivanijainish.myfirstwebapp.service;

import org.springframework.stereotype.Component;


//component annotation tell the  spring boot to manage it by it own and we can autowire it to instantiate it object
@Component
public class LoginService {
    public boolean validateUser( String username, String password) {
        return (username.equalsIgnoreCase("shivani") && password.equalsIgnoreCase("jainish")
                || username.equalsIgnoreCase("rishu") && password.equalsIgnoreCase("test"));
    }
}
