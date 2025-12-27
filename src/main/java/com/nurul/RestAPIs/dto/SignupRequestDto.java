package com.nurul.RestAPIs.dto;

public class SignupRequestDto {

    private String userName;
    private String password;
    private String email;

    public SignupRequestDto(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public SignupRequestDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
