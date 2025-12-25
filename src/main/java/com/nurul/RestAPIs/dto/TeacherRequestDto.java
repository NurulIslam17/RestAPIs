package com.nurul.RestAPIs.dto;

public class TeacherRequestDto {

    private String name;
    private String email;
    private String phone;
    private String room;
    private Long departmentId;

    public TeacherRequestDto(String name, String email, String phone, String room, Long departmentId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.room = room;
        this.departmentId = departmentId;
    }

    public TeacherRequestDto() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
