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

    @DeleteMapping("/delete-student/{id}") // delete student by id
    public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Long id) {
        try {
            teacherService.deleteStudentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-students") // Get all students
    public ResponseEntity<List<Student>> findAllStudents() {
        try {
            List<Student> students = teacherService.findAllStudents();
            if (!students.isEmpty()) {
                return new ResponseEntity<>(students, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/get-student-by-fname/{fName}") //Get student by first name
    public ResponseEntity<List<Student>> findByfName(@PathVariable("fName")String fName){
        try{
            List<Student> students = teacherService.findStudentByfName(fName);
            if (!students.isEmpty()){
                return new ResponseEntity<>(students, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-student-by-lname/{lName}") //Get student by last name
    public ResponseEntity<List<Student>> findBylName(@PathVariable("lName")String lName){
        try {
            List<Student> students = teacherService.findStudentBylName(lName);
            if (!students.isEmpty()){
                return new ResponseEntity<>(students, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-all-students") //Delete all students
    public ResponseEntity<Void> deleteAllStudents(){
        try {
            teacherService.deleteStudents();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new-course") // create new course
    public ResponseEntity<Course> newCourse (@RequestBody Course course)
    {
        try {
            Course course1 = teacherService.saveCourse(course);
            return new ResponseEntity<>(course, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update-course/{id}") //Update course details by id
    public ResponseEntity<Course> updateCourseById(@PathVariable("id") Long id, @RequestBody Course course)
    {
       try {
           course.setId(id);
           Course updatedCourse = teacherService.updateCourseById(id, course).getBody();

           if (updatedCourse != null) {
               return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
           } else {
               return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
           }
       } catch (Exception e) {
           // Log the exception
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/delete-course/{id}") // delete course by id
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id)
    {
        try {
            teacherService.deleteCourseById(id);
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-course-by-cname/{cName}") // get course by name
    public ResponseEntity<List<Course>> findCourseByName(@PathVariable("cName")String cName)
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
    public ResponseEntity<List<Course>> findCourseByTitle(@PathVariable("cTitle")String cTitle)
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
        try {
            List<Course> courses = teacherService.findAllCourses();
            if (!courses.isEmpty()) {
                return new ResponseEntity<>(courses, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
        try {
            teacherService.deleteCourses();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-attendance/{id}") // delete attendance by id
    public ResponseEntity<Void> deleteRecordById(@PathVariable Long id)
    {   try {
            teacherService.deleteARById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
        // Log the exception
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @DeleteMapping("/delete-all-attendance") // delete all attendance
    public ResponseEntity<Void> deleteRecord(){
        try {
            teacherService.deleteRecord();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
