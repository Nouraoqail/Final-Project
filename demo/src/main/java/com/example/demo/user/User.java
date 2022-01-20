package com.example.demo.user;

import com.example.demo.comment.Comment;
import com.example.demo.post.Post;
import com.example.demo.type.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique=true)
    private String username;
    private String FName;
    private String LName;
    private long Phone_number;
    private String password;
    private String role;



    @ManyToMany(mappedBy = "users")
     Collection<Type> types = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @JsonIgnoreProperties("user")
    private Collection<Post> posts=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Collection<Comment> comment=new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(long id, String username, String FName, String LName, long phone_number, String password, String role, Collection<Type> types, Collection<Post> posts, Collection<Comment> comment) {
        this.id = id;
        this.username = username;
        this.FName = FName;
        this.LName = LName;
        this.Phone_number = phone_number;
        this.password = password;
        this.role = role;
        this.types = types;
        this.posts = posts;
        this.comment = comment;
    }

    public User(String username) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public long getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(long phone_number) {
        Phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Type> getTypes() {
        return types;
    }

    public void setTypes(Collection<Type> types) {
        this.types = types;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public Collection<Comment> getComment() {
        return comment;
    }

    public void setComment(Collection<Comment> comments) {
        this.comment = comment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", FName='" + FName + '\'' +
                ", LName='" + LName + '\'' +
                ", Phone_number=" + Phone_number +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", types=" + types +
                ", posts=" + posts +
                ", comment=" + comment +
                '}';
    }
}
