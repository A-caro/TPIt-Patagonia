package com.tp.studentservice.repository;

import com.tp.studentservice.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;




    @BeforeEach
    void setUp() {

    }

    @Test
    void findById(){
        assertTrue(studentRepository.findById(3L).isPresent());
    }

    @Test
    void findAll(){
        List<Student> list = studentRepository.findAll();

        assertFalse(list.isEmpty());
        assertTrue(list.size()>0);
    }

    @Test
    void create(){
      Student  student = new Student(4L, "Recannati", "Barbara",  LocalDate.of(1986,11,28));
      Student studentSave = studentRepository.save(student);
        assertTrue(studentSave.getId()>0);
    }

   @Test
   void update(){
        Student student = studentRepository.findById(2L).get();
        student.setName("Rocio");
        Student studentUpdate = studentRepository.save(student);
        Assertions.assertTrue(studentUpdate.getName().equals("Rocio"));

   }

   @Test
    void delete(){
    Student student = studentRepository.save(new Student(5L, "Nicole", "Nicky", LocalDate.of(2000,8,25)));
    studentRepository.delete(student);
    assertFalse(studentRepository.findById(5L).isPresent());


   }


}