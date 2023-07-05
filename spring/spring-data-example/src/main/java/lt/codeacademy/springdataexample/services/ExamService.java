package lt.codeacademy.springdataexample.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ExamService {

    @Value("${ca.test.value}")
    String caTestValue;

    private final ExamRepository examRepository;

    private final MessageSource messageSource;

    public ExamDTO addExam(Exam exam) {
        this.examRepository.saveAndFlush(exam);
        return ExamConverter.convertExamToExamDTO(exam);
    }

    public Exam getExamById(Long examId) {


        Optional<Exam> exam = examRepository.findById(examId);
        if(exam.isPresent()) {
            log.info("Exam name: " + exam.get().getTitle() + " Exam id: " + examId);
            return exam.get();
        }
        else{
            log.error(messageSource.getMessage("object.not.found", null, LocaleContextHolder.getLocale()));
            return null;
        }


     //   System.out.println(messageSource.getMessage("name.message", null, LocaleContextHolder.getLocale()));
     //   return this.examRepository.findById(examId).orElseThrow(() -> new NoSuchElementException(messageSource.getMessage("exam.not.found", null, LocaleContextHolder.getLocale())));
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
