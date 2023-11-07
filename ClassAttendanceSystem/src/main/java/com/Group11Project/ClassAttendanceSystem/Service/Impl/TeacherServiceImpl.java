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
    @Override // Find all Students
    public List<Student> findAllStudents()
    {
        return studentRepository.findAll();
    }
    @Override // Find course by first name
    public List<Student> findStudentByfName(String fName){
        return studentRepository.findByFirstName(fName);
    }
    @Override // Find student by last name
    public List<Student> findStudentBylName(String lName){
        return studentRepository.findByLastName(lName);
    }
    @Override //Delete all students
    public void deleteStudents(){
        studentRepository.deleteAll();
    }


    @Override // Delete Attendance Record By id
    public void deleteARById(Long id){
        attendanceRecordRepository.deleteById(id);
    }
    @Override //Delete A whole record
    public void deleteRecord(){
        attendanceRecordRepository.deleteAll();
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
    @Override // Find course by name
    public List<Course> findBycName(String cName){
        return courseRepository.findBycName(cName);
    }
    @Override // Find course by title
    public List<Course> findCourseByTitle(String cTitle){
        return courseRepository.findBycTitle(cTitle);
    }
    @Override // Find all courses
    public List<Course> findAllCourses()
    {
        return courseRepository.findAll();
    }
    @Override //Delete all courses
    public void deleteCourses(){
        courseRepository.deleteAll();
    }

}
