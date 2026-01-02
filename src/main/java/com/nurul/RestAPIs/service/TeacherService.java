package com.nurul.RestAPIs.service;

import com.nurul.RestAPIs.dto.TeacherDto;
import com.nurul.RestAPIs.dto.TeacherRequestDto;
import com.nurul.RestAPIs.entity.Department;
import com.nurul.RestAPIs.entity.Teacher;
import com.nurul.RestAPIs.event.TeacherCreateEvent;
import com.nurul.RestAPIs.repository.DepartmentRepository;
import com.nurul.RestAPIs.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    public final ApplicationEventPublisher publisher;

    public TeacherService(TeacherRepository teacherRepository, DepartmentRepository departmentRepository, ModelMapper modelMapper, ApplicationEventPublisher publisher) {
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
        this.publisher = publisher;
    }

    public List<TeacherDto> getAllTeacher() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers
                .stream()
                .map(teacher -> modelMapper.map(teacher, TeacherDto.class))
                .toList();
    }

    public TeacherDto saveTeacher(TeacherRequestDto teacherRequestDto) {

        Department department = departmentRepository.findById(teacherRequestDto.getDepartmentId()).orElseThrow(() -> new IllegalArgumentException("Department Not Found"));
        Teacher teacherData = modelMapper.map(teacherRequestDto, Teacher.class);
        teacherData.setId(null);
        teacherData.setDepartment(department);
        Teacher teacher = teacherRepository.save(teacherData);

        // Send email to the teacher
        publisher.publishEvent(new TeacherCreateEvent(teacher.getEmail()));

        return modelMapper.map(teacher, TeacherDto.class);

    }

    public void deleteById(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new IllegalArgumentException("Teacher not found for id " + id);
        }
        teacherRepository.deleteById(id);
    }
}
