package com.Group11Project.ClassAttendanceSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class CASApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(CASApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
