package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.AttendanceRecord;
import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Repository.AttendanceRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.CourseRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.UserRepository;
import com.Group11Project.ClassAttendanceSystem.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cas/teacher")
@RequiredArgsConstructor
@CrossOrigin
public class TeacherController
{
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final AttendanceRepository attendanceRepository;
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Welcome Teacher");
    }

    @GetMapping("/find-all-students")
    public ResponseEntity<List<User>> findAllStudents(){
        List<User> studentList = userRepository.findAllByRole(Role.STUDENT);
        return ResponseEntity.ok(studentList);

    }
    @GetMapping("/get-all-courses")
    public ResponseEntity<List<Course>> findAllCourse(){
        List<Course> courseList = courseRepository.findAll();
        return ResponseEntity.ok(courseList);
    }

    @GetMapping("view-all-attendance")
    public ResponseEntity<List<AttendanceRecord>> viewAllAttendance() {
        List<AttendanceRecord> attendanceRecords = attendanceRepository.findAll();
        return ResponseEntity.ok(attendanceRecords);
    }

}
