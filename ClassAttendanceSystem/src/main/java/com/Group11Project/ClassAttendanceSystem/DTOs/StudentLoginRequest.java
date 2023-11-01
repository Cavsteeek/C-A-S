package com.Group11Project.ClassAttendanceSystem.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
//@RequiredArgsConstructor
@Getter
@Setter
public class StudentLoginRequest {

    private int matricNumber;
    private String password;
}
