package eu.codeacademy.hibernate2.dao;

import eu.codeacademy.hibernate2.pojo.ReportOfEmployeeTypeAndCurrentCityPojo;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;

import java.util.List;


@RequiredArgsConstructor
public class ReportDao {

    private final Session session;

    public List<ReportOfEmployeeTypeAndCurrentCityPojo> getReportOfEmployeeTypeAndCurrentCity() {
        return session.createQuery("FROM ReportOfEmployeeTypeAndCurrentCityPojo", ReportOfEmployeeTypeAndCurrentCityPojo.class).list();
    }
}
