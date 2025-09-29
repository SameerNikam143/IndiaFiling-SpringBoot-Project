package com.tech;

import java.nio.file.DirectoryStream.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

import com.tech.controller.AppConfig;
import com.tech.controller.Main;
import com.tech.controller.Order;


@ComponentScan(basePackages = "com.tech",
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Main.class}))
@SpringBootApplication
@PropertySource("classpath:myConfig.properties")
public class IndiaFilingApplication  implements CommandLineRunner {
	
	
	@Autowired
	AppConfig appconfig;
	
	@Qualifier("s2")
	@Autowired
	Order order;
   
	public static void main(String[] args) {
		SpringApplication.run(IndiaFilingApplication.class, args);
       
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(appconfig.getName());
		System.out.println(appconfig.getPort());
		
		order.placeOrder();
		
	}

	

}
