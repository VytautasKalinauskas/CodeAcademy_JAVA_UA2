package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lt.codeacademy.springdataexample.converters.UserConverter;
import lt.codeacademy.springdataexample.dto.UserDto;
import lt.codeacademy.springdataexample.entities.User;
import lt.codeacademy.springdataexample.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserDto getUserById(Long id) {
        return UserConverter.convertUserToUserDto(userRepository.getReferenceById(id));
    }

    public List<UserDto> getUsers() {
        return UserConverter.convertUserListToUserDtoList(userRepository.findAll());
    }

    public UserDto createUser(User user) {
        userRepository.save(user);
        return UserConverter.convertUserToUserDto(user);
    }

    public UserDto updateUser(User user) {
        userRepository.save(user);
        return UserConverter.convertUserToUserDto(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
