package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/create")
    public String showCreateStudentForm(Model model) {

        model.addAttribute("student", new Student());

        System.out.println("I am in show create student form");
        return "create_student_form";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student student, Model model) {

        List<Student> students = studentService.createStudent(student);
        model.addAttribute("students", students);

        return "students_list_form";

    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {

        List<Student> students = studentService.deleteStudent(id);
        model.addAttribute("students", students);
        return "students_list_form";

    }


}
