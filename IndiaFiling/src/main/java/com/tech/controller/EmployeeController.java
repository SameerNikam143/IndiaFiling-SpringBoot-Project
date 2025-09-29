package com.tech.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.Employee;
import com.tech.entity.EmployeeDTO;
import com.tech.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@PostMapping("/create/single/emp")
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee emp,BindingResult result){
		if(result.hasErrors()) {
			String msg = result.getFieldError().getDefaultMessage();
			return ResponseEntity.badRequest().body(msg);
		}else {
			String msg = service.saveEmployee(emp);
			return ResponseEntity.ok(msg);
		}
	}
	
	@PostMapping("/create/multiple/emp")
	public ResponseEntity<?> createEmployees(@Valid @RequestBody EmployeeDTO empdto ,BindingResult result){
		if(result.hasErrors()) {
			String msg = result.getFieldErrors().get(0).getDefaultMessage();
			return ResponseEntity.badRequest().body(msg);
		}else {
			String msg = service.saveAllEmployee(empdto);
			return ResponseEntity.ok(msg);
		}
	}
	
	
	@GetMapping(value = "/read/{id}/emp",produces = "application/xml")
	public ResponseEntity<?> readEmployee(@PathVariable(required = false) Integer id){
		Employee employee = service.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);
	}
	
	@GetMapping("/read/all/emp")
	public ResponseEntity<?> readAllEmployee(){
		List<Employee> list = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/emp")
	public ResponseEntity<?> deleteEmpByName(@RequestParam String firstName){
		String msg = service.deleteEmployeeByName(firstName);
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteEmployees(){
		String msg = service.deleteAllEmployee();
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/update/emp")
	public ResponseEntity<?> updateEmployee(@Valid @RequestBody Employee emp,BindingResult result){
		if(result.hasErrors()) {
			String msg = result.getFieldError().getDefaultMessage();
			return ResponseEntity.badRequest().body(msg);
		}
		Employee employee = service.updateEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateAll/emp")
	public ResponseEntity<?> updateAllEmployees(@Valid @RequestBody EmployeeDTO emp,BindingResult result){
		if(result.hasErrors()) {
			String msg = result.getFieldErrors().get(0).getDefaultMessage();
			return ResponseEntity.badRequest().body(msg);
					
		}
		List<Employee> updateMultipleEmployee = service.updateMultipleEmployee(emp);
		return new ResponseEntity<List<Employee>>(updateMultipleEmployee, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/get/xml")
	public ResponseEntity<String> getXml(){
		String json="{\r\n"
				+ "      \"id\": 1,\r\n"
				+ "      \"firstName\": \"d\",\r\n"
				+ "      \"middleName\": \"Shriram\",\r\n"
				+ "      \"lastName\": \"Nikam\",\r\n"
				+ "      \"mobileNum\": \"9876543210\",\r\n"
				+ "      \"department\": \"IT\",\r\n"
				+ "      \"age\": 25,\r\n"
				+ "      \"rank\": 2,\r\n"
				+ "      \"gender\": \"Male\",\r\n"
				+ "      \"salary\": 55000.75,\r\n"
				+ "      \"email\": \"sameer.nikam@example.com\",\r\n"
				+ "      \"addrs\": {\r\n"
				+ "        \"village\": \"Hinjewadi\",\r\n"
				+ "        \"taluka\": \"Mulshi\",\r\n"
				+ "        \"district\": \"Pune\"\r\n"
				+ "      },\r\n"
				+ "      \"username\": \"sameer123\",\r\n"
				+ "      \"password\": \"securePass@123\",\r\n"
				+ "      \"confirmPassword\": \"securePass@123\"\r\n"
				+ "    }";
		
		
		       JSONObject j = new JSONObject(json);
		         String string = XML.toString(j);
		         return ResponseEntity.ok(string);
	}
	
	
	@GetMapping("/get/json")
	public ResponseEntity<String> getJson(){
		String xml="<lastName>Nikam</lastName>\r\n"
				+ "<gender>Male</gender>\r\n"
				+ "<addrs>\r\n"
				+ "    <taluka>Mulshi</taluka>\r\n"
				+ "    <district>Pune</district>\r\n"
				+ "    <village>Hinjewadi</village>\r\n"
				+ "</addrs>\r\n"
				+ "<salary>55000.75</salary>\r\n"
				+ "<firstName>d</firstName>\r\n"
				+ "<mobileNum>9876543210</mobileNum>\r\n"
				+ "<password>securePass@123</password>\r\n"
				+ "<rank>2</rank>\r\n"
				+ "<confirmPassword>securePass@123</confirmPassword>\r\n"
				+ "<middleName>Shriram</middleName>\r\n"
				+ "<id>1</id>\r\n"
				+ "<department>IT</department>\r\n"
				+ "<age>25</age>\r\n"
				+ "<email>sameer.nikam@example.com</email>\r\n"
				+ "<username>sameer123</username>";
		
		
		JSONObject j = XML.toJSONObject(xml);
		String json = j.toString();
		return ResponseEntity.ok(json);
	}
	
	
	
	
}
