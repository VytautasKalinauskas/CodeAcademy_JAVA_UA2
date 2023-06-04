package eu.codeacademy.hibernate2.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class EmployeePojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY because postgresql
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String surname;

    @Column(length = 30)
    private String email;

    @Column(name="phone_number", length = 8)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)  // by default EAGER
    @JoinColumn(name = "employee_type_id")
    private EmployeeTypePojo employeeTypePojo;

    @ManyToMany(fetch = FetchType.LAZY)  // by default LAZY
    @JoinColumn(name = "employee_cities")
    private List<CityPojo> cities = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_city_id")
    private CityPojo currentCity;
}
