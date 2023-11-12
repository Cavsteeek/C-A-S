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
        try {
            deleteStudentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-students") //Get all students
    public ResponseEntity<List<Student>> findAllStudents() {
        try{
            List<Student> students = adminService.findAllStudents();
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
    public ResponseEntity<List<Student>> findByfName(@PathVariable ("fName") String fName) {
        try {
            List<Student> students = adminService.findStudentByfName(fName);
            if (!students.isEmpty()) {
                return new ResponseEntity<>(students, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-student-by-lname/{lName}") //Get student by last name
    public ResponseEntity<List<Student>> findBylName(@PathVariable ("lName")String lName) {
        try {
            List<Student> students = adminService.findStudentBylName(lName);
            if (!students.isEmpty()) {
                return new ResponseEntity<>(students, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-all-students") //Delete all students
    public ResponseEntity<Void> deleteAllStudents() {
        try {
            adminService.deleteStudents();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new-course")
    public ResponseEntity<Course> newCourse(@RequestBody Course course) {
        try {
            if (course.getCName() != null) {
                Course savedCourse = adminService.saveCourse(course);
                return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-course-details/{id}") //Update course details by id
    public ResponseEntity<Course> updateCourseById(@PathVariable("id") Long id, @RequestBody Course course) {
        try {
            course.setId(id);
            Course updatedCourse = adminService.updateCourseById(id, course).getBody();

            if (updatedCourse != null) {
                return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-course/{id}") // delete course by id
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        try {
            adminService.deleteCourseById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-course-by-cname/{cName}") // get course by name
    public ResponseEntity<List<Course>> findCourseByName(@PathVariable("cName")String  cName) {
        try {
            List<Course> courses = adminService.findBycName(cName);
            if (!courses.isEmpty()) {
                return new ResponseEntity<>(courses, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-course-by-ctitle/{cTitle}") // get course by title
    public ResponseEntity<List<Course>> findCourseByTitle(@PathVariable("cTitle")String cTitle) {
        try {
            List<Course> courses = adminService.findCourseByTitle(cTitle);
            if (!courses.isEmpty()) {
                return new ResponseEntity<>(courses, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-courses") // get all courses
    public ResponseEntity<List<Course>> findAllCourse() {
        try {
            List<Course> courses = adminService.findAllCourses();
            if (!courses.isEmpty()) {
                return new ResponseEntity<>(courses, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
        try {
            adminService.deleteCourses();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-attendance/{id}") // delete attendance by id
    public ResponseEntity<Void> deleteRecordById(@PathVariable Long id) {
        try {
            adminService.deleteARById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-all-attendance") // delete all attendance
    public ResponseEntity<Void> deleteRecord() {
        try {
            adminService.deleteRecord();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-teacher/{id}") // find teacher by id
    public ResponseEntity<Optional<Teacher>> findTeacherById(@PathVariable("id") Long id) {
        try {
            Optional<Teacher> teacher = adminService.findTeacherById(id);
            if (teacher.isPresent()) {
                return new ResponseEntity<>(teacher, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-teachers")
    public ResponseEntity<List<Teacher>> findAllTeachers()
    {
        try {
            List<Teacher> teachers = adminService.findAllTeachers();
            if (!teachers.isEmpty()) {
                return new ResponseEntity<>(teachers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-teacher/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        try {
            adminService.deleteTeacherById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<Void> deleteAll(){
        try {
            adminService.deleteAllTeachers();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    



}
