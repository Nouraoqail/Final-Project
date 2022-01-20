package com.example.demo.post;

import com.example.demo.comment.Comment;
import com.example.demo.type.Type;
import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Title;
    private String image;
    private String Description;
    private Instant time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties("posts")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="type_id",nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Type type;

    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("post")
    private Collection<Comment> comment=new ArrayList<>();

    public Post(long id, String title, String image, String description, Instant time, User user, Type type, Collection<Comment> comment) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
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
                ", comment=" + comment +
                '}';
    }
}
