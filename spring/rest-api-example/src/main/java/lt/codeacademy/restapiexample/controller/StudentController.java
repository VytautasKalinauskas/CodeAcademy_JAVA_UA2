package lt.codeacademy.restapiexample.controller;


import lt.codeacademy.restapiexample.entity.Student;
import lt.codeacademy.restapiexample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) throws Exception {
        return this.studentService.findStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable Long id) throws Exception {
        return this.studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public List<Student> replaceStudentById(@PathVariable Long id, @RequestBody Student student) {
        return this.studentService.replaceStudentById(id, student);
    }

    @PatchMapping("/{id}")
    public List<Student> patchStudentById(@PathVariable Long id, @RequestBody Student student) {
        return this.studentService.patchStudentById(id, student);
    }
}
