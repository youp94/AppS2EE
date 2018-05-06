package com.s2ee.etic.apps2ee;

public class User {

    String userId;
    String userEmail;
    String username;

    public User() {
    }

    public User(String userId, String userEmail, String username) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
