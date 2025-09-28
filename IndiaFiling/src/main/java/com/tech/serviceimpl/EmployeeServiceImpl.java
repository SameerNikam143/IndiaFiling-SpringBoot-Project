package com.tech.serviceimpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.Employee;
import com.tech.entity.EmployeeDTO;
import com.tech.exception.DublicateStudentFoundException;
import com.tech.exception.EmployeeNotFoundException;
import com.tech.exception.PasswordIsIncorrectException;
import com.tech.repository.EmployeeRepo;
import com.tech.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepo repo;

	@Override
	public String saveEmployee(Employee emp) {
		if(emp.getPassword().equals(emp.getConfirmPass())) {
			Optional<Employee> opc = repo.findById(emp.getId());
			if(opc.isPresent()) {
				throw new DublicateStudentFoundException(emp.getId()+" Employee Is Dublicate");
			}else {
				repo.save(emp);
				return emp.getId()+" Employee Saved SuccessFully";
			}
		}else {
			throw new PasswordIsIncorrectException(emp.getId()+" Password is Incorrect");
		}
		
	}

	@Override
	public String saveAllEmployee(EmployeeDTO employees) {
		
		Set<Integer> newIds =
				employees.getEmployees()
				   .stream()
				      .map(Employee::getId)
				        .collect(Collectors.toSet());
		
		List<Integer> existingIds = 
				repo.findAllById(newIds)
				  .stream()
				     .map(Employee::getId)
				        .collect(Collectors.toList());
		
		for(Employee emp:employees.getEmployees()) {
			if(emp.getPassword().equals(emp.getConfirmPass())) {
				for(Integer newId:newIds) {
					if(existingIds.contains(newId)) {
						throw new DublicateStudentFoundException(newId+" Dublicate Employee");
					}
				}
			}else {
				throw new PasswordIsIncorrectException(emp.getId()+" Password Is Incorrect");
			}
		}
		
		repo.saveAll(employees.getEmployees());
		return newIds+" All Employees Saved SuccessFully";
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> opc = repo.findById(id);
		if(opc.isPresent()) {
			return opc.get();
		}
		throw new EmployeeNotFoundException(id +" Employee Not Found");
	}

	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = repo.findAll();
		if(!list.isEmpty()) {
			return list;
		}
		throw new EmployeeNotFoundException("No Employee Found");
	}

	@Override
	public String deleteEmployeeByName(String name) {
		 Optional<List<Employee>> emp = repo.findAllByFirstName(name);
		 if(emp.isPresent()) {
			 repo.deleteAllByFirstName(name);
			 return name+" Deleted SuccessFully";
		 }
		 throw new EmployeeNotFoundException(name+" Not Found");
		
		
	}

	@Override
	public String deleteAllEmployee() {
		List<Employee> list = repo.findAll();
		if(!list.isEmpty()) {
			repo.deleteAll();
			return "All Employee Deleted";
		}
		throw new EmployeeNotFoundException("No Employee Found");
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> opc = repo.findById(emp.getId());
		if(opc.isPresent()) {
			if(emp.getPassword().equals(emp.getConfirmPass())) {
				return repo.save(emp);
				
			}
			throw new PasswordIsIncorrectException("Password Is Incorrect");
			
		}
		throw new EmployeeNotFoundException(emp.getId()+" Employee Not Found");
	}

	@Override
	public List<Employee> updateMultipleEmployee(EmployeeDTO emp) {
		List<Integer> newIds =
				emp.getEmployees()
				.stream()
				.map(Employee::getId)
				.distinct()
				.collect(Collectors.toList());
	
		List<Integer> existingIds = 
				repo.findAllById(newIds)
				.stream()
				.map(Employee::getId)
				.collect(Collectors.toList());
		
		for(Employee employee:emp.getEmployees()) {
			if(employee.getPassword().equals(employee.getConfirmPass())) {
				for(Integer newId:newIds) {
					
					if(!existingIds.contains(newId)) {
						throw new EmployeeNotFoundException(newId+" Employee Not Found");
					}
					
				}
				
			}else {
				throw new PasswordIsIncorrectException(employee.getId()+" Password Is Incorrect");
			}
		}
		
		return repo.saveAll(emp.getEmployees());

	
	}

}
