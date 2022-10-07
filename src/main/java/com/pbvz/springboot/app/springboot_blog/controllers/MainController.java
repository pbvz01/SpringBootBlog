package com.pbvz.springboot.app.springboot_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String defaultPage (Model model) {
        return "home";
    }
}
