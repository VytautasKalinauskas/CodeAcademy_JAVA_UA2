package eu.codeacademy.hibernate2.service;

import eu.codeacademy.hibernate2.dao.EmployeeDao;
import eu.codeacademy.hibernate2.pojo.EmployeePojo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public List<EmployeePojo> getAll() {
        return employeeDao.getAll();
    }

    public List<EmployeePojo> getEmployees() {
        return employeeDao.getEmployees();
    }
}
