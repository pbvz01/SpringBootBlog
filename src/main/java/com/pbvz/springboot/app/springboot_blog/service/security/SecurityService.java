package com.pbvz.springboot.app.springboot_blog.service.security;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
