package com.nurul.RestAPIs.event;


public class TeacherCreateEvent {

    private final String teacherEmail;


    public TeacherCreateEvent(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }


}
