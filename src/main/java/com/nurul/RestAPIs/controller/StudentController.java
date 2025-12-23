package com.nurul.RestAPIs.controller;

import com.nurul.RestAPIs.dto.AddStudentRequestDto;
import com.nurul.RestAPIs.dto.StudentDto;
import com.nurul.RestAPIs.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent() {
        try {
            List<StudentDto> studentDtoList = studentService.getAllStudent();
            return new ResponseEntity<>(studentDtoList, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            StudentDto studentDto = studentService.getStudentById(id);
            return new ResponseEntity<>(studentDto, HttpStatus.FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("SOmething Went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody AddStudentRequestDto addStudentRequestDto) {
        try {
            StudentDto newStudent = studentService.createStudent(addStudentRequestDto);
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id)
    {
        try {
            studentService.deleteStudentById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
