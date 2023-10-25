package com.ems.service;

import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;


import com.ems.dao.EmployeeDAO;
import com.ems.dao.EmployeeDAOImpl;
import com.ems.exception.EmployeeListEmptyException;
import com.ems.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	EmployeeDAO eDAO;
	
	public boolean addEmployee(Employee employee) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		eDAO = new EmployeeDAOImpl();
		boolean result = eDAO.addEmployee(employee);
		return result;
	}

	
	public List<Employee> listAllEmployees() throws SQLException,ClassNotFoundException {
		
		List<Employee> plist=new ArrayList<Employee>();
		eDAO = new EmployeeDAOImpl();
		plist = eDAO.listAllEmployees();
		try{
			if(plist.size() == 0) {
				throw new EmployeeListEmptyException("List is Empty");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return plist;
	}
	public boolean deleteEmployee(int productId) throws SQLException,ClassNotFoundException {
		
		eDAO = new EmployeeDAOImpl();
		boolean result = eDAO.deleteEmployee(productId);
		return result;
	}
	public boolean updateEmployee(Employee employee) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		eDAO = new EmployeeDAOImpl();
		boolean result = eDAO.updateEmployee(employee);
		return result;
	}


	
}