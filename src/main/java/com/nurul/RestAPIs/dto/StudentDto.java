package com.nurul.RestAPIs.dto;

import com.nurul.RestAPIs.entity.Department;
import com.nurul.RestAPIs.entity.type.StudentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String address;
    @Enumerated(EnumType.STRING)
    private StudentType type;
    private LocalDateTime createdAt;
    private Long departmentId;
    private String departmentName;
    private String departmentCode;

    public StudentDto(Long id, String name, String email, String address, StudentType type, LocalDateTime createdAt, Long departmentId, String departmentName, String departmentCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.type = type;
        this.createdAt = createdAt;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    public StudentDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
