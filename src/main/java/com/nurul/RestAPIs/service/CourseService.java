package com.nurul.RestAPIs.service;

import com.nurul.RestAPIs.dto.CourseDto;
import com.nurul.RestAPIs.dto.CourseRequestDto;
import com.nurul.RestAPIs.entity.Course;
import com.nurul.RestAPIs.entity.Department;
import com.nurul.RestAPIs.entity.Teacher;
import com.nurul.RestAPIs.repository.CourseRepository;
import com.nurul.RestAPIs.repository.DepartmentRepository;
import com.nurul.RestAPIs.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    public CourseService(CourseRepository courseRepository, DepartmentRepository departmentRepository, TeacherRepository teacherRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
    }

    public List<CourseDto> getAllCourse() {

        List<Course> courseList = courseRepository.findAll();
        return courseList
                .stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .toList();
    }

    public CourseDto courseRequestDto(CourseRequestDto courseRequestDto) {
        Department department = departmentRepository.findById(courseRequestDto.getDepartmentId()).orElseThrow(() -> new IllegalArgumentException("Department Not Found"));
        Teacher teacher = teacherRepository.findById(courseRequestDto.getTeacherId()).orElseThrow(() -> new IllegalArgumentException("Teacher not found"));

        Course courseData = modelMapper.map(courseRequestDto, Course.class);
        courseData.setDepartment(department);
        courseData.setTeacher(teacher);
        Course course = courseRepository.save(courseData);
        return modelMapper.map(course, CourseDto.class);
    }

    @Cacheable(cacheNames = "courseById", key = "#id")
    public CourseDto getById(Long id) {
        System.out.println("Course fetching  : "+id);
        Course course = courseRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Course not found"));
        return modelMapper.map(course,CourseDto.class);
    }
}
