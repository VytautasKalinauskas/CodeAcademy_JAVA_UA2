package lt.codeacademy.springdataexample.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatisticsDTO {
    private String examName;
    private Double averageScore;
    private Integer submissionCount;
}
