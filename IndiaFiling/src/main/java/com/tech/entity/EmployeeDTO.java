package com.tech.entity;

import java.util.List;
import javax.validation.Valid;

public class EmployeeDTO {

	@Valid
	private List<Employee> employees;
	
	
	public void setEmployees(List<Employee> employee) {
		this.employees=employee;
	}
	
	public List<Employee> getEmployees(){
		return employees;
	}
}
