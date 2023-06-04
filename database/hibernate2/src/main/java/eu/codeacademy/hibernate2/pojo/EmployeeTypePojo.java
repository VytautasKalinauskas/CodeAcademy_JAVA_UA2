package eu.codeacademy.hibernate2.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "employee_type")
@ToString
public class EmployeeTypePojo {

    @Id
    private Short id;

    @Column(length = 15, nullable = false, unique = true)
    private String name;
}
