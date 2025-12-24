package com.nurul.RestAPIs.service.impl;

import com.nurul.RestAPIs.dto.DepartmentDto;
import com.nurul.RestAPIs.dto.DepartmentRequestDto;
import com.nurul.RestAPIs.entity.Department;
import com.nurul.RestAPIs.repository.DepartmentRepository;
import com.nurul.RestAPIs.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;


    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {

        List<Department> departmentList = departmentRepository.findAll();
        return departmentList
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDto.class))
                .toList();
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentRequestDto departmentRequestDto) {
        Department departmentData = modelMapper.map(departmentRequestDto, Department.class);
        Department department = departmentRepository.save(departmentData);
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public void deleteById(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new IllegalArgumentException("Department not found for the Id" + id);
        }
        departmentRepository.deleteById(id);
    }
}
