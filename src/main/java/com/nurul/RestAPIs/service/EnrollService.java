package com.nurul.RestAPIs.service;

import com.nurul.RestAPIs.dto.EnrollDto;
import com.nurul.RestAPIs.entity.Enroll;
import com.nurul.RestAPIs.repository.EnrollRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollService {

    private final EnrollRepository enrollRepository;
    private final ModelMapper modelMapper;

    public EnrollService(EnrollRepository enrollRepository, ModelMapper modelMapper) {
        this.enrollRepository = enrollRepository;
        this.modelMapper = modelMapper;
    }

    public List<EnrollDto> getEnrollmentList() {

        List<Enroll> enrolls = enrollRepository.findAll();
        return enrolls
                .stream()
                .map(enroll -> modelMapper.map(enroll, EnrollDto.class))
                .toList();
    }
}
