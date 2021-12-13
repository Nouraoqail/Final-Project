package com.example.demo.comment;

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

    public Comment(){}

    public Comment(long id, String text, LocalTime time) {
        this.id = id;
        this.text = text;
        Time = time;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", Time=" + Time +
                '}';
    }
}
