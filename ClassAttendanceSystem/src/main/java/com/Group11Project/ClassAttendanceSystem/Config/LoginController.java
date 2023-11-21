package com.Group11Project.ClassAttendanceSystem.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/v1/cas/auth")
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}

