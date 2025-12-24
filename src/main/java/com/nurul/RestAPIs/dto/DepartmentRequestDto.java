package com.nurul.RestAPIs.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDto {

    @NotBlank(message = "Department name is required.")
    private String name;
    @NotBlank(message = "Department code is required.")
    private String code;

    public DepartmentRequestDto(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public DepartmentRequestDto() {

    }

    public @NotBlank(message = "Department name is required.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Department name is required.") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Department code is required.") String getCode() {
        return code;
    }

    public void setCode(@NotBlank(message = "Department code is required.") String code) {
        this.code = code;
    }
}
