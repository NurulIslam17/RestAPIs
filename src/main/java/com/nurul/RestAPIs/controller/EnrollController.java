package com.nurul.RestAPIs.controller;

import com.nurul.RestAPIs.dto.EnrollDto;
import com.nurul.RestAPIs.dto.EnrollRequestDto;
import com.nurul.RestAPIs.service.EnrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollController {

    private final EnrollService enrollService;

    public EnrollController(EnrollService enrollService) {
        this.enrollService = enrollService;
    }

    @GetMapping("/auth/enrollments")
    public ResponseEntity<List<EnrollDto>> getEnrollmentList() {
        try {
            List<EnrollDto> enrollDtoList = enrollService.getEnrollmentList();
            return new ResponseEntity<>(enrollDtoList, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: Fix why io.jsonwebtoken.MalformedJwtException error occurs after executing this file;
    @PostMapping("/auth/enrollment")
    public ResponseEntity<EnrollDto> save(@RequestBody EnrollRequestDto enrollRequestDto) {
        try {
            EnrollDto enrollment = enrollService.save(enrollRequestDto);
            return new ResponseEntity<>(enrollment, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
