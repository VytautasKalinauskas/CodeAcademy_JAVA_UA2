package eu.codeacademy.hibernate2.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
@ToString
public class CityPojo {

    @Id
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "cities")
    @ToString.Exclude
    private List<EmployeePojo> employees = new ArrayList<>();
}
