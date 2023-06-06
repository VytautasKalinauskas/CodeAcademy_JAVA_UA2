package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>();
    Long index = 1L;

    public List<Student> createStudent(Student student) {

        student.setId(index);
        index++;
        students.add(student);
        System.out.println(students.size());

        return students;
    }

    public List<Student> deleteStudent(Long id) {

        students = students
                .stream()
                .filter(student -> !student.getId().equals(id))
                .collect(Collectors.toList());

        return students;
    }

    public Student getStudentById(Long id) {

        Student studentToGet = students
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst().orElseThrow();

        return studentToGet;
    }

    public List<Student> updateStudentById(Long id, Student student) {

        Student studentToUpdate = getStudentById(id);
        studentToUpdate.setName(student.getName());
        studentToUpdate.setSurname(student.getSurname());
        studentToUpdate.setCourse(student.getCourse());

        return students;
    }


}
