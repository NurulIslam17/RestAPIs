package com.nurul.RestAPIs.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toMail, String subject, String body) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("admin@app.app.com");
            simpleMailMessage.setTo(toMail);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(body);
            mailSender.send(simpleMailMessage);

        } catch (RuntimeException e) {
            System.out.println("Mail Sending issue : " + e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
