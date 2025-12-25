package com.nurul.RestAPIs.controller;


import com.nurul.RestAPIs.dto.DepartmentDto;
import com.nurul.RestAPIs.dto.DepartmentRequestDto;
import com.nurul.RestAPIs.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment() {
        try {
            List<DepartmentDto> departmentDtoList = departmentService.getAllDepartment();
            return new ResponseEntity<>(departmentDtoList, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentRequestDto departmentRequestDto) {
        try {
            DepartmentDto departmentDto = departmentService.saveDepartment(departmentRequestDto);
            return new ResponseEntity<>(departmentDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            departmentService.deleteById(id);
            return new ResponseEntity<>("Record Deleted Successfully for Id : " + id, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
