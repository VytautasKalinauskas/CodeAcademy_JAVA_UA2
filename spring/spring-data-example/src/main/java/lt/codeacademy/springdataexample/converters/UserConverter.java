package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.UserDto;
import lt.codeacademy.springdataexample.entities.UserEntity;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public abstract class UserConverter {


    public static UserEntity convertUserDtoToUser(UserDto userDto) {
        UserEntity userEntity = null;
        if (userDto != null) {
            userEntity = new UserEntity();
            userEntity.setId(userDto.getId());
            userEntity.setName(userDto.getName());
            userEntity.setSurname(userDto.getSurname());
            userEntity.setUsername(userDto.getUsername());
            userEntity.setPassword(userDto.getPassword());
            userEntity.setRole(userDto.getRole());
        }
        return userEntity;
    }

    public static UserDto convertUserToUserDto(UserEntity userEntity) {
        UserDto userDto = null;
        if (userEntity != null) {
            userDto = new UserDto();
            userDto.setId(userEntity.getId());
            userDto.setName(userEntity.getName());
            userDto.setUsername(userEntity.getUsername());
            userDto.setSurname(userEntity.getSurname());
            userDto.setRole(userEntity.getRole());
            userDto.setPassword(userEntity.getPassword());
            userDto.setUserExams(UserExamConverter.convertUserExamsListToDtoList(userEntity.getUserExams()));
        }

        return userDto;
    }

    public static List<UserDto> convertUserListToUserDtoList(List<UserEntity> usersList) {
        List<UserDto> userDtoList = null;
        if (usersList != null && !usersList.isEmpty()) {
            userDtoList = new ArrayList<>();
            for (UserEntity u : usersList) {
                userDtoList.add(convertUserToUserDto(u));
            }
        }
        return userDtoList;
    }

    public static List<UserDto> convertUserPageToUserDtoList(Page<UserEntity> userPage) {
        List<UserDto> userDtoList = null;
        if (userPage != null && !userPage.isEmpty()) {
            userDtoList = new ArrayList<>();
            for (UserEntity u : userPage) {
                userDtoList.add(convertUserToUserDto(u));
            }
        }
        return userDtoList;
    }

}
