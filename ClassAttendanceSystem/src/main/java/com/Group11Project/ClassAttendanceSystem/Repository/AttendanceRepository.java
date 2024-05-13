package com.Group11Project.ClassAttendanceSystem.Repository;

import com.Group11Project.ClassAttendanceSystem.Model.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceRecord, Long> {
}
