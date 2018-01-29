package com.isd.ipa.EmployeeManager.service.impl;

import com.isd.ipa.EmployeeManager.domain.Department;
import com.isd.ipa.EmployeeManager.repository.DepartmentRepository;
import com.isd.ipa.EmployeeManager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Faust on 1/28/2018.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department d) {
        return departmentRepository.save(d);
    }

    @Override
    public Department findByDepartmentId(String departmentId) {
        return departmentRepository.findOne(departmentId);
    }

    @Override
    public void deleteByDepartmentId(String departmentId) {
        departmentRepository.delete(departmentId);
    }

    @Override
    public void updateDepartment(Department d) {
        departmentRepository.save(d);
    }

    @Override
    public boolean departmentExists(Department d) {
        return departmentRepository.exists(Example.of(d));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteAll() {
        departmentRepository.deleteAll();
    }
}
