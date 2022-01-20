package com.example.demo.type;

import com.example.demo.post.Post;
import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="Type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<User> users = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private Collection<Post> posts=new ArrayList<>();

    public Type(long id, String type, Collection<User> users, Collection<Post> posts) {
        this.id = id;
        this.type = type;
        this.users = users;
        this.posts = posts;
    }

    public Type(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", Type='" + type + '\'' +
                ", users=" + users +
                ", posts=" + posts +
                '}';
    }
}
