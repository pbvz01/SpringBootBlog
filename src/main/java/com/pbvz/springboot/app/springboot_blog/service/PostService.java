package com.pbvz.springboot.app.springboot_blog.service;

import com.pbvz.springboot.app.springboot_blog.model.Post;
import com.pbvz.springboot.app.springboot_blog.repsitory.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public List<Post> getPosts() {
        Iterable<Post> posts = postRepository.findAll();
        List<Post> postList = new ArrayList<>();
        posts.forEach(x -> postList.add(x));
        Collections.reverse(postList);
        return postList;
    }
    public Post getPostById (long id) {
        // параллельность
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
    }
    public void createPost(String title, String anons, String full_text) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
    }
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
    }
}
