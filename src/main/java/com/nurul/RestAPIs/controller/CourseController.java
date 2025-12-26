package com.nurul.RestAPIs.controller;


import com.nurul.RestAPIs.dto.CourseDto;
import com.nurul.RestAPIs.dto.CourseRequestDto;
import com.nurul.RestAPIs.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourse() {
        try {
            List<CourseDto> courseDtoList = courseService.getAllCourse();
            return new ResponseEntity<>(courseDtoList, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<CourseDto> saveCourse(@RequestBody CourseRequestDto courseRequestDto) {
        try {
            CourseDto courseDto = courseService.courseRequestDto(courseRequestDto);
            return new ResponseEntity<>(courseDto, HttpStatus.CREATED);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
