package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Model.AttendanceRecord;
import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Repository.AttendanceRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.CourseRepository;
import com.Group11Project.ClassAttendanceSystem.Service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final CourseRepository courseRepository;

    public void signAttendance (User student, Course course){
        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setDate(new Date());
        attendanceRecord.setCourse(course);
        attendanceRecord.setStudent(student);
        attendanceRepository.save(attendanceRecord);
    }

    public Course getCourseById(Integer courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
    }
}
