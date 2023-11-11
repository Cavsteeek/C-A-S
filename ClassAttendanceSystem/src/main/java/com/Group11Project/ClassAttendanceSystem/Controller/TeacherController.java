package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/cas/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get-student/{id}") //get student by id
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable("id") Long id)
    {
        try {
            Optional<Student> student = teacherService.findStudentById(id);
            if (student.isPresent()) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete-student/{id}") //delete student by id
    public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Long id){
        teacherService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-all-students") //Get all students
    public ResponseEntity<List<Student>> findAllStudents(){
        List<Student> students = teacherService.findAllStudents();
        if (!students.isEmpty()) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-student-by-fname/{fName}") //Get student by first name
    public ResponseEntity<List<Student>> findByfName(@PathVariable("fName")String fName){
        List<Student> students = teacherService.findStudentByfName(fName);
        if (!students.isEmpty()){
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-student-by-lname/{lName}") //Get student by last name
    public ResponseEntity<List<Student>> findBylName(@PathVariable("lName")String lName){
        List<Student> students = teacherService.findStudentBylName(lName);
        if (!students.isEmpty()){
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-all-students") //Delete all students
    public ResponseEntity<Void> deleteAllStudents(){
        teacherService.deleteStudents();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add-course") // create new course
    public ResponseEntity<Course> newCourse (@RequestBody Course course)
    {
        Course course1 = teacherService.saveCourse(course);
        return new ResponseEntity<>(course1, HttpStatus.CREATED);
    }

    @PutMapping("/update-course/{id}") //Update course details by id
    public ResponseEntity<Course> updateCourseById(@PathVariable("id") Long id, @RequestBody Course course)
    {
        course.setId(id);
        Course updatedCourse = teacherService.updateCourseById(id, course).getBody();

        if (updatedCourse != null) {
            return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/delete-course/{id}") // delete course by id
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id)
    {
        teacherService.deleteCourseById(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-course-by-cname/{cName}") // get course by name
    public ResponseEntity<List<Course>> findCourseByName(String cName)
    {
        List<Course> courses = teacherService.findBycName(cName);
        if (!courses.isEmpty())
        {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-course-by-ctitle/{cTitle}") // get course by title
    public ResponseEntity<List<Course>> findCourseByTitle(String cTitle)
    {
        List<Course> courses = teacherService.findCourseByTitle(cTitle);
        if (!courses.isEmpty())
        {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-all-courses") // get all courses
    public ResponseEntity<List<Course>> findAllCourse(){
        List<Course> courses = teacherService.findAllCourses();
        if (!courses.isEmpty()) {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get-course-by-id/{id}") // get student by id
    public ResponseEntity<Optional<Course>> findCourseById(@PathVariable Long id)
    {
        try {
            Optional<Course> course = teacherService.findCourseById(id);
            if (course.isPresent()) {
                return new ResponseEntity<>(course, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-all-courses") // delete all courses
    public ResponseEntity<Void> deleteCourse(){
        teacherService.deleteCourses();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-attendance/{id}") // delete attendance by id
    public ResponseEntity<Void> deleteRecordById(@PathVariable Long id)
    {
        teacherService.deleteARById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-all-attendance") // delete all attendance
    public ResponseEntity<Void> deleteRecord(){
        teacherService.deleteRecord();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
