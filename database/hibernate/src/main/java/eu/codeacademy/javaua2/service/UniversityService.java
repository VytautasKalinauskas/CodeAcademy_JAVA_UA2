package eu.codeacademy.javaua2.service;

import eu.codeacademy.javaua2.model.Rector;
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

public class UniversityService {

    public void createUniversity(University university) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(university);
        transaction.commit();

    }

    public University findUniversityById(Long id) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        University university = session.find(University.class, id);
        transaction.commit();

        System.out.println(university.toString());
        return university;

    }

    public University updateUniversity(Long id, Long rectorId) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        University university = session.find(University.class, id);


        Rector rector = new Rector();
        rector.setName("new");
        rector.setSurname("new");
        session.persist(rector);
        university.setRector(rector);

        session.persist(university);
        transaction.commit();


        return university;

    }

    public List<University> findUniversitiesByEstablishmentYearGreater(Integer year) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<University> cr = cb.createQuery(University.class);
        Root<University> root = cr.from(University.class);
        cr.select(root).where(cb.gt(root.get("establishmentYear"), year));
        Query<University> query = session.createQuery(cr);
        List<University> results = query.getResultList();

        System.out.println(results.toString());

        return results;

    }


    public University findUniversityName(String name) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<University> cr = cb.createQuery(University.class);
        Root<University> root = cr.from(University.class);
        cr.select(root).where(cb.equal(root.get("name"), name));
        Query<University> query = session.createQuery(cr);
        University university = query.getSingleResult();

        return university;
    }

    public void printRectorByUniversityName(String name) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<University> cr = cb.createQuery(University.class);
        Root<University> root = cr.from(University.class);
        cr.select(root).where(cb.equal(root.get("name"), name));
        Query<University> query = session.createQuery(cr);
        University university = query.getSingleResult();

        System.out.println("Universitetas: " + university.getName());
        System.out.println("Rector: Name: " + university.getRector().getName()
                + " Surname: " + university.getRector().getSurname()
        + " Age: " + university.getRector().getAge());

    }

    public List<University> findUniversitiesByEstablishmentYearGreater(Integer yearFrom, Integer yearTo) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<University> cr = cb.createQuery(University.class);
        Root<University> root = cr.from(University.class);
        cr.select(root).where(cb.between(root.get("establishmentYear"), yearFrom, yearTo));
        Query<University> query = session.createQuery(cr);
        List<University> results = query.getResultList();

        System.out.println(results.toString());

        return results;


    }


}
