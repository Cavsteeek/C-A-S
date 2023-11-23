package com.Group11Project.ClassAttendanceSystem.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse
{
    private String token;
    private String refreshToken;
}
