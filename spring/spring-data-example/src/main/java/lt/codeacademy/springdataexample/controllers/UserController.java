package lt.codeacademy.springdataexample.controllers;

import lt.codeacademy.springdataexample.converters.UserConverter;
import lt.codeacademy.springdataexample.dto.UserDto;
import lt.codeacademy.springdataexample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Integer DEFAULT_PAGE_SIZE = 5;

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
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
        Pageable pageable = null;
        if (pageNumber != null) {
            if (pageSize == null) {
                pageSize = DEFAULT_PAGE_SIZE;

                // 20:00
                //-------------------------------------------
                // 1,2,3,4,10,11,12,13,23,123,1123543,534,123,65
                // users pageNumber = 2, pageSize = 3
                // 12,13,23
                //-------------------------------------------
                // 20:05
                // 123,1,2,3,4,10,11,12,13,23,123,1123543,534,123,65
                // users pageNumber = 2, pageSize = 3
                // 11,12,13


            }
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        return ResponseEntity.ok(userService.getUsers(pageable));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }


}
