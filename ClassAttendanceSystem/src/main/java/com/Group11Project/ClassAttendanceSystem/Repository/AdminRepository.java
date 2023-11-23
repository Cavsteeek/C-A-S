package com.Group11Project.ClassAttendanceSystem.Repository;

import com.Group11Project.ClassAttendanceSystem.Model.Admin;
import com.Group11Project.ClassAttendanceSystem.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

     Optional<Admin> findByEmail(String email);

     Admin findByRole(Role role);
}
