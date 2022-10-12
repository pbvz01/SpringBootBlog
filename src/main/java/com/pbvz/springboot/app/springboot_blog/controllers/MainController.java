package com.pbvz.springboot.app.springboot_blog.controllers;

import com.pbvz.springboot.app.springboot_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @Autowired
    private PostService postService;
    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("posts",postService.getPosts());
        return "home";
    }
}
