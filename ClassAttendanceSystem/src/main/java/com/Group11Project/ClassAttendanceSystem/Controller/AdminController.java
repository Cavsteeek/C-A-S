package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;
import com.Group11Project.ClassAttendanceSystem.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cas/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/get-student/{id}") //get student by id
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable("id") Long id) {
        try {
            Optional<Student> student = adminService.findStudentById(id);
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
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        adminService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-all-students") //Get all students
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students = adminService.findAllStudents();
        if (!students.isEmpty()) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-student-by-fname/{fName}") //Get student by first name
    public ResponseEntity<List<Student>> findByfName(@PathVariable ("fName") String fName) {
        List<Student> students = adminService.findStudentByfName(fName);
        if (!students.isEmpty()) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-student-by-lname/{lName}") //Get student by last name
    public ResponseEntity<List<Student>> findBylName(@PathVariable ("lName")String lName) {
        List<Student> students = adminService.findStudentBylName(lName);
        if (!students.isEmpty()) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-all-students") //Delete all students
    public ResponseEntity<Void> deleteAllStudents() {
        adminService.deleteStudents();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add-course") // create new course
    public ResponseEntity<Course> newCourse(@RequestBody Course course) {
        Course course1 = adminService.saveCourse(course);
        return new ResponseEntity<>(course1, HttpStatus.CREATED);
    }

    @PutMapping("/update-course-details/{id}") //Update course details by id
    public ResponseEntity<Course> updateCourseById(@PathVariable("id") Long id, @RequestBody Course course) {
        course.setId(id);
        Course updatedCourse = adminService.updateCourseById(id, course).getBody();

        if (updatedCourse != null) {
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/delete-course/{id}") // delete course by id
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        adminService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-course-by-cname/{cName}") // get course by name
    public ResponseEntity<List<Course>> findCourseByName(@PathVariable("cName")String  cName) {
        List<Course> courses = adminService.findBycName(cName);
        if (!courses.isEmpty()) {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-course-by-ctitle/{cTitle}") // get course by title
    public ResponseEntity<List<Course>> findCourseByTitle(@PathVariable("cTitle")String cTitle) {
        List<Course> courses = adminService.findCourseByTitle(cTitle);
        if (!courses.isEmpty()) {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-all-courses") // get all courses
    public ResponseEntity<List<Course>> findAllCourse() {
        List<Course> courses = adminService.findAllCourses();
        if (!courses.isEmpty()) {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get-course-by-id/{id}") // get student by id
    public ResponseEntity<Optional<Course>> findCourseById(@PathVariable("id") Long id) {
        try {
            Optional<Course> course = adminService.findCourseById(id);
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
    public ResponseEntity<Void> deleteCourse() {
        adminService.deleteCourses();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-attendance/{id}") // delete attendance by id
    public ResponseEntity<Void> deleteRecordById(@PathVariable Long id) {
        adminService.deleteARById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-all-attendance") // delete all attendance
    public ResponseEntity<Void> deleteRecord() {
        adminService.deleteRecord();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-teacher/{id}") // find teacher by id
    public ResponseEntity<Optional<Teacher>> findTeacherById(@PathVariable("id") Long id) {
        Optional<Teacher> teacher = adminService.findTeacherById(id);
        if (teacher.isPresent()) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-all-teachers")
    public ResponseEntity<List<Teacher>> findAllTeachers()
    {
        List<Teacher> teachers = adminService.findAllTeachers();
        if (!teachers.isEmpty()){
            return new ResponseEntity<>(teachers, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-teacher/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        adminService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    



}
