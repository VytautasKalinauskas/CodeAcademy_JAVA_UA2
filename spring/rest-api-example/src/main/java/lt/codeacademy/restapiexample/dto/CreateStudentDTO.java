package lt.codeacademy.restapiexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lt.codeacademy.restapiexample.annotations.PersonalCode;

@Getter
@Setter
@AllArgsConstructor
public class CreateStudentDTO {
    private String name;
    private String lastname;
    @PersonalCode
    private String personalCode;
    private String vehicleNo;
    private String phoneNo;
}
