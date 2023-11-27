package com.Group11Project.ClassAttendanceSystem.Repository;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>
{

}
