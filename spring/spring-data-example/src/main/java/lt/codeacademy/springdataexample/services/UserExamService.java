package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.dto.HoldExamDto;
import lt.codeacademy.springdataexample.entities.Answer;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.UserEntity;
import lt.codeacademy.springdataexample.entities.UserExam;
import lt.codeacademy.springdataexample.repositories.UserExamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserExamService {

    private UserExamRepository userExamRepository;

    private AnswerService answerService;

    public HoldExamDto holdExam(HoldExamDto holdExamDto) {

        List<Long> correctAnswerIds = answerService.getAllAnswersByIds(holdExamDto.getAnswerIds())
                .stream()
                .filter(answer -> answer.getIsCorrect())
                .map(answer -> answer.getId())
                .collect(Collectors.toList());

        UserExam userExam = new UserExam();
        userExam.setScore(Double.valueOf(correctAnswerIds.size()));
        userExam.setUserEntity(new UserEntity(holdExamDto.getUserId()));
        userExam.setExam(new Exam(holdExamDto.getExamId()));
        List<Answer> answerList = new ArrayList<>();
        holdExamDto.getAnswerIds().forEach(answerId -> {
            answerList.add(new Answer(answerId));
        });
        userExam.setAnswers(answerList);
        userExamRepository.save(userExam);
        holdExamDto.setScore(userExam.getScore());
        holdExamDto.setCorrectAnswerIds(correctAnswerIds);

        return holdExamDto;

    }

}
