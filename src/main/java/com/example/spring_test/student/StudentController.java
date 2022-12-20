package com.example.spring_test.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents (){
        List<StudentEntity> allStudents = studentService.getAllStudents();

        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById (@PathVariable Long id){
        StudentEntity student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }

    @PostMapping
    public  ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student){
        System.out.println(student.toString());
        StudentEntity newStudent = studentService.createStudent(student);

        return ResponseEntity.ok(newStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> editStudent(@PathVariable Long id, @RequestBody StudentEntity student){
        StudentEntity editedStudent = studentService.editStudent(id, student);

        return ResponseEntity.ok(editedStudent);
    }

    @DeleteMapping
    public ResponseEntity<List<StudentEntity>> deleteStudents(){
        return ResponseEntity.ok(studentService.deleteStudents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentEntity> deleteStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.deleteStudentById(id));
    }
}
