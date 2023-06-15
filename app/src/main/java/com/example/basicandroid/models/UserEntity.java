package com.example.basicandroid.models;

public class UserEntity {
    private String userName;
    private String password;
    private Boolean rememberMe;

    public UserEntity(String userName, String password, Boolean rememberMe) {
        this.userName = userName;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
