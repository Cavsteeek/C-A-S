package com.Group11Project.ClassAttendanceSystem.Repository;

import com.Group11Project.ClassAttendanceSystem.Model.Admin;
import com.Group11Project.ClassAttendanceSystem.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
     Admin findByRole(Role role);
}
