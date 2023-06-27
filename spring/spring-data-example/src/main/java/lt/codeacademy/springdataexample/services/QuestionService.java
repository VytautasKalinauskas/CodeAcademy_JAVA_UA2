package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.QuestionConverter;
import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.Question;
import lt.codeacademy.springdataexample.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    private ExamService examService;

    public QuestionDTO addQuestionToExam(Question question) {
        Exam exam = examService.getExamById(question.getExam().getId());
        if(exam == null) {
            throw new NoSuchElementException("NOT FOUND");
        }
        this.questionRepository.saveAndFlush(question);
        return QuestionConverter.convertQuestionToDTO(question);
    }

    public QuestionDTO getQuestionById(Long id) {
        return QuestionConverter.convertQuestionToDTO(questionRepository.getReferenceById(id));
    }
}
