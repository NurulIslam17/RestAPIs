package com.nurul.RestAPIs.Scheduler;

import com.nurul.RestAPIs.mail.MailService;
import com.nurul.RestAPIs.service.StudentService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationSenderScheduler {

    private final StudentService studentService;
    private final MailService mailService;


    public NotificationSenderScheduler(StudentService studentService, MailService mailService) {
        this.studentService = studentService;
        this.mailService = mailService;
    }

    @Scheduled(cron = "0 0 0/12 ? * * *")
    public void sendPendingStudentNotificationToAdmin() {
        Long totalPendingStudentCount = studentService.getStudentCountByType("PENDING");
        String body = "There are already " + totalPendingStudentCount + " students pending. Please take necessary action.";
        mailService.sendMail("adminapp@gmail.com", "Pending Student", body);
    }
}
