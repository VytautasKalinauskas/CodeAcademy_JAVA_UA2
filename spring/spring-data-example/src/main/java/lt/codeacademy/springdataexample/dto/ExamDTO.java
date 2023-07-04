package lt.codeacademy.springdataexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamDTO {

    private Long id;
    private Integer difficulty;
    private List<QuestionDTO> questions;
    private String title;

}
