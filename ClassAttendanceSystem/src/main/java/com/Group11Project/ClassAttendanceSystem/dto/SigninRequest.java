package com.Group11Project.ClassAttendanceSystem.dto;

import lombok.Data;

@Data
public class SigninRequest {
    private String matricNumber;
    private String staffId;
    private String password;

}
