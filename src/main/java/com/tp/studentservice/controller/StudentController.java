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
@RequestMapping("/students")

public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/list")
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }

    @PostMapping("")
    public Student createStudent(@RequestBody Student createStudent) {
        return studentService.createStudent(createStudent);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student updateStudent) {
        return studentService.updateStudent(updateStudent);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);

    }

    @GetMapping("/edad/promedio")
    public int edadPromedio() {
        return studentService.edadPromedio();
    }

    @GetMapping("/older")
    public int estudianteConMasEdad() {
        return studentService.estudianteConMasEdad();
    }

    @GetMapping("/younger")
    public int estudianteConMenosEdad() {
        return studentService.estudianteConMenosEdad();
    }

    @GetMapping("/mayor")
    public List<Student> listarMayores() {
        return studentService.estudianteMayor();
    }

    @GetMapping("/menor")
        public List<Student> listarMenores(){
            return studentService.estudianteMenor();
        }


    @GetMapping("/mayorpromedio")
    public Integer promedioEstudianteMayor() {
        return studentService.promedioEstudianteMayor();
    }

    @GetMapping("/menorpromedio")
    public Integer promedioEstudianteMenor() {
        return studentService.promedioEstudianteMenor();
    }

    @GetMapping("/datos")
    public String getDatosStudents(){
        return studentService.getDatosStudents();
    }




}







