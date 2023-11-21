package com.Group11Project.ClassAttendanceSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
