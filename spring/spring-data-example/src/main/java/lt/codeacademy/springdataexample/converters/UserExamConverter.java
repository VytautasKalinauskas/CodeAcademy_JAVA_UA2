package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.AnswerDTO;
import lt.codeacademy.springdataexample.dto.UserExamDto;
import lt.codeacademy.springdataexample.entities.Answer;
import lt.codeacademy.springdataexample.entities.UserExam;

import java.util.ArrayList;
import java.util.List;

public abstract class UserExamConverter {


    public static UserExamDto convertUserExamToUserExamDto(UserExam userExam) {
        UserExamDto userExamDto = null;
        if (userExam != null) {
            userExamDto = new UserExamDto();
            userExamDto.setId(userExam.getId());
            userExamDto.setScore(userExam.getScore());

            if(userExam.getExam() != null) {
                userExamDto.setExamId(userExam.getExam().getId());
            }

            if(userExam.getUser() != null) {
                userExamDto.setUserId(userExam.getUser().getId());
            }
        }
        return userExamDto;
    }

    public static List<UserExamDto> convertUserExamsListToDtoList(List<UserExam> userExams) {
        List<UserExamDto> userExamDtoList = null;
        if (userExams != null && !userExams.isEmpty()) {
            userExamDtoList = new ArrayList<>();
            for (UserExam ua : userExams) {
                userExamDtoList.add(convertUserExamToUserExamDto(ua));
            }
        }
        return userExamDtoList;
    }

}
