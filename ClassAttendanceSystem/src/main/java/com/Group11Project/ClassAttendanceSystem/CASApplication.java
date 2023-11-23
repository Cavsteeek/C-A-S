package com.Group11Project.ClassAttendanceSystem;

import com.Group11Project.ClassAttendanceSystem.Model.Admin;
import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CASApplication implements CommandLineRunner {
	@Autowired
	private AdminRepository adminRepository;

	public static void main(String[] args) {
		try {
			SpringApplication.run(CASApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void run(String... args) throws Exception {
		Admin adminAccount = adminRepository.findByRole(Role.ADMIN);
		if (null == adminAccount){
			Admin admin = new Admin();
			admin.setId();
		}
	}
}
