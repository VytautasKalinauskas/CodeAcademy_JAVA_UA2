package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.entities.Question;

import java.util.ArrayList;
import java.util.List;

public abstract class QuestionConverter {

    public static QuestionDTO convertQuestionToDTO(Question question) {
        QuestionDTO questionDTO = null;
        if (question != null) {
            questionDTO = new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setText(question.getText());
        }
        return questionDTO;
    }

    public static List<QuestionDTO> convertQuestionsToDTO(List<Question> questionList) {
        List<QuestionDTO> questionDTOList = null;
        if (questionList != null && !questionList.isEmpty()) {
            questionDTOList = new ArrayList<>();
            for (Question q : questionList) {
                questionDTOList.add(QuestionConverter.convertQuestionToDTO(q));
            }
        }
        return questionDTOList;
    }
}
