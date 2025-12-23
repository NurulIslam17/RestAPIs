package com.nurul.RestAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddStudentRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min = 2,max = 15, message = "Name Should be of length 3 to 15 characters.")
    private String name;
    @Email
    @NotBlank(message = "Email is required.")
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
