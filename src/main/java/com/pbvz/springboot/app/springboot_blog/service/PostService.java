package com.pbvz.springboot.app.springboot_blog.service;

import com.pbvz.springboot.app.springboot_blog.model.Post;
import com.pbvz.springboot.app.springboot_blog.model.User;
import com.pbvz.springboot.app.springboot_blog.repsitory.PostRepository;
import com.pbvz.springboot.app.springboot_blog.service.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostService {
    @Autowired
    UserService userService;
    @Autowired
    SecurityService securityService;
    @Autowired
    private PostRepository postRepository;

    public List<Post> findPostsByUserAndCheckIsTrue(User user) {
        user = securityService.getUserSession();
        return postRepository.findPostsByUserAndCheckIsTrue(user);
    }

   public List<Post> findPostsByCheck(boolean check) {
        List<Post> list = postRepository.findPostsByCheck(check);
        Collections.reverse(list);
        return list;
   }

   public void changeCheckToPost(long id) {
       Post post = postRepository.findById(id).get();
       post.setCheck(true);
       postRepository.save(post);
   }
    public Post getPostByIdForUser(long id) {
        Post post = postRepository.findById(id).get();
        post.setViews(post.getViews() + 1);
        postRepository.save(post);
        return post;
    }
    public Post getPostForEditById (long id) {
        Post post = postRepository.findById(id).get();
        return post;
    }
    public void editPostById(long id, String title, String anons, String full_text) {
        Post post = postRepository.findById(id).get();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
    }
    public void createPost(String title, String anons, String full_text) {
        Post post = new Post(title, anons, full_text);
        User user = securityService.getUserSession();
        user.addNewPost(post);
        postRepository.save(post);
    }
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
    }
}
