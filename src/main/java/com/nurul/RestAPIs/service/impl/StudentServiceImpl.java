package com.nurul.RestAPIs.service.impl;

import com.nurul.RestAPIs.dto.AddStudentRequestDto;
import com.nurul.RestAPIs.dto.StudentDto;
import com.nurul.RestAPIs.entity.Student;
import com.nurul.RestAPIs.repository.StudentRepository;
import com.nurul.RestAPIs.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();

    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto,Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(newStudent,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id))
        {
            throw new IllegalArgumentException("Student does not exist by id : " +id);
        }
        studentRepository.deleteById(id);
    }
}
