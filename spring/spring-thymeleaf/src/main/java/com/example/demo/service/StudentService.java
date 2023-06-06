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

        return students;

    }


}
