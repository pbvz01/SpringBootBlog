package com.pbvz.springboot.app.springboot_blog.controllers.registration;

import com.pbvz.springboot.app.springboot_blog.model.User;
import com.pbvz.springboot.app.springboot_blog.service.UserService;
import com.pbvz.springboot.app.springboot_blog.service.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(@ModelAttribute("userForm") User user,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "registration";
        }

        if(!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if(userService.findByLogin(user.getLogin()) != null) {
            model.addAttribute("loginError", "Пользователь с таким именем существует");
            return "registration";
        }

        userService.saveUser(user);
        securityService.autoLogin(user.getLogin(), user.getPasswordConfirm());

        return "redirect:/";
    }
}
