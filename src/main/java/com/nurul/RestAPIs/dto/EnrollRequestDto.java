package com.nurul.RestAPIs.dto;

import com.nurul.RestAPIs.entity.type.EnrollmentStatus;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class EnrollRequestDto {
    private Long studentId;
    private Long courseId;
    private EnrollmentStatus enrollmentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EnrollRequestDto() {
    }

    public EnrollRequestDto(Long studentId, Long courseId, EnrollmentStatus enrollmentStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentStatus = enrollmentStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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
