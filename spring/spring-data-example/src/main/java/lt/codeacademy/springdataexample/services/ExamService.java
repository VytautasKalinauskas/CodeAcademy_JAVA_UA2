package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExamService {

    private ExamRepository examRepository;

    public ExamDTO addExam(Exam exam) {
        this.examRepository.saveAndFlush(exam);
        return ExamConverter.convertExamToExamDTO(exam);
    }

    public Exam getExamById(Long examId) {
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

    public Page<Exam> getAllExams(Integer difficulty, Pageable pageable) {
        if (difficulty != null) {
            return this.examRepository.findAllByDifficulty(difficulty, pageable);
        }
        return this.examRepository.findAll(pageable);
    }
}
