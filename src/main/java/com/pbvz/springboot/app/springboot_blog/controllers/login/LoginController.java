package com.pbvz.springboot.app.springboot_blog.controllers.login;

import com.pbvz.springboot.app.springboot_blog.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class LoginController {

    @GetMapping("/login")
    public String inputDataUser(Model model) {
        model.addAttribute("userForm", new User());
        return "login";
    }


}
