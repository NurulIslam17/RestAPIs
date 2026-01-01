package com.nurul.RestAPIs.controller;

import com.nurul.RestAPIs.dto.AddStudentRequestDto;
import com.nurul.RestAPIs.dto.StudentDto;
import com.nurul.RestAPIs.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/admin/students")
    public ResponseEntity<List<StudentDto>> getAllStudent() {
            List<StudentDto> studentDtoList = studentService.getAllStudent();
            return ResponseEntity.ok(studentDtoList);
    }

    @GetMapping("/admin/students/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            StudentDto studentDto = studentService.getStudentById(id);
            return new ResponseEntity<>(studentDto, HttpStatus.FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Something Went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto) {
        try {
            StudentDto newStudent = studentService.createStudent(addStudentRequestDto);
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/admin/students/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id)
    {
        try {
            studentService.deleteStudentById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/admin/students/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id, @RequestBody @Valid AddStudentRequestDto addStudentRequestDto) {
        try {
            StudentDto studentDto = studentService.updateStudentById(id, addStudentRequestDto);
            return new ResponseEntity<>(studentDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    //Spring  JPA Query
    @GetMapping("/admin/students/{name}/{email}")
    public ResponseEntity<List<StudentDto>> findByNameOrEmail(@PathVariable String name, @PathVariable String email) {
        try {
            List<StudentDto> studentDtoList = studentService.findByNameOrEmail(name, email);
            return new ResponseEntity<>(studentDtoList, HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/admin/count-students")
    public ResponseEntity<Long> getStudentCountByType(@RequestParam("type") String status) {
       try {
           Long count = studentService.getStudentCountByType(status);
           return new ResponseEntity<>(count,HttpStatus.OK);
       } catch (RuntimeException e) {
           throw new RuntimeException(e);
       }
    }
}
