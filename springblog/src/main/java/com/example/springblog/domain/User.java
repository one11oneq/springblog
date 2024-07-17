package com.example.springblog.domain;

import java.sql.Date;

public class User {
    int user_id;
    String username;
    String password;
    String email;
    Date created;
    Date last_modeified;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLast_modeified() {
        return last_modeified;
    }

    public void setLast_modeified(Date last_modeified) {
        this.last_modeified = last_modeified;
    }
}
