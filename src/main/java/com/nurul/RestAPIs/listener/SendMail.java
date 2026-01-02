package com.nurul.RestAPIs.listener;


import com.nurul.RestAPIs.event.TeacherCreateEvent;
import com.nurul.RestAPIs.mail.MailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SendMail {


    private final MailService mailService;

    public SendMail(MailService mailService) {
        this.mailService = mailService;
    }

    @EventListener
    public void handleTeacherCreateEvent(TeacherCreateEvent event)
    {
        mailService.sendMail(event.getTeacherEmail(), "Teacher Create Event", "Your account created successfully");
    }

}
