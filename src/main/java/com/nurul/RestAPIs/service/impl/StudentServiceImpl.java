package com.nurul.RestAPIs.service.impl;

import com.nurul.RestAPIs.dto.AddStudentRequestDto;
import com.nurul.RestAPIs.dto.StudentDto;
import com.nurul.RestAPIs.entity.Department;
import com.nurul.RestAPIs.entity.Student;
import com.nurul.RestAPIs.repository.DepartmentRepository;
import com.nurul.RestAPIs.repository.StudentRepository;
import com.nurul.RestAPIs.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student,StudentDto.class))
                .toList();

    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createStudent(AddStudentRequestDto addStudentRequestDto) {
        Department department = departmentRepository.findById(addStudentRequestDto.getDepartmentId()).orElseThrow(()-> new IllegalArgumentException("Department Not Found"));

        Student newStudent = modelMapper.map(addStudentRequestDto,Student.class);
        newStudent.setId(null);              // force INSERT
        newStudent.setDepartment(department);
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

    @Override
    public StudentDto updateStudentById(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> findByNameOrEmail(String name, String email) {
        List<Student> studentList = studentRepository.findByNameOrEmail(name, email);
        return studentList
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class)).toList();
    }
}
