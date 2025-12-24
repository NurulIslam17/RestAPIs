package com.nurul.RestAPIs.service;

import com.nurul.RestAPIs.dto.DepartmentDto;
import com.nurul.RestAPIs.dto.DepartmentRequestDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getAllDepartment();

    DepartmentDto saveDepartment(DepartmentRequestDto departmentRequestDto);

    void deleteById(Long id);
}
