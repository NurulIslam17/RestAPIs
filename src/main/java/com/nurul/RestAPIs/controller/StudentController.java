package com.nurul.RestAPIs.controller;

import com.nurul.RestAPIs.dto.StudentDto;
import com.nurul.RestAPIs.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudent() {
        try {
            List<StudentDto> studentDtoList = studentService.getAllStudent();
            return new ResponseEntity<>(studentDtoList, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
