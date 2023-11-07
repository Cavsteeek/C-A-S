package com.Group11Project.ClassAttendanceSystem.Controller;

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
        Optional<Student> student = teacherService.findStudentById(id);
        if (student.isPresent()){
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-student/{id}") //delete student by id endpoint
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll-students") //Get all students endpoint
    public ResponseEntity<List<Student>> findAllStudents(){
        List<Student> students = teacherService.findAllStudents();
        if (!students.isEmpty()) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-student/{fName}") //Get student by first name endpoint
    public ResponseEntity<List<Student>> findByfName(String fName){
        List<Student> students = teacherService.findStudentByfName(fName);
        if (!students.isEmpty()){
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-student/{lName}") //Get student by last name endpoint
    public ResponseEntity<List<Student>> findBylName(String lName){
        List<Student> students = teacherService.findStudentBylName(lName);
        if (!students.isEmpty()){
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
