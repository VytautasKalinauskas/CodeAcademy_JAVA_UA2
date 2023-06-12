package lt.codeacademy.restapiexample.controllers;


import lt.codeacademy.restapiexample.dto.CreateStudentDTO;
import lt.codeacademy.restapiexample.entities.Student;
import lt.codeacademy.restapiexample.exceptions.InvalidPersonalCodeException;
import lt.codeacademy.restapiexample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
//        try {
//            return ResponseEntity.ok().body(this.studentService.findStudentById(id));
//        } catch (NoSuchElementException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Student by ID: %s not found", id));
//        }
//    }

    @GetMapping("/{personalCode}")
    public ResponseEntity<Student> getStudentByPersonalCode(@PathVariable Long personalCode) {
        try {
            return ResponseEntity.ok().body(this.studentService.findStudentByPersonalCode(personalCode));
        } catch (InvalidPersonalCodeException | NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Student by personalCode: %s not found", personalCode));
        }
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody CreateStudentDTO createStudentDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.addStudent(new Student(createStudentDTO)));
        } catch (InvalidPersonalCodeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok().body(this.studentService.deleteStudentById(id));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Student by ID: %s not found", id));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Student>> replaceStudentById(@PathVariable Long id, @RequestBody CreateStudentDTO createStudentDTO) {
        try {
            return ResponseEntity.ok().body(this.studentService.replaceStudentById(id, createStudentDTO));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Student by ID: %s not found", id));
        }
    }

//    @PatchMapping("/{id}")
//    public List<Student> patchStudentById(@PathVariable Long id, @RequestBody Student student) {
//        return this.studentService.patchStudentById(id, student);
//    }
}
