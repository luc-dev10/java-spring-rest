package com.rest.controller;

import com.rest.entity.Student;
import com.rest.error.StudentNotFoundRunTimeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @GetMapping("")
    public List<Student> getStudents() {

        List<Student> studentList = new ArrayList<>();

        Student firstStudent = new Student();
        firstStudent.setStudentID(1);
        firstStudent.setFirstName("Lucio");
        firstStudent.setLastName("Zhao");

        Student secondStudent = new Student();
        secondStudent.setStudentID(2);
        secondStudent.setFirstName("Joe");
        secondStudent.setLastName("Doe");

        // add students
        studentList.add(firstStudent);
        studentList.add(secondStudent);

        return studentList;

    }

    @GetMapping("/{studentID}")
    public Student getStudent(@PathVariable int studentID) {

        List<Student> studentList = new ArrayList<>();

        Student firstStudent = new Student();
        firstStudent.setStudentID(1);
        firstStudent.setFirstName("Lucio");
        firstStudent.setLastName("Zhao");

        Student secondStudent = new Student();
        firstStudent.setStudentID(2);
        secondStudent.setFirstName("Joe");
        secondStudent.setLastName("Doe");

        // add students
        studentList.add(firstStudent);
        studentList.add(secondStudent);

        Optional<Student> studentOptional = studentList.stream()
                                                       .filter(student -> student.getStudentID() == studentID)
                                                       .findFirst();

        // get student
        if (!studentOptional.isPresent())
            throw new StudentNotFoundRunTimeException(String.format("Student id not found: %d", studentID));

        return studentOptional.get();

    }

}

