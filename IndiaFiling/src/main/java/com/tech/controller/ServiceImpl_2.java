package com.tech.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("s2")
public class ServiceImpl_2 implements Order {

	@Override
	public void placeOrder() {
		// TODO Auto-generated method stub
		System.out.println("serviceimpl 2");
	}

}
