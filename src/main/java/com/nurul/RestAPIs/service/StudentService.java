package com.nurul.RestAPIs.service;
import com.nurul.RestAPIs.dto.AddStudentRequestDto;
import com.nurul.RestAPIs.dto.StudentDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudentById(Long id, AddStudentRequestDto addStudentRequestDto);

    List<StudentDto> findByNameOrEmail(String name, String email);

    Long getStudentCountByType(String status);
}
