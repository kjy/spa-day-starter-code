package org.launchcode.spaday.models;

import java.util.Date;

public class User {
    // properties
    private static int nextId = 1;

    private int id;
    private String username;
    private String email;
    private String password;
    private final Date joinedDate;

    // constructors
    public User() {
        id = nextId;
        nextId++;
        this.joinedDate = new Date();
    }

    public String getUsername() {
        return username;
    }

    // getters and setters

    public int getId() {
        return this.id; }

    public Date getJoinedDate() { return this.joinedDate; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
