package com.pbvz.springboot.app.springboot_blog.service.security;

import com.pbvz.springboot.app.springboot_blog.model.User;

public interface SecurityService {
    User getUserSession();
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
