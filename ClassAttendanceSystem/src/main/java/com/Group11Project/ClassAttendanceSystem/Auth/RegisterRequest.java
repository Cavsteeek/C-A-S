package com.Group11Project.ClassAttendanceSystem.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;

    private String lastname;

    private String matricNumber;

    private String password;
}
