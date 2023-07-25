package com.example.service;

import java.util.List;

import com.example.model.Configuration;

public class BusinessService {
	@Configuration(path = "src", file = "values.csv")
	private List<Integer> values;

	public BusinessService() {
		System.err.println("BusinessService is created.");	
	}
	
	public void fun() {
		System.out.println(values);
	}
}
