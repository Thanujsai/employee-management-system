package com.ems.dao;

import java.sql.SQLException;
import java.util.List;


import com.ems.model.Employee;

public interface EmployeeDAO {
	
	public boolean addEmployee(Employee product) throws SQLException,ClassNotFoundException;
	public List<Employee> listAllEmployees() throws SQLException,ClassNotFoundException;
	public boolean deleteEmployee(int empId) throws SQLException,ClassNotFoundException;
	public boolean updateEmployee(Employee employee) throws SQLException,ClassNotFoundException;


}
