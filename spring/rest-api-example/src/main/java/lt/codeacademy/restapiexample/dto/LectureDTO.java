package lt.codeacademy.restapiexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureDTO {

    private String title;
    private List<AttendantDTO> attendantList;

    @Getter
    @Setter
    @AllArgsConstructor
    protected static class AttendantDTO{
        private String name;
        private String lastname;
    }
}

