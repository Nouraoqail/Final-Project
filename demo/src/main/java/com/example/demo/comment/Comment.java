package com.example.demo.comment;

import com.example.demo.post.Post;
import com.example.demo.user.User;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;
    private LocalTime Time;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="post_id",nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    public Comment(){}

    public Comment(long id, String text, LocalTime time, Post post, User user) {
        this.id = id;
        this.text = text;
        Time = time;
        this.post = post;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime time) {
        Time = time;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", Time=" + Time +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}
