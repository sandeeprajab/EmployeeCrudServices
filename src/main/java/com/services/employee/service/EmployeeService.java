package com.services.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.services.employee.jpa.entity.Employee;
import com.services.employee.jpa.repo.EmployeeRepository;
import com.services.employee.exception.*;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public void saveEmployeeDetails(Employee employeeDetails) {
		empRepo.save(employeeDetails);
    }
	
	public void updateEmployee(Employee employeeDetails) {
		empRepo.save(employeeDetails);			
	}
		
	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}
	
	public Employee searchEmployee(long id) {
        return empRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }
	
	public void delete(long l) {
		empRepo.deleteById(l);
    }
	
}
