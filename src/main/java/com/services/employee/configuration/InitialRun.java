package com.services.employee.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.services.employee.jpa.entity.Employee;
import com.services.employee.jpa.repo.EmployeeRepository;

@Configuration
public class InitialRun {

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {

		return args -> {
			repository.save(new Employee(2, "Hoston", "lindey", "hl@gmail.com", "90908989899"));
		};
	}
}
