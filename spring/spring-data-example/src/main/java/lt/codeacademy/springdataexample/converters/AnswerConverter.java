package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.AnswerDTO;
import lt.codeacademy.springdataexample.dto.CreateUpdateAnswerDTO;
import lt.codeacademy.springdataexample.entities.Answer;
import lt.codeacademy.springdataexample.entities.Question;

import java.util.ArrayList;
import java.util.List;

public abstract class AnswerConverter {


    public static Answer convertAnswerDtoToAnswer(AnswerDTO answerDto) {
        Answer answer = null;
        if(answerDto != null) {
            answer = new Answer();
            answer.setId(answerDto.getId());
            answer.setText(answerDto.getText());

            if(answerDto.getQuestionId() != null) {
                Question question = new Question();
                question.setId(answerDto.getQuestionId());
                answer.setQuestion(question);
            }

            if(answerDto instanceof CreateUpdateAnswerDTO) {
                answer.setIsCorrect(((CreateUpdateAnswerDTO) answerDto).getIsCorrect());
            }
        }

        return answer;
    }

    public static AnswerDTO convertAnswerToAnswerDto(Answer answer) {
        AnswerDTO answerDto = null;
        if (answer != null) {
            answerDto = new AnswerDTO();
            answerDto.setId(answer.getId());
            answerDto.setText(answer.getText());

            if(answer.getQuestion() != null) {
                answerDto.setQuestionId(answer.getQuestion().getId());
            }
        }
        return answerDto;
    }

    public static List<AnswerDTO> convertAnswersToDto(Iterable<Answer> answersList) {
        List<AnswerDTO> answerDTOList = null;
        if (answersList != null) {
            answerDTOList = new ArrayList<>();
            for (Answer a : answersList) {
                answerDTOList.add(convertAnswerToAnswerDto(a));
            }
        }
        return answerDTOList;
    }
}
