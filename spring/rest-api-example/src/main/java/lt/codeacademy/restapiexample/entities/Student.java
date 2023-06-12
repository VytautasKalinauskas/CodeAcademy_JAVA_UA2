package lt.codeacademy.restapiexample.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lt.codeacademy.restapiexample.dto.CreateStudentDTO;
import lt.codeacademy.restapiexample.utils.PersonalCodeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String lastname;
    private LocalDate birthDate;
    private String personalCode;
    private String vehicleNo;
    private String phoneNo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static Long idIncrementor = 0L;

    public Student(CreateStudentDTO studentDTO) {
        this.id = idIncrementor++;
        this.name = studentDTO.getName();
        this.lastname = studentDTO.getLastname();
        this.birthDate = PersonalCodeUtil.convertPersonalCodeToBirthDate(studentDTO.getPersonalCode());
        this.personalCode = studentDTO.getPersonalCode();
        this.vehicleNo = studentDTO.getVehicleNo();
        this.phoneNo = studentDTO.getPhoneNo();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Student(Student oldStudent, CreateStudentDTO newStudent) {
        this.id = oldStudent.id;
        this.name = newStudent.getName();
        this.lastname = newStudent.getLastname();
        if (personalCode != null) {
            this.birthDate = PersonalCodeUtil.convertPersonalCodeToBirthDate(newStudent.getPersonalCode());
        }
        this.personalCode = newStudent.getPersonalCode();
        this.vehicleNo = newStudent.getVehicleNo();
        this.phoneNo = newStudent.getPhoneNo();
        this.createdAt = oldStudent.getCreatedAt();
        this.updatedAt = LocalDateTime.now();
    }
}
