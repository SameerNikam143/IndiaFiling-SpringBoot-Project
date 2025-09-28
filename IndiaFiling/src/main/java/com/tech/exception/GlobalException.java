package com.tech.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = PasswordIsIncorrectException.class)
	public Map<String,Object> handlerOne(PasswordIsIncorrectException ex){
		LinkedHashMap<String, Object> map = new LinkedHashMap<String,Object>();
		map.put("Error Code ", 400);
		map.put("Error Message ", ex.getMessage());
		map.put("Date ", new Date());
		return map;
	}
	
	@ExceptionHandler(value = DublicateStudentFoundException.class)
	public ResponseEntity<?> handlerTwo(DublicateStudentFoundException ex){
		Fields fields = new Fields(400, ex.getMessage(), new Date());
		return ResponseEntity.badRequest().body(fields);
	}
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<?> handlerThree(EmployeeNotFoundException ex){
		Fields fields = new Fields(400, ex.getMessage(), new Date());
		return ResponseEntity.badRequest().body(fields);
	}
}
