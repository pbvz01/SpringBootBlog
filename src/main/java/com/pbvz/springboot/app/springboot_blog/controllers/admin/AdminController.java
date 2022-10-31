package com.pbvz.springboot.app.springboot_blog.controllers.admin;

import com.pbvz.springboot.app.springboot_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminController {

    @Autowired
    private PostService postService;

    @GetMapping("/list-articles")
    public String getAdminPage(Model model) {
        model.addAttribute("posts", postService.findPostsByCheck(false));
        return "admin-list-articles";
    }

    @PostMapping("/list-articles/{id}")
    public String addNewPost(@PathVariable(value = "id") long id) {
        postService.changeCheckToPost(id);
        return "redirect:/";
    }

    @PostMapping("list-articles/{id}/delete")
    public String deletePost(@PathVariable(value = "id") long id) {
        postService.deletePostById(id);
        return "redirect:/";
    }

    @GetMapping("/list-articles/check-article/{id}")
    public String getPageToCheckPost(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("post", postService.getPostForEditById(id));
        return "article";
    }

    @GetMapping("/list-articles/{id}/edit")
    public String getPageForEdit(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("post", postService.getPostForEditById(id));
        return "blog-edit";
    }


    @PostMapping("/list-articles/{id}/edit")
    public String putPageForEdit(@RequestParam String title, @RequestParam String anons,
                                 @RequestParam String full_text, @PathVariable(value = "id") long id) {

        postService.editPostById(id, title, anons, full_text);
        return "redirect:/" ;
    }



}
