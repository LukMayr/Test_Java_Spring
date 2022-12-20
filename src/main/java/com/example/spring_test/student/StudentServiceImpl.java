package com.example.spring_test.student;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return studentRepository.getReferenceById(id);
    }

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentEntity editStudent(Long id, StudentEntity student) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);

        if (optionalStudentEntity.isEmpty()) {
            log.error("invalid StudentID" + id);
            throw new EntityNotFoundException("invalid StudentID");
        }
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public List<StudentEntity> deleteStudents(){
        try {
            this.studentRepository.deleteAll();
        } catch (Exception e){
            log.error("couldn't delete all Students");
            return null;
        }

        return this.studentRepository.findAll();
    }

    @Override
    public StudentEntity deleteStudentById(Long id) {
        Optional<StudentEntity> result = this.studentRepository.findById(id);

        if(result.isEmpty()) {
            log.error("Student doesn't exist in DB");
        }
        this.studentRepository.deleteById(id);

        return result.get();
    }
}
