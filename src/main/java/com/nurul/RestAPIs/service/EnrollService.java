package com.nurul.RestAPIs.service;

import com.nurul.RestAPIs.dto.EnrollDto;
import com.nurul.RestAPIs.dto.EnrollRequestDto;
import com.nurul.RestAPIs.entity.Course;
import com.nurul.RestAPIs.entity.Enroll;
import com.nurul.RestAPIs.entity.Student;
import com.nurul.RestAPIs.repository.CourseRepository;
import com.nurul.RestAPIs.repository.EnrollRepository;
import com.nurul.RestAPIs.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollService {

    private final EnrollRepository enrollRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public EnrollService(EnrollRepository enrollRepository, CourseService courseService, StudentRepository studentRepository, CourseRepository courseRepository, ModelMapper modelMapper) {
        this.enrollRepository = enrollRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    public List<EnrollDto> getEnrollmentList() {

        List<Enroll> enrolls = enrollRepository.findAll();
        return enrolls
                .stream()
                .map(enroll -> modelMapper.map(enroll, EnrollDto.class))
                .toList();
    }

    public EnrollDto save(EnrollRequestDto enrollRequestDto) {

        Student student = studentRepository.findById(enrollRequestDto.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        Course course = courseRepository.findById(enrollRequestDto.getCourseId()).orElseThrow(() -> new IllegalArgumentException("Course not found"));

        Enroll enroll = new Enroll();
        enroll.setStudent(student);
        enroll.setCourse(course);
        enroll.setCreatedAt(enrollRequestDto.getCreatedAt());
        enroll.setUpdatedAt(enrollRequestDto.getUpdatedAt());
        enroll.setEnrollmentStatus(enrollRequestDto.getEnrollmentStatus());

        Enroll saveEnroll = enrollRepository.save(enroll);
        return modelMapper.map(saveEnroll, EnrollDto.class);
    }
}
