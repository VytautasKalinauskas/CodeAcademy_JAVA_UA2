package lt.codeacademy.springdataexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.springdataexample.enumerators.Role;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private String name;
    private String surname;
    private List<UserExamDto> userExams;
    private String password;
    private Role role;

}
