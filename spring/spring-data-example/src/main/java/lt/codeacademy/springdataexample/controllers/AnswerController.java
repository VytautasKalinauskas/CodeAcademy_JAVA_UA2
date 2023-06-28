package lt.codeacademy.springdataexample.controllers;

import lt.codeacademy.springdataexample.converters.AnswerConverter;
import lt.codeacademy.springdataexample.dto.AnswerDTO;
import lt.codeacademy.springdataexample.dto.CreateUpdateAnswerDTO;
import lt.codeacademy.springdataexample.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {


    @Autowired
    AnswerService answerService;
    @PostMapping
    public ResponseEntity<AnswerDTO> createAnswer(@RequestBody CreateUpdateAnswerDTO answerDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(answerService.addAnswer(AnswerConverter.convertAnswerDtoToAnswer(answerDTO)));
    }

    @PutMapping
    public ResponseEntity<AnswerDTO> updateAnswer(@RequestBody CreateUpdateAnswerDTO answerDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(answerService.updateAnswer(AnswerConverter.convertAnswerDtoToAnswer(answerDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDTO> getAnswerById(@PathVariable Long id) {
        return ResponseEntity.ok(answerService.getAnswerById(id));
    }

    @GetMapping
    public ResponseEntity<List<AnswerDTO>> getAllAnswers(@RequestParam(name = "isCorrect", required = false) Boolean isCorrect) {
        return ResponseEntity.ok(answerService.getAllAnswers(isCorrect));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswerById(@PathVariable Long id) {
        answerService.deleteAnswerById(id);
        return ResponseEntity.noContent().build();
    }





}
