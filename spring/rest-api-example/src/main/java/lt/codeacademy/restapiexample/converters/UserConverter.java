package lt.codeacademy.restapiexample.converters;

import lt.codeacademy.restapiexample.dto.UserDto;
import lt.codeacademy.restapiexample.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserConverter {

    public static long userId = 1;

    public User fromDto(UserDto userDto) {

        User user = new User();
        user.setId(userId++);
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }

    public UserDto toDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;

    }

}
