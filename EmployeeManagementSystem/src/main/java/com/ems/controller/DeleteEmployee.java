package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;



/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Integer id=Integer.parseInt(request.getParameter("id"));
	    Employee employee = new Employee();
		try {
			EmployeeService es = new EmployeeServiceImpl();
			boolean result = es.deleteEmployee(id);
			if(result) {
				out.println("Product deleted");
			}
			else {
				out.println("Product not deleted");
			}
		
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		

}}