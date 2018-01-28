package com.isd.ipa.EmployeeManager;

import com.isd.ipa.EmployeeManager.domain.Department;
import com.isd.ipa.EmployeeManager.domain.Employee;
import com.isd.ipa.EmployeeManager.repository.DepartmentRepository;
import com.isd.ipa.EmployeeManager.repository.EmployeeRepository;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;


@SpringBootApplication
@ComponentScan(basePackages = "com.isd.ipa.EmployeeManager")
public class EmployeeManagerApplication {
	private static final Logger LOGGER = Logger.getLogger(EmployeeManagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);
	}


	@Bean
	public CommandLineRunner init(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		return (args) -> {
			employeeRepository.deleteAll();
			departmentRepository.deleteAll();
			Employee e = employeeRepository.save(new Employee("Ion", "Pascari", 23));
			departmentRepository.save(new Department("Service Department", "Service Rocks!", Arrays.asList(e)));

			for (Department d : departmentRepository.findAll()) {
				LOGGER.info("Department: " + d);
			}
		};
	}
}
