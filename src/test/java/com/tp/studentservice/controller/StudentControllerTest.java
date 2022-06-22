package com.tp.studentservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.studentservice.model.Student;
import com.tp.studentservice.repository.StudentRepository;
import com.tp.studentservice.service.serviceImpl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
class StudentControllerTest {

    @MockBean
    StudentServiceImpl studentService;

    @MockBean
    StudentRepository studentRepository;

    @Autowired
    MockMvc mockMvc;

    Student student;


    @BeforeEach
    void setUp() {
       student = new Student(1L, "Recannati", "Barbara",  LocalDate.of(1986,11,28));

    }

    @Test
    void findById() throws Exception {
        when(studentService.findById(1L)).thenReturn(Optional.of(student));
        mockMvc.perform(MockMvcRequestBuilders.get("/students").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    void findAllStudent() throws Exception {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1L, "Recannati", "Barbara",  LocalDate.of(1986,11,28)));
        studentList.add(new Student(2L, "Bertoldi", "Marilina",  LocalDate.of(1988,9,13)));
        when(studentService.findAllStudent()).thenReturn(studentList);
        mockMvc.perform(MockMvcRequestBuilders.get("/students").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

//No supe resolver el resto de los test, me encontré con errores que no pude solucionar.
}