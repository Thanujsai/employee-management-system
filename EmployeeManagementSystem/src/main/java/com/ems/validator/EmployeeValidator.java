package com.ems.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidator {
	public boolean EmployeeValidator(int empId,String empName){
		String regex = "^([A-Za-z].+){1,15}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(empName);
		if(empId != 0 && matcher.matches())
			return true;
		return false;
	}
}
