package com.isd.ipa.EmployeeManager.repository;

import com.isd.ipa.EmployeeManager.domain.Department;
import com.isd.ipa.EmployeeManager.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Faust on 1/28/2018.
 */
public interface DepartmentRepository extends MongoRepository<Department,String>{
}
