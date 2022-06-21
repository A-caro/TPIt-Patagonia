package com.tp.studentservice.service.serviceImpl;

import com.tp.studentservice.model.Student;
import com.tp.studentservice.repository.StudentRepository;
import com.tp.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }


    @Override
    public Student createStudent(Student createStudent) {
        return studentRepository.save(createStudent);
    }


    @Override
    public Student updateStudent(Student updateStudent) {
        return studentRepository.save(updateStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


//Calcular la edad promedio de los students.
    @Override
    public int edadPromedio() {
        List<Student> studentList = studentRepository.findAll();
        return (int) studentList.stream().
                mapToInt(student -> Period.between(student.getBirthday(), LocalDate.now()).getYears()).average().orElseThrow();
    }




//Mostrar el student con más edad y con menos edad.

    public int estudianteConMasEdad() {
        List<Student> student = studentRepository.findAll();
        return student.stream().mapToInt(s -> Period.between(s.getBirthday(), LocalDate.now()).getYears()).max().orElse(0);
    }

    public int estudianteConMenosEdad() {
        List<Student> student = studentRepository.findAll();
        return student.stream().mapToInt(s -> Period.between(s.getBirthday(), LocalDate.now()).getYears()).min().orElse(0);
    }

//Mostrar solo el id, surname y name de los students. Por ejemplo: 1 - , Lovelace, Ada.

    public String getDatosStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map(s-> s.getId() + " , " + s.getSurname() + " , " + s.getName()).collect(Collectors.joining("\n"));
    }

//Listar students mayores de edad y los menores de edad.

    public List<Student> estudianteMayor() {
        List<Student> student = studentRepository.findAll();
        return student.stream().filter(s -> Period.between(s.getBirthday(), LocalDate.now()).getYears() > 18).collect(Collectors.toList());
    }


    public List<Student> estudianteMenor() {
        List<Student> student = studentRepository.findAll();
        return student.stream().filter(s -> Period.between(s.getBirthday(), LocalDate.now()).getYears() < 18).collect(Collectors.toList());
    }

//Mostrar la edad promedio de los mayores de edad.

    public Integer promedioEstudianteMayor(){
        List<Student> student = studentRepository.findAll();
        return (int)student.stream().mapToInt(s -> Period.between(s.getBirthday(),LocalDate.now()).getYears()).filter(s -> s > 18).average().orElse(0);
    }


//Mostrar la edad promedio de los menores de edad.

    public Integer promedioEstudianteMenor(){
        List<Student> student = studentRepository.findAll();
        return (int)student.stream().mapToInt(s -> Period.between(s.getBirthday(),LocalDate.now()).getYears()).filter(s -> s < 18).average().orElse(0);
    }


}

