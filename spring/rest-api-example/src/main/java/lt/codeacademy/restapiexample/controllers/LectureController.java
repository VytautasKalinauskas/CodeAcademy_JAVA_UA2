package lt.codeacademy.restapiexample.controllers;

import lt.codeacademy.restapiexample.converters.LectureConverter;
import lt.codeacademy.restapiexample.dto.LectureDTO;
import lt.codeacademy.restapiexample.entities.Lecture;
import lt.codeacademy.restapiexample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public LectureDTO getLecture(){
        Lecture testLecture = new Lecture("Paskaitos pavadinimas", studentService.getAllStudents());
        return LectureConverter.convertLectureToDTO(testLecture);
    }
}
