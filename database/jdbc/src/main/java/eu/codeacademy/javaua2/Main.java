package eu.codeacademy.javaua2;

import eu.codeacademy.javaua2.model.Student;
import eu.codeacademy.javaua2.service.StudentService;
import eu.codeacademy.javaua2.service.TeamService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    private static SessionFactory factory;
    public static void main(String[] args) {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }


        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("src/main/resources/hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory createdFactory = meta.getSessionFactoryBuilder().build();
        Session session = createdFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student naujas = new Student();
        naujas.setName("Vardas");
        naujas.setSurname("Pavarde");
        session.persist(naujas);

        transaction.commit();

        StudentService studentService = new StudentService();
        TeamService teamService = new TeamService();


//        studentService.findAllStudents();
//        teamService.findAllTeams();
//        teamService.findAllTeamsByName("Zalg");
//        studentService.findAllStudentsByCourse(3);
//        teamService.findAllTeamsByName("Zalgiris");
//        studentService.createStudent(20, "Naujas", "Studentas", 2, 8.64);
        studentService.updateStudentCourse(2, 3);

    }
}