package eu.codeacademy.javaua2.service;

import eu.codeacademy.javaua2.model.Student;
import eu.codeacademy.javaua2.model.University;
import eu.codeacademy.javaua2.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentService {

    public void createStudent(Student student) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);

        transaction.commit();
    }

    public Student findStudentById(Long id) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.find(Student.class, id);

        transaction.commit();
        System.out.println(student.toString());
        return student;
    }

    public Student updateStudentById(Long id, Student newStudent) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.find(Student.class, id);

        student.setName(newStudent.getName());
        student.setCourse(newStudent.getCourse());
        student.setSurname(newStudent.getSurname());

        session.persist(student);
        transaction.commit();

        return student;
    }

    public List<Student> findStudentsByCourse(Integer course) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cr = cb.createQuery(Student.class);
        Root<Student> root = cr.from(Student.class);
        cr.select(root).where(cb.equal(root.get("course"), course));
        Query<Student> query = session.createQuery(cr);
        List<Student> results = query.getResultList();


        results
                .stream()
                .forEach(Student::toString);

        System.out.println(results.toString());

        return results;

    }

    public List<Student> findStudentsByNameLike(String name) {

        String stringQuery = "%" + name + "%";
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cr = cb.createQuery(Student.class);
        Root<Student> root = cr.from(Student.class);
        cr.select(root).where(cb.like(root.get("name"), stringQuery));
        Query<Student> query = session.createQuery(cr);
        List<Student> results = query.getResultList();

        System.out.println(results.toString());

        return results;

    }

    public List<Student> findStudentsByCourseAndName(String name, Integer course) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cr = cb.createQuery(Student.class);
        Root<Student> root = cr.from(Student.class);
        cr.select(root).where(cb.or(cb.equal(root.get("name"), name),
                cb.equal(root.get("course"), course)));

        Query<Student> query = session.createQuery(cr);
        List<Student> results = query.getResultList();

        System.out.println(results.toString());

        return results;

    }


}
