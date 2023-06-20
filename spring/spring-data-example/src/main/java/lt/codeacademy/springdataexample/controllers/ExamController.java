package lt.codeacademy.springdataexample.controllers;

import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.Question;
import lt.codeacademy.springdataexample.services.ExamService;
import lt.codeacademy.springdataexample.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public void addExam(@RequestBody Exam exam) {
        this.examService.addExam(exam);
    }

    @GetMapping
    public List<ExamDTO> getAllExams() {
        return ExamConverter.convertExamsToExamDTO(this.examService.getAllExams());
    }


    @PostMapping("/{id}/questions")
    public ResponseEntity<Void> addExamQuestion(@PathVariable Long id, @RequestBody Question question) {
        try {
            this.questionService.addQuestionToExam(id, question);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Exam by ID: %s not found", id));
        }
    }
}
