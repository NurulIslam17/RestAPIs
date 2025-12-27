package com.nurul.RestAPIs.dto;

public class LoginResponseDto {

    private String userName;
    private String email;
    String token;

    public LoginResponseDto(String userName, String email, String token) {
        this.userName = userName;
        this.email = email;
        this.token = token;
    }

    public LoginResponseDto() {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
