package com.shivanijainish.myfirstwebapp.controller;

import com.shivanijainish.myfirstwebapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"name","password"})
public class LoginController {
    @Autowired
    LoginService ls;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String loginIndex(ModelMap model) {
        model.put( "name", "rishu" );
        return "loginPage";
    }

}
