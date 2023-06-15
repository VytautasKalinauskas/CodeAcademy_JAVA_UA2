package lt.codeacademy.restapiexample.services;

import lt.codeacademy.restapiexample.converters.UserConverter;
import lt.codeacademy.restapiexample.dto.UserDto;
import lt.codeacademy.restapiexample.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserConverter userConverter;
    private List<User> userList = new ArrayList<>();

    public UserDto createUser(UserDto userDto) {

        User user = userConverter.fromDto(userDto);
        user.setCreatedAt(LocalDateTime.now());
        userList.add(user);
        return userConverter.toDto(user);

    }

    public UserDto getUserDtoById(Long id) {

        User user = getUserById(id);

        if(user != null) {
            return userConverter.toDto(user);
        }
        return null;
    }

    public User getUserById(Long id) {

        Optional<User> user = userList
                .stream()
                .filter(userExisting -> userExisting.getId().equals(id))
                .findFirst();

        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public UserDto updateUserById(Long id, UserDto userDto) {

        User userToUpdate = getUserById(id);
        if(userToUpdate == null) {
            return null;
        }

        userToUpdate.setUsername(userDto.getUsername());
        userToUpdate.setFirstName(userDto.getFirstName());
        userToUpdate.setLastName(userDto.getLastName());
        userToUpdate.setUpdatedAt(LocalDateTime.now());


        return userConverter.toDto(userToUpdate);

    }


}
