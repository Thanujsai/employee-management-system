package com.ems.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.exception.EmployeeListEmptyException;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;



public class EmployeeDAOImplTest {
	
	EmployeeDAO empdao = new EmployeeDAOImpl();
	@Test
	public void validateAddEmployeeDAOTest() throws ClassNotFoundException, SQLException {
		LocalDate date = LocalDate.of(20,12,22);
		Employee employee = new Employee(112,"Thanuj",date,7,null,60000);
		assertTrue(empdao.addEmployee(employee));
		
	}
	@Test
	public void validateDeleteEmployeeDAOTest() throws ClassNotFoundException, SQLException {
		assertTrue(empdao.deleteEmployee(103));
	}
	@Test
	public void validateUpdateEmployeeDAOTest() throws ClassNotFoundException, SQLException  {
		LocalDate date = LocalDate.of(20,12,22);
		Employee employee = new Employee(102,"Thanuj",date,7,null,60000);
		assertTrue(empdao.updateEmployee(employee));
		
	}
	
	@Test
	public void validatelistAllEmployeeDAOTest() throws ClassNotFoundException, SQLException {
		//EmployeeListEmptyException i = assertThrows(EmployeeListEmptyException.class,()->empservice.listAllEmployees());
		//assertNotEquals(i.getMessage(),"List is Empty");
		assertNotEquals(empdao.listAllEmployees().size(),0);
	}
	
}
