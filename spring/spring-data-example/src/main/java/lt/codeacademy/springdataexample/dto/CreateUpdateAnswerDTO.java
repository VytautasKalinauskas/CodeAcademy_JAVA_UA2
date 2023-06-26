package lt.codeacademy.springdataexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateAnswerDTO extends AnswerDTO {

    private Boolean isCorrect;

}
