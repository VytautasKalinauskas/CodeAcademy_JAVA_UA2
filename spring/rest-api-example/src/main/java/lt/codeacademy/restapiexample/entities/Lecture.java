package lt.codeacademy.restapiexample.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Lecture {
    private String title;
    private List<Student> attendants;
}
