package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Repository.AttendanceRecordRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.CourseRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.StudentRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.TeacherRepository;
import com.Group11Project.ClassAttendanceSystem.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final AttendanceRecordRepository attendanceRecordRepository;
    private final CourseRepository courseRepository;



    @Override // Find student by id
    public Optional<Student> findStudentById(Long id)
    {
        return studentRepository.findById(id);
    }
    @Override // Delete student By Id
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
    /*@Override
    public Optional<Teacher> findTeacherById(Long id)
    {
        return teacherRepository.findById(id);
    }*/
    @Override // Find all Students
    public List<Student> findAllStudents()
    {
        return studentRepository.findAll();
    }
    @Override // Delete Attendance Record By Id
    public void deleteARById(Long id){
        attendanceRecordRepository.deleteById(id);
    }
    @Override // Create Course
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
    @Override // Update Course By id
    public Course updateCourseById(Course course){
        Course existingCourse = courseRepository.findById(course.getId()).get();
        existingCourse.setCName(course.getCName());
        existingCourse.setCTitle(course.getCTitle());
        return courseRepository.save(course);
    }
    @Override // Delete Course By Id
    public void deleteCourseById(Long id){
        courseRepository.deleteById(id);
    }
    @Override //Find course By id
    public Optional<Course> findCourseById(Long id)
    {
        return courseRepository.findById(id);
    }
    @Override
    public Optional<Course> findBycName(String cName){

    }
    @Override // Find all courses
    public List<Course> findAllCourses()
    {
        return courseRepository.findAll();
    }

}
