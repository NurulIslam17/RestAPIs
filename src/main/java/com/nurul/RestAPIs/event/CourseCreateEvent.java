package com.nurul.RestAPIs.event;

public class CourseCreateEvent {

   private final String courseTitle;

    public CourseCreateEvent(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseTitle()
    {
        return courseTitle;
    }
}
