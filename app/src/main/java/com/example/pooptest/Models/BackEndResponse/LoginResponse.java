package com.example.pooptest.Models.BackEndResponse;

import com.example.pooptest.Models.UserDto;

public class LoginResponse {
    private String token;
    private UserDto user;

    public LoginResponse(String token, UserDto userDto) {
        this.token = token;
        this.user = userDto;
    }

    public LoginResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto userDto) {
        this.user = userDto;
    }
}
