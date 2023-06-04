package eu.codeacademy.hibernate2.helper;

import eu.codeacademy.hibernate2.pojo.CityPojo;
import eu.codeacademy.hibernate2.pojo.EmployeePojo;
import eu.codeacademy.hibernate2.pojo.EmployeeTypePojo;
import eu.codeacademy.hibernate2.pojo.ReportOfEmployeeTypeAndCurrentCityPojo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class DaoManagerHelper {

    public static SessionFactory getSessionFactory() {
        Configuration cfg = HibernateConfigurationHelper.iniConfigurationPostgreSQL();
        cfg.addAnnotatedClass(EmployeePojo.class);
        cfg.addAnnotatedClass(EmployeeTypePojo.class);
        cfg.addAnnotatedClass(CityPojo.class);
        cfg.addAnnotatedClass(ReportOfEmployeeTypeAndCurrentCityPojo.class);

        return cfg.buildSessionFactory();
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }


}
