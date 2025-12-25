package com.nurul.RestAPIs.controller;

import com.nurul.RestAPIs.dto.TeacherDto;
import com.nurul.RestAPIs.dto.TeacherRequestDto;
import com.nurul.RestAPIs.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeacher() {
        try {
            List<TeacherDto> teacherDtos = teacherService.getAllTeacher();
            return new ResponseEntity<>(teacherDtos, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<TeacherDto> saveTeacher(@RequestBody TeacherRequestDto teacherRequestDto) {
        try {
            TeacherDto teacherDto = teacherService.saveTeacher(teacherRequestDto);
            return new ResponseEntity<>(teacherDto, HttpStatus.CREATED);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            teacherService.deleteById(id);
            return new ResponseEntity<>("Record deleted for id " + id, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
