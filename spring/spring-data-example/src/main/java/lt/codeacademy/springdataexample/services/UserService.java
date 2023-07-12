package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.springdataexample.converters.UserConverter;
import lt.codeacademy.springdataexample.dto.UserDto;
import lt.codeacademy.springdataexample.entities.UserEntity;
import lt.codeacademy.springdataexample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    public UserDto getUserById(Long id) {
        return UserConverter.convertUserToUserDto(userRepository.findById(id).orElseThrow(() -> new NoSuchElementException()));
    }

    public List<UserDto> getUsers(Pageable pageable) {
        if (pageable != null) {
            return UserConverter.convertUserPageToUserDtoList(userRepository.findAll(pageable));
        }
        return UserConverter.convertUserListToUserDtoList(userRepository.findAll());
    }

    public UserDto createUser(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        return UserConverter.convertUserToUserDto(userEntity);
    }

    public UserDto updateUser(UserEntity userEntity) {
        UserEntity userEntityToUpdate = userRepository.findById(userEntity.getId()).orElseThrow(() -> new NoSuchElementException());
        userEntityToUpdate.setUsername(userEntity.getUsername());
        userEntityToUpdate.setName(userEntity.getName());
        userEntityToUpdate.setSurname(userEntity.getSurname());
        userRepository.save(userEntityToUpdate);
        return UserConverter.convertUserToUserDto(userEntityToUpdate);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
