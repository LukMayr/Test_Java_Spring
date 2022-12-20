package com.example.spring_test.student;

import java.util.List;

public interface StudentService {
    public List<StudentEntity> getAllStudents();

    public StudentEntity getStudentById(Long id);

    public StudentEntity createStudent(StudentEntity student);

    public StudentEntity editStudent(Long id, StudentEntity student);

    public List<StudentEntity> deleteStudents();

    public StudentEntity deleteStudentById(Long id);
}
