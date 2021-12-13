package com.example.demo.user;

import javax.persistence.*;

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

    public User(long id, long NID, String FName, String LName, long phone_number, String password) {
        this.id = id;
        this.NID = NID;
        this.FName = FName;
        this.LName = LName;
        Phone_number = phone_number;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", NID=" + NID +
                ", FName='" + FName + '\'' +
                ", LName='" + LName + '\'' +
                ", Phone_number=" + Phone_number +
                ", password='" + password + '\'' +
                '}';
    }
}
