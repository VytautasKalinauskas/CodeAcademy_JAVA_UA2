package eu.codeacademy.javaua2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "Student_CA")
@Data
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "course")
    private Integer course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_contact_id")
    private StudentContact contact;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "university_id")
    private University university;



}
