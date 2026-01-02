package com.nurul.RestAPIs.listener;

import com.nurul.RestAPIs.event.TeacherCreateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ActivityLog {

    @EventListener
    public void handleTeacherCreateEvent(TeacherCreateEvent event)
    {
        System.out.println("Teacher Created with email : "+ event.getTeacherEmail());
    }
}
