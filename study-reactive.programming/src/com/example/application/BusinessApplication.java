package com.example.application;

import com.example.service.BusinessService;

public class BusinessApplication {

	public static void main(String[] args) {
		System.out.println("Business Application is just started.");
		var businessService = new BusinessService();
		var result = businessService.doBusiness();
		System.out.println("Result is %d".formatted(result));
		System.out.println("Business Application is just completed.");
	}

}
