package lt.codeacademy.springdataexample.controllers;

import lt.codeacademy.springdataexample.converters.UserConverter;
import lt.codeacademy.springdataexample.dto.UserDto;
import lt.codeacademy.springdataexample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@PreAuthorize("hasRole('TEACHER')")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(UserConverter.convertUserDtoToUser(userDto)));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateUser(UserConverter.convertUserDtoToUser(userDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(userService.getUsers(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }


}
