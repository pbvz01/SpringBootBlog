package com.pbvz.springboot.app.springboot_blog.controllers;

import com.pbvz.springboot.app.springboot_blog.model.Post;
import com.pbvz.springboot.app.springboot_blog.model.User;
import com.pbvz.springboot.app.springboot_blog.service.PostService;
import com.pbvz.springboot.app.springboot_blog.service.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    SecurityService securityService;
    @Autowired
    private PostService postService;
    @GetMapping("/")
    public String getHomePage(Model model) {

        model.addAttribute("posts",postService.findPostsByCheck(true));
        return "home";
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        User user = securityService.getUserSession();
        List<Post> userPostsList = postService.findPostsByUserAndCheckIsTrue(user);
        model.addAttribute("user", user);
        model.addAttribute("userPosts",userPostsList);
        return "profile";
    }

}
