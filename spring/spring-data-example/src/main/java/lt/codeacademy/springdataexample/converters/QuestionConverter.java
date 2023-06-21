package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.entities.Question;

import java.util.ArrayList;
import java.util.List;

public abstract class QuestionConverter {

    public static Question convertQuestionDtoToQuestion(QuestionDTO questionDTO) {
        Question question = null;
        if(questionDTO != null) {
            question = new Question();
            question.setId(questionDTO.getId());
            question.setText(questionDTO.getText());
        }

        return question;
    }

    public static QuestionDTO convertQuestionToDTO(Question question) {
        QuestionDTO questionDTO = null;
        if (question != null) {
            questionDTO = new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setText(question.getText());

            if(question.getExam() != null) {
                questionDTO.setExamId(question.getExam().getId());
            }
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
