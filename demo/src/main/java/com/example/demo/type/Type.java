package com.example.demo.type;

import javax.persistence.*;

@Entity
@Table(name="Type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Type;

    public Type(long id, String type) {
        this.id = id;
        Type = type;
    }
    public Type(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", Type='" + Type + '\'' +
                '}';
    }
}
