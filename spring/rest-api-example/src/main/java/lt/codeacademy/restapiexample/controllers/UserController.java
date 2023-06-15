package lt.codeacademy.restapiexample.controllers;

import lt.codeacademy.restapiexample.dto.UserDto;
import lt.codeacademy.restapiexample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserDtoById(id);

        if(userDto != null) {
            return ResponseEntity.ok(userDto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("User with id %d was not found", id));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserDto userDtoUpdated = userService.updateUserById(id, userDto);

        if(userDtoUpdated != null) {
            return ResponseEntity.ok(userDtoUpdated);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("User with id %d was not found", id));
        }
    }

}
