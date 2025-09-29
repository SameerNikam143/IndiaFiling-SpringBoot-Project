package com.tech.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



@Component("s1")
public class ServiceImpl_1 implements Order {

	@Override
	public void placeOrder() {
		// TODO Auto-generated method stub
		System.out.println("serviceimpl 1");
	}

}
