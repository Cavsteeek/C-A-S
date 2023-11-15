package com.Group11Project.ClassAttendanceSystem.Repository;

import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //Optional<Student> findByUsername(String username);
    List<Student> findByfName(String fName);
    List<Student> findBylName(String lName);
    Optional<Student> findBymatNo(String matricNumber);


}
