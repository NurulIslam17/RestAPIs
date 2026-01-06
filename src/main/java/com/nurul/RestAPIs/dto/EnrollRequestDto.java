package com.nurul.RestAPIs.dto;

public class EnrollRequestDto {
    private Long studentId;
    private Long courseId;
    private String enrollmentStatus;

    public EnrollRequestDto() {
    }

    public EnrollRequestDto(Long studentId, Long courseId, String enrollmentStatus) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentStatus = enrollmentStatus;
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

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }
}
