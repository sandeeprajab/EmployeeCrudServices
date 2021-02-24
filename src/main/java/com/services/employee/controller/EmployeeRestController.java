package com.services.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.services.employee.jpa.entity.Employee;
import com.services.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/")
@CrossOrigin(origins="*")
@Slf4j
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> empList = employeeService.getEmployees();
		if(empList.size() > 0) {
			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(empList, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
		return new ResponseEntity<>(employeeService.searchEmployee(Integer.parseInt(id)), HttpStatus.OK);
	}

	@PostMapping("/employee/save")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		try {
			employeeService.saveEmployeeDetails(employee);	
		}
		catch(Exception ex) {
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
		
	}
	
	@PutMapping("/employee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		try {
			employeeService.updateEmployee(employee);	
		}
		catch(Exception ex) {
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/employee/{id}")
	public ResponseEntity<String> addEmployee( @PathVariable String id) {		
		try {
			employeeService.delete(Long.parseLong(id));
		}
		catch(Exception ex) {
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	
}
