package com.example.adamn.userstatisticsapplication.Models;

/**
 *This object class creates a User Object which is used to fill the
 * database with accounts.
 *
 * @author Adam Nowak
 */

public class User {
    private int id;
    private String email;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {

        return email;
    }
}
