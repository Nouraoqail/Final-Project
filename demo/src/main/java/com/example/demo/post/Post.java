package com.example.demo.post;

import com.example.demo.comment.Comment;
import com.example.demo.type.Type;
import com.example.demo.user.User;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Title;
    private URL image;
    private String Description;
    private LocalTime time;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="type_id",nullable = false)
    private Type type;

    @OneToMany(mappedBy = "post")
    private Collection<Comment> comment=new ArrayList<>();

    public Post(long id, String title, URL image, String description, LocalTime time, User user, Type type, Collection<Comment> comment) {
        this.id = id;
        Title = title;
        this.image = image;
        Description = description;
        this.time = time;
        this.user = user;
        this.type = type;
        this.comment = comment;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Collection<Comment> getComment() {
        return comment;
    }

    public void setComment(Collection<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", image=" + image +
                ", Description='" + Description + '\'' +
                ", time=" + time +
                ", user=" + user +
                ", type=" + type +
                ", comment=" + comment +
                '}';
    }
}
