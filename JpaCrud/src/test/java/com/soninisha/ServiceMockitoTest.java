package com.soninisha;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.soninisha.entity.Employee;
import com.soninisha.repository.EmployeeRepository;
import com.soninisha.service.EmployeeServiceImpl;

@SpringBootTest(classes = { ServiceMockitoTest.class })
public class ServiceMockitoTest {

	@Mock
	EmployeeRepository emprepo;

	@InjectMocks
	EmployeeServiceImpl empser;

	@Test
	@Order(1)
	public void test_getAllEmployees() {
		List<Employee> employee = new ArrayList<Employee>();
		employee.add(new Employee("Amit", "Soni", "amit@gmail.com"));

		when(emprepo.findAll()).thenReturn(employee); // Mocking : use to mock the external dependencies
		// asset
		assertEquals(1, empser.getAllEmployees().size());

	}
	@Test
	@Order(2)
	public void test_getEmployeeById() {
//		List<Employee> myemployee = new ArrayList<Employee>();
//		myemployee.add(new Employee("Amit1", "Soni", "amit@gmail.com"));
//		myemployee.add(new Employee("Amit2", "Soni", "amit@gmail.com"));
//		
//		Long employeeID =1L;
//		when(emprepo.findAll()).thenReturn(myemployee);
//		assertEquals(employeeID, empser.getEmployeeById(employeeID).getId());
//		
		  // Arrange
        long employeeId = 1L;
        Employee employee = new Employee(employeeId, "Amit");

        // Mock the behavior of findById
        when(emprepo.findById(employeeId)).thenReturn(Optional.of(employee));

        // Act
        Employee result = empser.getEmployeeById(employeeId);

        // Assert
        assertEquals(employee, result);
    

	}
	
	
}
