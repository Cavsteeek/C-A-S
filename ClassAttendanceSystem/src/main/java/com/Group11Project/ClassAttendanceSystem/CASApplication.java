package com.Group11Project.ClassAttendanceSystem;

import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;


@SpringBootApplication
public class CASApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		try {
			SpringApplication.run(CASApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void run(String... args) {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if (null == adminAccount){
			User user = new User();
			user.setEmail("admin@gmail.com");
			user.setFirstname("admin");
			user.setLastname("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
}
