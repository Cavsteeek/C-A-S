package com.Group11Project.ClassAttendanceSystem.Controller;


import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/cas/student")
@RequiredArgsConstructor
public class StudentController {
    private final AttendanceService attendanceService;
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Welcome User");
    }

    @PostMapping("/sign-attendance")
    public ResponseEntity<String> signAttendance(
            @AuthenticationPrincipal User student,
            @RequestBody Map<String, Object> requestBody){
        if (student.getRole() == Role.STUDENT){
            Integer courseId = (Integer) requestBody.get("courseId");
            attendanceService.signAttendance(student, courseId);
        }
        return ResponseEntity.ok("Attendance Marked");
    }
}
