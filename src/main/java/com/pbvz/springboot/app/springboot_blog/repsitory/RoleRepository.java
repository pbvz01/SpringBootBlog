package com.pbvz.springboot.app.springboot_blog.repsitory;

import com.pbvz.springboot.app.springboot_blog.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
   Role findByName(String name);
}


