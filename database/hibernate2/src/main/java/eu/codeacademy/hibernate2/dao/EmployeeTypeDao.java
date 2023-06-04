package eu.codeacademy.hibernate2.dao;

import eu.codeacademy.hibernate2.pojo.EmployeeTypePojo;
import org.hibernate.Session;

public class EmployeeTypeDao extends GenericDao<EmployeeTypePojo> {

    public EmployeeTypeDao(Session session, Class<EmployeeTypePojo> entityClass) {
        super(session, entityClass);
    }
}
