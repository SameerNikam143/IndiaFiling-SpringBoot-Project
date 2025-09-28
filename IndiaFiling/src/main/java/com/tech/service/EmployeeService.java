package com.tech.service;

import java.util.List;

import com.tech.entity.Employee;
import com.tech.entity.EmployeeDTO;

public interface EmployeeService {

	public String saveEmployee(Employee emp);
	
	public String saveAllEmployee(EmployeeDTO employees);
	
	public Employee getEmployeeById(Integer id);
	
	public List<Employee> getAllEmployees();
	
	public String deleteEmployeeByName(String name);
	
	public String deleteAllEmployee();
	
	public Employee updateEmployee(Employee emp);
	
	public List<Employee> updateMultipleEmployee(EmployeeDTO emp);
}
