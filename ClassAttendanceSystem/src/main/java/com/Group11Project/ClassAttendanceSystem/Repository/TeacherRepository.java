package com.Group11Project.ClassAttendanceSystem.Repository;

import com.Group11Project.ClassAttendanceSystem.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByfName(String fName);
    List<Teacher> findBylName(String lName);

    Optional<Teacher> findStaffById(int staffId);
}
