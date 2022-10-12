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

    @GetMapping("/blog")
    public String blog (Model model) {
        model.addAttribute("posts", postService.getPosts());
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd() {
        return "blog-add";
    }

    @GetMapping("/blog/{id}")
    public String blogReadArticle (@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "blog-post";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit (@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("post", postService.getPostForEditById(id));
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogEdit (@RequestParam String title, @RequestParam String anons,
                            @RequestParam String full_text, @PathVariable(value = "id") long id) {

        postService.editPostById(id, title, anons, full_text);
        return "redirect:/blog" ;
    }


    @PostMapping("/blog/{id}/remove")
    public String blogDelete (@PathVariable(value = "id") long id) {
        postService.deletePostById(id);
        return "redirect:/blog";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd (@RequestParam String title, @RequestParam String anons,
                               @RequestParam String full_text) {
        postService.createPost(title, anons, full_text);
        return "redirect:/blog";
    }
}
