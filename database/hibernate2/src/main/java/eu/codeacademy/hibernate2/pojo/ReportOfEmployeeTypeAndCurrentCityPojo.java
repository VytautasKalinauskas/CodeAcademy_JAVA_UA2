package eu.codeacademy.hibernate2.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.ToString;
import org.hibernate.annotations.Subselect;

@Entity
@ToString
@Subselect("SELECT"
        + "    empl.id AS employee_id,"
        + "    empl.name || ' ' || empl.surname AS employee_full_name,"
        + "    empl.phone_number AS employee_phone_number,"
        + "    et.name AS employee_role,"
        + "    c.name AS current_city"
        + " FROM employee empl"
        + "    JOIN employee_type et on empl.employee_type_id = et.id"
        + "    JOIN city c on empl.current_city_id = c.id")
public class ReportOfEmployeeTypeAndCurrentCityPojo {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_full_name")
    private String employeeFullName;

    @Column(name = "employee_phone_number")
    private String employeePhoneNumber;

    @Column(name = "employee_role")
    private String employeeRole;

    @Column(name = "current_city")
    private String currentCity;
}
