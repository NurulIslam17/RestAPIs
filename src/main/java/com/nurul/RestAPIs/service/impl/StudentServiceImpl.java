package com.nurul.RestAPIs.service.impl;

import com.nurul.RestAPIs.dto.StudentDto;
import com.nurul.RestAPIs.entity.Student;
import com.nurul.RestAPIs.repository.StudentRepository;
import com.nurul.RestAPIs.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudent() {

        List<Student> students = studentRepository.findAll();

        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> new StudentDto()).toList();
        return studentDtoList;
    }
}
