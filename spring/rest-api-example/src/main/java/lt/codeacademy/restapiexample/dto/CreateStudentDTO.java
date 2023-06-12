package lt.codeacademy.restapiexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateStudentDTO {
    private String name;
    private String lastname;
    private String personalCode;
    private String vehicleNo;
    private String phoneNo;
}
