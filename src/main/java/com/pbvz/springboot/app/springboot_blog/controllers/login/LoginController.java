package com.pbvz.springboot.app.springboot_blog.controllers.login;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class LoginController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
            return "login";
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "login";
    }


}
