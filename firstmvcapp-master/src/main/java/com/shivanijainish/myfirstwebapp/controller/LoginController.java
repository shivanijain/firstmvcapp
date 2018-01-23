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
    @RequestMapping(value="/login", method= RequestMethod.POST )
   // @ResponseBody
    public String loginMessage(@RequestParam String username, @RequestParam String password, ModelMap model){
        if(! ls.validateUser( username, password)) {
            model.put( "message", "Invalid Credentials");
            return "login";
        }
            model.put( "name", username );
            model.put("password", password);
            return "loginPage";

    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginIndex() {
        return "login";
    }

    @RequestMapping("/index")
    public String loginPage(){
        return "login";
    }
}
