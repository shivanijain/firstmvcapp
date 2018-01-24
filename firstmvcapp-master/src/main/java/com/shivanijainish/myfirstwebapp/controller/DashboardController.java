package com.shivanijainish.myfirstwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashboardController {

    @RequestMapping("/dashboard")
    public String dashboardPage(@RequestParam String username, String password, ModelMap model) {
        if( username.equals("Shivani") && password.equals("test")) {
            model.put("access", true);
            model.put("name", username);
        } else {
            model.put("access",false);
        }
        return "dashboard";
    }
}
