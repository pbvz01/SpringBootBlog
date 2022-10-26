package com.pbvz.springboot.app.springboot_blog.controllers;

import com.pbvz.springboot.app.springboot_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    @Autowired
    private PostService postService;

    @GetMapping("/new-article")
    public String blogAdd() {
        return "blog-add";
    }

    @PostMapping("/new-article")
    public String blogPostAdd (@RequestParam String title, @RequestParam String anons,
                               @RequestParam String full_text) {
        postService.createPost(title, anons, full_text);
        return "redirect:/";
    }

    @GetMapping("/article/{id}")
    public String blogReadArticle (@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "blog-post";
    }

    @GetMapping("/article/{id}/editing")
    public String blogEdit (@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("post", postService.getPostForEditById(id));
        return "blog-edit";
    }

    @PostMapping("/article/{id}/editing")
    public String blogEdit (@RequestParam String title, @RequestParam String anons,
                            @RequestParam String full_text, @PathVariable(value = "id") long id) {

        postService.editPostById(id, title, anons, full_text);
        return "redirect:/" ;
    }

    @DeleteMapping("list-articles/{id}")
    public String blogDelete (@PathVariable(value = "id") long id) {
        postService.deletePostById(id);
        return "redirect:/";
    }


}
