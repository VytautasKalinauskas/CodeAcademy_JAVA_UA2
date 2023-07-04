package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.entities.Exam;

import java.util.ArrayList;
import java.util.List;

public abstract class ExamConverter {

    public static Exam convertExamDtoToExam(ExamDTO examDTO) {
        Exam exam = null;
        if (examDTO != null) {
            exam = new Exam();
            exam.setId(examDTO.getId());
            exam.setDifficulty(examDTO.getDifficulty());
            exam.setTitle(examDTO.getTitle());
        }
        return exam;
    }

    public static ExamDTO convertExamToExamDTO(Exam exam) {
        ExamDTO examDTO = null;
        if (exam != null) {
            examDTO = new ExamDTO();
            examDTO.setId(exam.getId());
            examDTO.setDifficulty(exam.getDifficulty());
            examDTO.setQuestions(QuestionConverter.convertQuestionsToDTO(exam.getQuestions()));
            examDTO.setTitle(exam.getTitle());
        }
        return examDTO;
    }

    public static List<ExamDTO> convertExamsToExamDTO(Iterable<Exam> examList) {
        List<ExamDTO> examDTOList = null;
        if (examList != null) {
            examDTOList = new ArrayList<>();
            for (Exam e : examList) {
                examDTOList.add(ExamConverter.convertExamToExamDTO(e));
            }
        }
        return examDTOList;
    }

}
