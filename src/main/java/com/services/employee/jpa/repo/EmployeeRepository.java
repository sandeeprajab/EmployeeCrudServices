package com.services.employee.jpa.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.services.employee.jpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findById(String empName);

}
