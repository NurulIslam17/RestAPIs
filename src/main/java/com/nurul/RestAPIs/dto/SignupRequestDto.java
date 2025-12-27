package com.nurul.RestAPIs.dto;

import com.nurul.RestAPIs.entity.type.RoleType;

import java.util.HashSet;
import java.util.Set;

public class SignupRequestDto {

    private String userName;
    private String password;
    private String email;
    private Set<RoleType> roles = new HashSet<>();

    public SignupRequestDto(String userName, String password, String email, Set<RoleType> roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
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

    public Set<RoleType> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleType> roles) {
        this.roles = roles;
    }

}
