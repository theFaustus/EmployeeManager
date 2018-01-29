package com.isd.ipa.EmployeeManager.controller;

import com.isd.ipa.EmployeeManager.domain.Employee;
import com.isd.ipa.EmployeeManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Faust on 1/29/2018.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list/", method = RequestMethod.GET)
    public HttpEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public HttpEntity<Employee> getEmployeeById(@PathVariable("id") String employeeId) {
        Employee byEmployeeId = employeeService.findByEmployeeId(employeeId);
        if (byEmployeeId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(byEmployeeId, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/employee/", method = RequestMethod.POST)
    public HttpEntity<?> saveEmployee(@RequestBody Employee e) {
        if (employeeService.employeeExists(e)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            Employee employee = employeeService.saveEmployee(e);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/employees/employee/{id}")
                    .buildAndExpand(employee.getEmployeeId()).toUri();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(location);
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public HttpEntity<?> updateEmployee(@PathVariable("id") String id, @RequestBody Employee e) {
        Employee byEmployeeId = employeeService.findByEmployeeId(id);
        if(byEmployeeId == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            byEmployeeId.setAge(e.getAge());
            byEmployeeId.setFirstName(e.getFirstName());
            byEmployeeId.setLastName(e.getLastName());
            employeeService.updateEmployee(byEmployeeId);
            return new ResponseEntity<>(employeeService, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String employeeId) {
        employeeService.deleteByEmployeeId(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/employee/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAll() {
        employeeService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
