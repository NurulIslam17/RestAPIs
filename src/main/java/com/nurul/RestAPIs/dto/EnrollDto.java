package com.nurul.RestAPIs.dto;
import com.nurul.RestAPIs.entity.Course;
import com.nurul.RestAPIs.entity.Student;
import com.nurul.RestAPIs.entity.type.EnrollmentStatus;
import lombok.*;

import java.time.LocalDateTime;


public class EnrollDto {

    private Long id;
    private Student student;
    private Course course;
    private EnrollmentStatus enrollmentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EnrollDto() {

    }

    public EnrollDto(Long id, Student student, Course course, EnrollmentStatus enrollmentStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.student = student;
        this.course = course;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
