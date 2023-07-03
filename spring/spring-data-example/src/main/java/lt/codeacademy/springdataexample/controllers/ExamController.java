package lt.codeacademy.springdataexample.controllers;

import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping
    public ResponseEntity<ExamDTO> addExam(@RequestBody ExamDTO examDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(examService.addExam(ExamConverter.convertExamDtoToExam(examDto)));
    }

    @PutMapping
    public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO examDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(examService.updateExam(examDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> getExamById(@PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ExamConverter.convertExamToExamDTO(examService.getExamById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamById(@PathVariable Long id) {

        examService.deleteExamById(id);
        return ResponseEntity.noContent().build();

    }


//    @GetMapping("/searchByTitle")
//    public ResponseEntity<ExamDTO> getExamByTitle(@RequestParam String title) {
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(ExamConverter.convertExamToExamDTO(examService.getExamByTitle(title)));
//    }


    @GetMapping
    public List<ExamDTO> getAllExams() {
        return ExamConverter.convertExamsToExamDTO(this.examService.getAllExams());
    }
}
