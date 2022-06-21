package com.tp.studentservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;

    @BeforeEach
    void setUp() {
    student = new Student(1L, "Recannati", "Barbara",  LocalDate.of(1986,11,28));
    }

    @Test
    void getId() {
        assertEquals(1L, student.getId());
    }

    @Test
    void getSurname() {
        assertEquals("Recannati", student.getSurname());
    }

    @Test
    void getName() {
        assertEquals("Barbara", student.getName());
    }

    @Test
    void getBirthday() {
        assertEquals(LocalDate.of(1986,11,28), student.getBirthday());
    }

    @Test
    void setId() {
        student.setId(2L);
        assertEquals(2, student.getId());
    }

    @Test
    void setSurname() {
        student.setSurname("Bertoldi");
        assertEquals("Bertoldi", student.getSurname());
    }

    @Test
    void setName() {
        student.setName("Marilina");
        assertEquals("Marilina", student.getName());
    }

    @Test
    void setBirthday() {
        student.setBirthday(LocalDate.of(1988,9,13));
        assertEquals(LocalDate.of(1988,9,13), student.getBirthday());
    }


}