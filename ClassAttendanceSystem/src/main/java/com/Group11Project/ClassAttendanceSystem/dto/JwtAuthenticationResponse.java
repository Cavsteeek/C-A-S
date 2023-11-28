package com.Group11Project.ClassAttendanceSystem.dto;

import com.Group11Project.ClassAttendanceSystem.Model.Role;
import lombok.Data;

@Data
public class JwtAuthenticationResponse
{
    private String token;
    private String refreshToken;
    private Role role;
}
