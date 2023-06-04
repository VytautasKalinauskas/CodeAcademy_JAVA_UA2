package eu.codeacademy.hibernate2.dao;

import eu.codeacademy.hibernate2.pojo.EmployeePojo;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDao extends GenericDao<EmployeePojo> {

    public EmployeeDao(Session session, Class<EmployeePojo> entityClass) {
        super(session, entityClass);
    }

    public List<EmployeePojo> getEmployees() {
        return getSession()
                .createQuery("FROM EmployeePojo ep " +
                        "join fetch ep.employeeTypePojo", EmployeePojo.class)
                .list();
    }
}
