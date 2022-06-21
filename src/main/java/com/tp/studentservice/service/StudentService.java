package com.tp.studentservice.service;

import com.tp.studentservice.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public interface StudentService {

    Optional<Student> findById(Long id);

    List<Student> findAllStudent();

    Student createStudent(Student createStudent);

    Student updateStudent(Student updateStudent);

    void deleteStudent(Long id);

    int edadPromedio();

    int estudianteConMasEdad();

    int estudianteConMenosEdad();

    String getDatosStudents();

    List<Student> estudianteMayor();

    List<Student> estudianteMenor();

    Integer promedioEstudianteMayor();

    Integer promedioEstudianteMenor();

}


