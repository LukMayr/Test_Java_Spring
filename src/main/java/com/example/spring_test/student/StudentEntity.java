package com.example.spring_test.student;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
public class StudentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int catalogNumber;

    @Column
    private String classRoom;

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalogNumber=" + catalogNumber +
                ", classRoom='" + classRoom + '\'' +
                '}';
    }
}
