package com.nurul.RestAPIs.dto;

public class AddStudentRequestDto {

    private String name;
    private String email;

    public AddStudentRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public AddStudentRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
