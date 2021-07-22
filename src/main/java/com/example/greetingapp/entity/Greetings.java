package com.example.greetingapp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greetings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String message;

    public Greetings(String message) {
        this.message = message;
    }

    public Greetings() {
        id = 0;
        message = "";
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}