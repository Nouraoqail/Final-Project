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
    private long NID;
    private String FName;
    private String LName;
    private long Phone_number;
    private String password;


    @ManyToMany(mappedBy = "users")
//    @JoinTable(
//            name = "type_users",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "type_id")
//    )
     Collection<Type> types = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @JsonIgnoreProperties("user")
    private Collection<Post> posts=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Collection<Comment> comment=new ArrayList<>();

    public User(long NID, String FName, String LName, long phone_number, String password, Collection<Type> types, Collection<Post> posts, Collection<Comment> comment) {
        this.NID = NID;
        this.FName = FName;
        this.LName = LName;
        Phone_number = phone_number;
        this.password = password;
        this.types = types;
        this.posts = posts;
        this.comment = comment;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNID() {
        return NID;
    }

    public void setNID(long NID) {
        this.NID = NID;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", NID=" + NID +
                ", FName='" + FName + '\'' +
                ", LName='" + LName + '\'' +
                ", Phone_number=" + Phone_number +
                ", password='" + password + '\'' +
                ", types=" + types +
                ", posts=" + posts +
                ", comment=" + comment +
                '}';
    }
}
