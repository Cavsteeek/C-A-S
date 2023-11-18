package com.Group11Project.ClassAttendanceSystem.Security.jwt;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

public interface JwtProviderImpl {
        String generateToken(Authentication authentication);
    }

}
