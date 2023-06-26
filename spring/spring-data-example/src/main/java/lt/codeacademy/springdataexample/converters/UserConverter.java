package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.UserDto;
import lt.codeacademy.springdataexample.entities.User;

import java.util.ArrayList;
import java.util.List;

public abstract class UserConverter {


    public static User convertUserDtoToUser(UserDto userDto) {
        User user = null;
        if (userDto != null) {
            user = new User();
            user.setId(userDto.getId());
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setUsername(userDto.getUsername());
        }
        return user;
    }

    public static UserDto convertUserToUserDto(User user) {
        UserDto userDto = null;
        if (user != null) {
            userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setUsername(user.getUsername());
            userDto.setSurname(user.getSurname());
            userDto.setUserExams(UserExamConverter.convertUserExamsListToDtoList(user.getUserExams()));
        }

        return userDto;
    }

    public static List<UserDto> convertUserListToUserDtoList(List<User> usersList) {
        List<UserDto> userDtoList = null;
        if (usersList != null && !usersList.isEmpty()) {
            userDtoList = new ArrayList<>();
            for (User u : usersList) {
                userDtoList.add(convertUserToUserDto(u));
            }
        }
        return userDtoList;
    }

}
