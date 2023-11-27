package com.Group11Project.ClassAttendanceSystem.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;


@Data
public class SignUpRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String password;

}

