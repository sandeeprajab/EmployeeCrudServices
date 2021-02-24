package com.services.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandling {
	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(EmployeeNotFoundException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String globleExcpetionHandler(Exception ex, WebRequest request) {
		return ex.getMessage();
	}

}
