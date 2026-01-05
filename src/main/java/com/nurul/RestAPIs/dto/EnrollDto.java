package com.nurul.RestAPIs.dto;
import com.nurul.RestAPIs.entity.type.EnrollmentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollDto {

    private Long id;
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private Long courseId;
    private String courseTitle;
    private String courseCode;
    private String teacherName;
    private EnrollmentStatus enrollmentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
