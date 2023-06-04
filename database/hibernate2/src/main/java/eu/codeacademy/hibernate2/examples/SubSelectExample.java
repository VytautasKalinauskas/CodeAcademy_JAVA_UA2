package eu.codeacademy.hibernate2.examples;

import eu.codeacademy.hibernate2.dao.ReportDao;
import eu.codeacademy.hibernate2.helper.DaoManagerHelper;
import eu.codeacademy.hibernate2.service.ReportService;
import org.hibernate.Session;

import java.awt.*;

public class SubSelectExample {

    public static void main(String[] args) {
        try(Session ss = DaoManagerHelper.getSession()) {
            ReportService reportService = new ReportService(new ReportDao(ss));
            reportService.getReportOfEmployeeTypeAndCurrentCity().stream()
                    .forEach(System.out::println);
        }
    }
}
