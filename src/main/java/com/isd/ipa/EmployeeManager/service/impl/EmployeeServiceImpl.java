package com.isd.ipa.EmployeeManager.service.impl;

import com.isd.ipa.EmployeeManager.domain.Employee;
import com.isd.ipa.EmployeeManager.repository.EmployeeRepository;
import com.isd.ipa.EmployeeManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Faust on 1/28/2018.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Employee findByEmployeeId(String employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    @Override
    public void deleteByEmployeeId(String employeeId) {
        employeeRepository.delete(employeeId);
    }

    @Override
    public void updateEmployee(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public boolean employeeExists(Employee e) {
        return employeeRepository.exists(Example.of(e));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
