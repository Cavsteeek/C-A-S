package com.Group11Project.ClassAttendanceSystem.Controller;


import com.Group11Project.ClassAttendanceSystem.Service.AdminService;
import com.Group11Project.ClassAttendanceSystem.Service.StudentService;
import com.Group11Project.ClassAttendanceSystem.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //@PostMapping("/")
}
