package eu.codeacademy.hibernate2.service;

import eu.codeacademy.hibernate2.dao.EmployeeDao;
import eu.codeacademy.hibernate2.dao.ReportDao;
import eu.codeacademy.hibernate2.pojo.ReportOfEmployeeTypeAndCurrentCityPojo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReportService {

    private final ReportDao reportDao;

    public List<ReportOfEmployeeTypeAndCurrentCityPojo> getReportOfEmployeeTypeAndCurrentCity() {
        return reportDao.getReportOfEmployeeTypeAndCurrentCity();
    }
}
