package com.isd.ipa.EmployeeManager.service;

import com.isd.ipa.EmployeeManager.domain.Employee;

import java.util.List;

/**
 * Created by Faust on 1/28/2018.
 */
public interface EmployeeService {
    Employee saveEmployee(Employee e);

    Employee findByEmployeeId(String employeeId);

    void deleteByEmployeeId(String employeeId);

    void updateEmployee(Employee e);

    boolean employeeExists(Employee e);

    List<Employee> findAll();

    void deleteAll();
}
