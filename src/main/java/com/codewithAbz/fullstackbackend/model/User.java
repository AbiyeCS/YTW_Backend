package com.codewithAbz.fullstackbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // Will automatically create a user table once we connect the spring boot application with the mysql
public class User {

    @Id
    @GeneratedValue
    private Long id; // This will be auto generated$
    private String username;
    private String name;
    private String email;

    public Long getId() { // Can create the getters and setters by 2 ways, either cmd + n OR right click and click generate
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
