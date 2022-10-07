package com.pbvz.springboot.app.springboot_blog.repsitory;

import com.pbvz.springboot.app.springboot_blog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
