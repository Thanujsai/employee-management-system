package com.ems.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
public class Employee {
	private int empId;
	private String empName;
	private LocalDate joiningDate;
	private int contractDuration;
	private LocalDate contractEndDate;
	private int Commercial;
	
	public Employee() {
		
	}

	public Employee(int empId, String empName, LocalDate joiningDate, int contractDuration, LocalDate contractEndDate,
			int commercial) {
		//super();
		this.empId = empId;
		this.empName = empName;
		this.joiningDate = joiningDate;
		this.contractDuration = contractDuration;
		this.contractEndDate = contractEndDate;
		Commercial = commercial;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getJoiningDate() {
		return Date.valueOf(joiningDate);
	}

	public void setJoiningDate(LocalDate date) {
		this.joiningDate = date;
	}

	public int getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}

	public Date getContractEndDate() {
		return Date.valueOf(contractEndDate);
	}

	public void setContractEndDate(LocalDate contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public int getCommercial() {
		return Commercial;
	}

	public void setCommercial(int commercial) {
		Commercial = commercial;
	}
	
	
	

}
