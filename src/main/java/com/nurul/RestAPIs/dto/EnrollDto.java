package com.nurul.RestAPIs.dto;
import com.nurul.RestAPIs.entity.Course;
import com.nurul.RestAPIs.entity.Student;
import com.nurul.RestAPIs.entity.type.EnrollmentStatus;
import lombok.*;

import java.time.LocalDateTime;


public class EnrollDto {

    private Long id;
    private String studentName;
    private String studentEmail;
    private String courseTitle;
    private String courseCode;
    private EnrollmentStatus enrollmentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EnrollDto() {

    }

    public EnrollDto(Long id, String studentName, String studentEmail, String courseTitle, String courseCode, EnrollmentStatus enrollmentStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.courseTitle = courseTitle;
        this.courseCode = courseCode;
        this.enrollmentStatus = enrollmentStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public EnrollmentStatus getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
