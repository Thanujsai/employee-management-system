package com.ems.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Date;
import java.util.List;

import com.ems.model.Employee;
import com.ems.util.DbConnection;
import com.ems.validator.EmployeeValidator;


public class EmployeeDAOImpl implements EmployeeDAO {
	
	Employee eDAO;
	EmployeeValidator empv = new EmployeeValidator();
	public EmployeeDAOImpl(){
		super();
	}
	public boolean addEmployee(Employee employee) throws SQLException,ClassNotFoundException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement("insert into EmployeeTable(empId,empName,joiningDate,ContractDuration,commercial) values(?,?,?,?,?)");
		pst.setInt(1, employee.getEmpId());
		pst.setString(2, employee.getEmpName());
		pst.setDate(3, employee.getJoiningDate());
		pst.setInt(4, employee.getContractDuration());
		pst.setInt(5, employee.getCommercial());
		//pst.execute();
		if (empv.EmployeeValidator(employee.getEmpId(),employee.getEmpName())) {
			pst.execute();
			return true;
		}
		return false;
	}
	public List<Employee> listAllEmployees() throws SQLException,ClassNotFoundException{
		List<Employee> updateemployeeListByContractDate =  updateEmployeeByContractDate();
		List<Employee> deleteemployeeListByContractDate =  deleteEmployeeByContractDate(updateemployeeListByContractDate);
		return deleteemployeeListByContractDate;
		
	}
	public boolean deleteEmployee(int employeeId) throws SQLException,ClassNotFoundException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement("delete from EmployeeTable where empId = ?");
		Statement st=con.createStatement();
		ArrayList<Employee>al=(ArrayList<Employee>)listAllEmployees();
		Iterator<Employee> it=al.iterator();
		boolean check=false;
		while(it.hasNext()) {
			Employee e=(Employee)it.next();
			if(e.getEmpId()==employeeId) {
				check=true;
			}
		}
		pst.setInt(1,employeeId);
		pst.execute();
		if(check==true) {
			return true;
		}
		return false;
	}
    public List<Employee> deleteEmployeeByContractDate(List<Employee> elist) throws SQLException,ClassNotFoundException {
			Connection con = DbConnection.getConnection();
			int count = 0;
			for(Employee employeeList:elist) {
				PreparedStatement pst = con.prepareStatement("delete from EmployeeTable where current_date > ?");
				pst.setDate(1,employeeList.getContractEndDate());
				count = pst.executeUpdate();
				if (count > 1){
					elist.remove(employeeList);
				}
			}
	       
			return elist;
	
	}
	public boolean updateEmployee(Employee employee) throws SQLException,ClassNotFoundException {
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement("update EmployeeTable set EMPNAME=?,JOININGDATE=?,CONTRACTDURATION=?,COMMERCIAL=?  where EMPID=?");
		//pst.setInt(6, employee.empId());
		System.out.println(employee.getEmpId()+"\n"+employee.getEmpName()+"\n"+employee.getJoiningDate()+"\n"+employee.getContractDuration());
		pst.setString(1, employee.getEmpName());
		pst.setDate(2, employee.getJoiningDate());
		pst.setInt(3, employee.getContractDuration());
	//	pst.setDate(5, null);
		pst.setInt(4, employee.getCommercial());
		pst.setInt(5, employee.getEmpId());
		System.out.println(pst.executeUpdate());
		return true;
	}
	public List<Employee> updateEmployeeByContractDate() throws SQLException,ClassNotFoundException {
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		List<Employee> elist = new ArrayList<Employee>();
		ResultSet rs = st.executeQuery("select * from EmployeeTable");
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setEmpId(rs.getInt(1));
			employee.setEmpName(rs.getString(2));
			employee.setJoiningDate(LocalDate.parse(String.valueOf(rs.getDate(3))));
			employee.setContractDuration(rs.getInt(4));
			employee.setContractEndDate((LocalDate.parse(String.valueOf(rs.getDate(3))).plusMonths(rs.getInt(4))));
			employee.setCommercial(rs.getInt(6));
			elist.add(employee);
		}
		//pst.setInt(1, product.getId());
		
		return elist;
	}
	

}
