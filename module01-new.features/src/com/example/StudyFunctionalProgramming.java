package com.example;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class StudyFunctionalProgramming {

	public static void main(String[] args) {
		var jack1 = new Customer("1", "jack shephard", 1984, "istanbul");
		var jack2 = new Customer("1", "jack shephard", 1984, "istanbul");
		System.out.println(jack1.fullname());
		System.out.println(jack1.hashCode());
		System.out.println(jack2.hashCode());
		System.out.println(jack1.equals(jack2));
		jack1 = jack1.moveCustomer("ankara");
		System.out.println(jack1.city());
		var customers = List.of(
				jack1,
				new Customer("2", "kate austen", 1988, "izmir"),
				new Customer("3", "jin kwon", 1990, "ankara"),
				new Customer("4", "sun kwon", 1992, "istanbul")
		);
        Map<String,List<Customer>> customersByCity = new HashMap<>();
        for (var customer : customers) {
        	var city = customer.city();
        	var customersInThatCity= customersByCity.get(city);
        	if (Objects.isNull(customersInThatCity)) {
        		customersInThatCity = new ArrayList<>(); 
        		customersByCity.put(city,customersInThatCity);
        	}
        	customersInThatCity.add(customer);
        }
        System.out.println(customersByCity);
        //  i) Higher-Order Function
        // ii) Pure Function
        Function<Customer,String> byCity = Customer::city;
        // lazy evaluation
		customersByCity = customers.stream()
				                   .parallel()
				                   .collect(groupingBy(byCity));
		
	}

}

// immutable class
final record Customer(String identity,String fullname,int birthYear,String city) {
		public Customer moveCustomer(String city){
			return new Customer(this.identity,this.fullname,this.birthYear,city);
		}
}