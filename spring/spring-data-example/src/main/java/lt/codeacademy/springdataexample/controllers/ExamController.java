package lt.codeacademy.springdataexample.controllers;

import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.converters.QuestionConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.dto.QuestionDTO;
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
    public ResponseEntity<ExamDTO> addExam(@RequestBody ExamDTO examDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(examService.addExam(ExamConverter.convertExamDtoToExam(examDto)));
    }

    @GetMapping
    public List<ExamDTO> getAllExams() {
        return ExamConverter.convertExamsToExamDTO(this.examService.getAllExams());
    }


    @PostMapping("/{id}/questions")
    public ResponseEntity<QuestionDTO> addExamQuestion(@PathVariable Long id, @RequestBody QuestionDTO questionDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(questionService.addQuestionToExam(id, QuestionConverter.convertQuestionDtoToQuestion(questionDto)));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Exam by ID: %s not found", id));
        }
    }
}
