package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.AnswerConverter;
import lt.codeacademy.springdataexample.dto.AnswerDTO;
import lt.codeacademy.springdataexample.entities.Answer;
import lt.codeacademy.springdataexample.repositories.AnswerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerDTO addAnswer(Answer answer) {
        answerRepository.save(answer);
        return AnswerConverter.convertAnswerToAnswerDto(answer);
    }

    public AnswerDTO getAnswerById(Long id) {
        return AnswerConverter.convertAnswerToAnswerDto(answerRepository.getReferenceById(id));
    }

    public List<AnswerDTO> getAllAnswers(Boolean isCorrect, Pageable pageable) {
        Page<Answer> answers;
        if (isCorrect != null) {
            answers = answerRepository.findAllByIsCorrect(isCorrect, pageable);
        } else {
            answers = answerRepository.findAll(pageable);
        }

        return AnswerConverter.convertAnswersToDto(answers);
    }

    public List<Answer> getAllAnswersByIds(List<Long> ids) {
        return answerRepository.findAllById(ids);
    }

    public void deleteAnswerById(Long id) {
        answerRepository.deleteById(id);
    }

    public AnswerDTO updateAnswer(Answer answer) {
        answerRepository.save(answer);
        return AnswerConverter.convertAnswerToAnswerDto(answer);
    }


}
