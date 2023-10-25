package com.ems.service;

import java.sql.SQLException;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee employee) throws SQLException,ClassNotFoundException;
	public List<Employee> listAllEmployees() throws SQLException,ClassNotFoundException;
	public boolean deleteEmployee(int employeeid) throws SQLException,ClassNotFoundException;
	public boolean updateEmployee(Employee employee) throws SQLException,ClassNotFoundException;


}