package com.pbvz.springboot.app.springboot_blog.repsitory;

import com.pbvz.springboot.app.springboot_blog.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
}


