package lt.codeacademy.springdataexample.controllers;

import lt.codeacademy.springdataexample.converters.QuestionConverter;
import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionDTO> addExamQuestion(@RequestBody QuestionDTO questionDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(questionService.addQuestionToExam(QuestionConverter.convertQuestionDtoToQuestion(questionDto)));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Exam by ID: %s not found", questionDto.getExamId()));
        }
    }


}
