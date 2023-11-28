package com.Group11Project.ClassAttendanceSystem.dto;

import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class JwtAuthenticationResponse
{
    private String token;
    private String refreshToken;
    private Role role;
}
