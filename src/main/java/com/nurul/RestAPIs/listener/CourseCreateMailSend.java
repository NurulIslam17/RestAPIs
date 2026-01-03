package com.nurul.RestAPIs.listener;


import com.nurul.RestAPIs.dto.StudentDto;
import com.nurul.RestAPIs.event.CourseCreateEvent;
import com.nurul.RestAPIs.mail.MailService;
import com.nurul.RestAPIs.service.StudentService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseCreateMailSend {


    private final StudentService studentService;
    private final MailService mailService;


    public CourseCreateMailSend( StudentService studentService, MailService mailService) {
        this.studentService = studentService;
        this.mailService = mailService;
    }

    @EventListener
    public void sendMailToALlSubscribedUser(CourseCreateEvent event) {
        List<StudentDto> studentDtoList = studentService.getAllStudent();
        for (StudentDto studentDto : studentDtoList) {
            mailService.sendMail(studentDto.getEmail(), "New Course created", "New Course created with title : " + event.getCourseTitle());
        }
    }
}
