package eu.codeacademy.javaua2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "university")
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "establishment_year")
    private Integer establishmentYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rector_id")
    private Rector rector;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "university")
    @ToString.Exclude
    private List<Student> students;


}
