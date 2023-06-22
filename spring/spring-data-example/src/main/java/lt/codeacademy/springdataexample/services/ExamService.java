package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExamService {

    private ExamRepository examRepository;

    public ExamDTO addExam(Exam exam) {
        this.examRepository.saveAndFlush(exam);
        return ExamConverter.convertExamToExamDTO(exam);
    }

    public Exam getExamById(Long examId) {
        Exam e = examRepository.findById(examId).orElse(null);
        return this.examRepository.findById(examId).get();
    }

    public void deleteExamById(Long id) {
        this.examRepository.deleteById(id);
    }

    public ExamDTO updateExam(ExamDTO examDTO) {
        Exam exam = examRepository.findById(examDTO.getId()).orElseThrow();
        exam.setTitle(examDTO.getTitle());
        examRepository.save(exam);
        return ExamConverter.convertExamToExamDTO(exam);
    }

//    public Exam getExamByTitle(String title) {
//        return this.examRepository.findByTitleLike(String.format("%%%s%%", title)).get();
//    }

    public List<Exam> getAllExams() {
        return this.examRepository.findAll();
    }
}
