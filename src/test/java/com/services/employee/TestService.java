package com.services.employee;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.WebApplicationContext;
import com.services.employee.jpa.entity.Employee;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestService  extends EmployeeApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;
	final String rootUrl = "http://localhost:8080/v1/";

	Employee employeeObj;
	@Test
	void contextLoads() {
	}

	@Before
	public void init() {
		employeeObj = new Employee(2, "Hoston", "lindey", "hl@gmail.com", "90908989899");
		
	}

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		System.out.println("URL:"+ rootUrl);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(rootUrl + "/employee", HttpMethod.GET, entity,
				String.class);
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetEmployeeById() {
		Employee employee = restTemplate.getForObject(rootUrl + "/employee/1", Employee.class);
		assertNotNull(employee);
		assertEquals(employeeObj.getAirst_name(), employee.getAirst_name());

	}

	@Test
	public void testCreateEmployee() {
		ResponseEntity<Employee> postResponse = restTemplate.postForEntity(rootUrl + "/employee/save", employeeObj, Employee.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateEmployee() {
		String id = "1";
		Employee employee = restTemplate.getForObject(rootUrl + "/employee/" + id, Employee.class);
		restTemplate.put(rootUrl + "/employee/" + id, employee);
		Employee updatedEmployee = restTemplate.getForObject(rootUrl + "/employee/" + id, Employee.class);
		assertNotNull(updatedEmployee);
	}

	@Test
	public void testDeleteEmployee() {
		String id = "1";
		Employee employee = restTemplate.getForObject(rootUrl + "/employee/" + id, Employee.class);
		assertNotNull(employee);
		restTemplate.delete(rootUrl + "/employee/" + id);
		try {
			employee = restTemplate.getForObject(rootUrl + "/employee/" + id, Employee.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
