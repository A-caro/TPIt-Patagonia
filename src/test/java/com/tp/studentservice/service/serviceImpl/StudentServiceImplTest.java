package com.tp.studentservice.service.serviceImpl;

import com.tp.studentservice.model.Student;
import com.tp.studentservice.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentServiceImplTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentService;

    List<Student> studentList;
    Student student;


    @BeforeEach
    void setUp() {
        student = new Student(1L, "Recannati", "Barbara",  LocalDate.of(1986,11,28));
        studentList = new ArrayList<>();
        studentList.add(new Student(1L, "Recannati", "Barbara",  LocalDate.of(1986,11,28)));
        studentList.add(new Student(2L, "Bertoldi", "Marilina",  LocalDate.of(1988,9,13)));
        studentList.add(new Student(3L, "Prince", "Chloe",  LocalDate.of(2006,12,5)));
        studentList.add(new Student(4L, "Prince", "Jenny",  LocalDate.of(2007,11,6)));
    }

    @Test
    void findById()  {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        assertNotNull(studentService.findById(1L));
    }

    @Test
    void findAllStudent() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1L, "Recannati", "Barbara",  LocalDate.of(1986,11,28)));
        studentList.add(new Student(2L, "Bertoldi", "Marilina",  LocalDate.of(1988,9,13)));




        when(studentRepository.findAll()).thenReturn(studentList);
        assertFalse(studentService.findAllStudent().isEmpty());
    }

    @Test
    void createStudent() {
        Student newStudent = new Student(null, "Recannati", "Barbara",  LocalDate.of(1986,11,28));
        Student createStudent = new Student(4L, "Recannati", "Barbara",  LocalDate.of(1986,11,28 ));
        when(studentRepository.save(newStudent)).thenReturn(createStudent);
        assertNotNull(studentService.createStudent(newStudent));
    }

    @Test
    void updateStudent() {
        when(studentRepository.save(student)).thenReturn(student);
        when(studentRepository.findById(1L)).thenReturn(Optional.ofNullable(student));
        Student updateStudent = studentService.updateStudent(student);
        assertNotNull(updateStudent);
        assertNotNull(updateStudent.getId());

    }

    @Test
    void deleteStudent(){
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());
        doNothing().when(studentRepository).delete(student);
        studentRepository.delete(student);
        assertFalse(studentRepository.findById(student.getId()).isPresent());
    }


  @Test
    void edadPromedio() {
        when(studentRepository.findAll()).thenReturn(studentList);
        assertEquals(24, studentService.edadPromedio());
    }

    @Test
    void estudianteConMasEdad() {
        when(studentRepository.findAll()).thenReturn(studentList);
      assertEquals(35, studentService.estudianteConMasEdad());
    }

    @Test
    void estudianteConMenosEdad() {
        when(studentRepository.findAll()).thenReturn(studentList);
        assertEquals(14, studentService.estudianteConMenosEdad());
    }


    @Test
    void promedioEstudianteMayor() {
        when(studentRepository.findAll()).thenReturn(studentList);
        assertEquals( 34, studentService.promedioEstudianteMayor());
    }

    @Test
    void promedioEstudianteMenor() {
        when(studentRepository.findAll()).thenReturn(studentList);
        assertEquals( 14, studentService.promedioEstudianteMenor());
    }


//No supe resolver el resto de los test.



}