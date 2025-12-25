package com.nurul.RestAPIs.dto;

import com.nurul.RestAPIs.entity.Department;
import com.nurul.RestAPIs.entity.type.StudentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private String address;
    @Enumerated(EnumType.STRING)
    private StudentType type;
    private Long departmentId;

    public AddStudentRequestDto(String name, String email, String address, StudentType type, Long departmentId) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.type = type;
        this.departmentId = departmentId;
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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StudentType getType() {
        return type;
    }

    public void setType(StudentType type) {
        this.type = type;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
