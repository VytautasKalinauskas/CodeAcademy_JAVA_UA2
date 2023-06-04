package eu.codeacademy.javaua2;

import eu.codeacademy.javaua2.model.Rector;
import eu.codeacademy.javaua2.model.Student;
import eu.codeacademy.javaua2.model.StudentContact;
import eu.codeacademy.javaua2.model.University;
import eu.codeacademy.javaua2.service.StudentService;
import eu.codeacademy.javaua2.service.UniversityService;
import eu.codeacademy.javaua2.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        UniversityService universityService = new UniversityService();


        /*   Create student with contact information   */
        StudentContact contact = new StudentContact();
        contact.setAddress("Ozo 25, Vilnius");
        contact.setEmail("Laurynas.valys@gmail.com");
        contact.setPhoneNumber("+3706569947");

        Student newStudent = new Student();
        newStudent.setName("Laurynas");
        newStudent.setSurname("Valys");
        newStudent.setCourse(1);
        newStudent.setContact(contact);

//        studentService.createStudent(newStudent);

        studentService.findStudentsByCourse(1);

        /* create student with university

        Student ktuStudent = new Student();
        ktuStudent.setName("Tomas");
        ktuStudent.setSurname("Bartus");
        ktuStudent.setCourse(4);
        ktuStudent.setContact(contact);

        University university = universityService.findUniversityName("KTU");
        ktuStudent.setUniversity(university);

        studentService.createStudent(ktuStudent);

         */



        Student student = studentService.findStudentById(64L);

        University university = universityService.findUniversityName("KTU");





//        universityService.printRectorByUniversityName("KTU");
//        universityService.updateUniversity(17L, null);




    }
}