package com.tech;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tech.controller.Calculator;

import junit.framework.Assert;

public class CalculatorTest {

   static Calculator calculator;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("BeforeAll");
		calculator=new Calculator();
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("BeforeEach");
	}
	
	@Test
	public void testAddition() {
		System.out.println("Addition Test");
		Integer actualResult = calculator.addition(10, 20);
		Integer expectedResult=30;
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void testSubraction() {
		System.out.println("Subraction Test");
		Integer actualResult = calculator.subraction(5, 5);
		Integer expectedResult=5;
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("AfterEach");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("AfterAll");
		calculator=null;
	}
	
	
}
