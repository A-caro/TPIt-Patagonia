package com.tp.studentservice.controller;

import com.tp.studentservice.model.Student;
import com.tp.studentservice.service.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

@RestController
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/student/{id}")
    public Optional<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }

    @PostMapping("/create/students")
    public Student createStudent(@RequestBody Student createStudent) {
        return studentService.createStudent(createStudent);
    }

    @PutMapping("/update/students")
    public Student updateStudent(@RequestBody Student updateStudent) {
        return studentService.updateStudent(updateStudent);
    }

    @DeleteMapping("delete/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/edad/promedio")
    public int edadPromedio() {
        return studentService.edadPromedio();
    }

    @GetMapping("/student/con/mas/edad")
    public int estudianteConMasEdad() {
        return studentService.estudianteConMasEdad();
    }

    @GetMapping("/student/con/menos/edad")
    public int estudianteConMenosEdad() {
        return studentService.estudianteConMenosEdad();
    }

    @GetMapping("/student/mayor")
    public List<Student> listarMayores() {
        return studentService.estudianteMayor();
    }

    @GetMapping("/estudianteMenor")
        public List<Student> listarMenores(){
            return studentService.estudianteMenor();
        }


    @GetMapping("/studentMayor/promedio")
    public Integer promedioEstudianteMayor() {
        return studentService.promedioEstudianteMayor();
    }

    @GetMapping("/studentMenor/promedio")
    public Integer promedioEstudianteMenor() {
        return studentService.promedioEstudianteMenor();
    }

    @GetMapping("/students/datos")
    public String getDatosStudents(){
        return studentService.getDatosStudents();
    }




}







