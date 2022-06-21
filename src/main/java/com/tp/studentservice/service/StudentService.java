package com.tp.studentservice.service;

import com.tp.studentservice.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> findById(Long id);

    List<Student> findAllStudent();

    Student createStudent(Student createStudent);

    Student updateStudent(Student updateStudent);

    void deleteStudent(Long id);

    int edadPromedio();

//   List<Student> mayorMenor();

//    int promedioEstudianteMasGrande();


}
