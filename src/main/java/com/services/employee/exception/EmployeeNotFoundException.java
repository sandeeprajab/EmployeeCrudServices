package com.services.employee.exception;

public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(long id) {
		super(String.format("Employee detaild not found for %s", id));
	}
}