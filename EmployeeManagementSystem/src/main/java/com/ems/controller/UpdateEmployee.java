package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Integer id=Integer.parseInt(request.getParameter("empId"));
		String name=request.getParameter("empName");
	    Integer duration=Integer.parseInt(request.getParameter("duration"));
		LocalDate joiningDate = LocalDate.parse(request.getParameter("joiningDate"));
		Integer commercial = Integer.parseInt(request.getParameter("commercial"));
		//LocalDate contractendDate = null;
		Employee employee = new Employee();
		employee.setEmpId(id);
		employee.setEmpName(name);
		employee.setJoiningDate(joiningDate);
		employee.setContractDuration(duration);
		//employee.setContractEndDate(contractendDate);
		employee.setCommercial(commercial);
		try {
			EmployeeService ps = new EmployeeServiceImpl();
			boolean result = ps.updateEmployee(employee);
			if(result) {
				out.println("Employee updated");
			}
			else {
				out.println("not updated");
			}
		
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		

}}
