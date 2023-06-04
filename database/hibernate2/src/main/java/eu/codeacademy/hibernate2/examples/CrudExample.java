package eu.codeacademy.hibernate2.examples;

import eu.codeacademy.hibernate2.helper.DaoManagerHelper;
import eu.codeacademy.hibernate2.pojo.EmployeePojo;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CrudExample {

    public static void main(String[] args) {
        try(Session ss = DaoManagerHelper.getSession()) {
            createNewEmployee(ss);
            updateEmployee(ss);
            deleteEmployee(ss);
        }
    }

    private static void deleteEmployee(Session ss) {
        Transaction transaction = null;
        try {
            EmployeePojo employee = ss.get(EmployeePojo.class, 1L);

            transaction = ss.beginTransaction();
            ss.remove(employee);
            transaction.commit();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    private static void updateEmployee(Session ss) {
        Transaction transaction = null;
        try {
            EmployeePojo employee = ss.get(EmployeePojo.class, 2L);
            employee.setEmail("ona@test.lt");

            transaction = ss.beginTransaction();
            ss.merge(employee);
            transaction.commit();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    private static void createNewEmployee(Session ss) {
        Transaction transaction = null;
        try {
            EmployeePojo employee = EmployeePojo.builder()
                    .name("Valdas")
                    .surname("Adamkus")
                    .email("va@lietuva.lt")
                    .phoneNumber("002")
                    .build();

            transaction = ss.beginTransaction();
            ss.persist(employee);
            transaction.commit();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
