package com.example.pooptest.Models;

public class UserDto {
    private String userName;
    private String email;

    public UserDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public UserDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
