package lt.codeacademy.restapiexample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;

    private String lastname;

    private Integer age;
}
