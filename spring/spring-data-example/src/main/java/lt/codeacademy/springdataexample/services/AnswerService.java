package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AnswerService {

    private AnswerRepository answerRepository;

}
