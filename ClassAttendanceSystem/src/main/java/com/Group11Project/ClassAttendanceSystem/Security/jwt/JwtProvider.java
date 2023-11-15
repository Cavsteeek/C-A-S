package com.Group11Project.ClassAttendanceSystem.Security.jwt;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider implements JwtProviderImpl {
    @Value("app.jwt.secret")
    private String JWT_SECRET;
    @Value("${app.jwt.expiration-in-m}")
    private String JWT_EXPIRATION_IN_M;



}
