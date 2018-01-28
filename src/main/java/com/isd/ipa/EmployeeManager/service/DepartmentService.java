package com.isd.ipa.EmployeeManager.service;

import com.isd.ipa.EmployeeManager.domain.Department;

import java.util.List;

/**
 * Created by Faust on 1/28/2018.
 */
public interface DepartmentService {
    Department saveDepartment(Department d);

    Department findByDepartmentId(String departmentId);

    void deleteByDepartmentId(String departmentId);

    void updateDepartment(Department d);

    boolean departmentExists(Department d);

    List<Department> findAll();

    void deleteAll();
}
