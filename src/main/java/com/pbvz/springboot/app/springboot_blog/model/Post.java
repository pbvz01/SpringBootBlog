package com.pbvz.springboot.app.springboot_blog.model;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tittle")
    private String title;
    @Column(name = "anons")
    private String anons;
    @Column(name = "full_text")
    private String full_text;
    @Column(name = "check_admin",
    nullable = false)
    private Boolean check = false;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "views")
    private int views;


    public Post () {}

    public Post (String title, String anons, String text) {
        this.title = title;
        this.anons = anons;
        this.full_text = text;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCheck() {
        return check;
    }
    public void setCheck(Boolean check) {
        this.check = check;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
