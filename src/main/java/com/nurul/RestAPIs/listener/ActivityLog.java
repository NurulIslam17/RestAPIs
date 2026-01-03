package com.nurul.RestAPIs.listener;

import com.nurul.RestAPIs.event.CourseCreateEvent;
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

    public void handleNewCourseCreateEvent(CourseCreateEvent event)
    {
        System.out.println("New Course created with title : " + event.getCourseTitle());
    }
}
