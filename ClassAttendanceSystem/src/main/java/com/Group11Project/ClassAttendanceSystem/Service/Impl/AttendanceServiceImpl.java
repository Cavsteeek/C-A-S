package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Model.AttendanceRecord;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Repository.AttendanceRepository;
import com.Group11Project.ClassAttendanceSystem.Service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

    public void signAttendance (User student){
        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setDate(new Date());
        attendanceRepository.save(attendanceRecord);
    }
}
