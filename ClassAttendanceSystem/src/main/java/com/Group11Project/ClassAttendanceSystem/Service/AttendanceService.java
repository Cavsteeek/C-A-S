package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.User;

public interface AttendanceService {
    public void signAttendance (User student, Course course);
    public Course getCourseById(Integer courseId);
}
