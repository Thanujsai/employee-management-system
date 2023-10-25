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
 * Servlet implementation class GetProductController
 */
@WebServlet("/ListAllEmployees")
public class ListAllEmployees extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		List<Employee> elist = new ArrayList<Employee>();
		EmployeeService es = new EmployeeServiceImpl();
		out.println("<table align = 'center' border='2'>");
		try {
			elist = es.listAllEmployees();
			for(Employee e:elist) {
				out.println("<tr><td>"+e.getEmpId()+"</td><td>"+e.getEmpName()+"</td><td>"+e.getJoiningDate()+"</td><td>"+e.getContractDuration()+"</td><td>"+e.getContractEndDate()+"</td><td>"+e.getContractEndDate()+"</td><td>"+e.getCommercial()+"</td><td>"+"</tr>");
			}
			
		}catch(ClassNotFoundException e) {
			e.getMessage();
		}catch(SQLException e) {
			e.getMessage();
		}
		out.println("</table>");
	}

}
