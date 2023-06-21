package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.Question;
import lt.codeacademy.springdataexample.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class QuestionService {

    private ExamService examService;
    private QuestionRepository questionRepository;

    public void addQuestionToExam(Long examId, Question question) {
        Exam examById = this.examService.getExamById(examId);
        question.setExam(examById);
        this.questionRepository.saveAndFlush(question);
    }
}
