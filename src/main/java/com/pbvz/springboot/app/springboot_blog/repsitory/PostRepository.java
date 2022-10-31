package com.pbvz.springboot.app.springboot_blog.repsitory;

import com.pbvz.springboot.app.springboot_blog.model.Post;
import com.pbvz.springboot.app.springboot_blog.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
   List<Post> findPostsByCheck(boolean value);
   List<Post> findPostsByUserAndCheckIsTrue(User user);
}

