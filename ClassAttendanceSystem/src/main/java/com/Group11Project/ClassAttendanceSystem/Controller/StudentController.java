package com.Group11Project.ClassAttendanceSystem.Controller;


import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cas/student")
@RequiredArgsConstructor
public class StudentController {
    private final AttendanceService attendanceService;
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Welcome User");
    }

    @GetMapping("/sign-attendance")
    public ResponseEntity<String> signAttendance(@AuthenticationPrincipal User student){
        if (student.getRole() == Role.STUDENT){
            attendanceService.signAttendance(student);
        }
        return ResponseEntity.ok("Attendance Marked");
    }
}
