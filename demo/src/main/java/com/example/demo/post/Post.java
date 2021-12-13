package com.example.demo.post;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalTime;

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

    public Post(long id, String title, URL image, String description, LocalTime time) {
        this.id = id;
        Title = title;
        this.image = image;
        Description = description;
        this.time = time;
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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", image=" + image +
                ", Description='" + Description + '\'' +
                ", time=" + time +
                '}';
    }
}
