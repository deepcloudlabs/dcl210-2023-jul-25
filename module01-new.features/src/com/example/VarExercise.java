package com.example;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class VarExercise {

	public static void main(String[] args) {
		Map<String, List<Employee>> employeeCache1 = new HashMap<String, List<Employee>>();
		Map<String, List<Employee>> employeeCache2 = new HashMap<>();
		var employeeCache3 = new HashMap<String, List<Employee>>();
		var employees = List.of(new Engineer(), new Secretary());
		var values = List.of(3, 3.1415, "Apple", BigInteger.valueOf(1));
	}

}

class Employee {
}

class Engineer extends Employee {
}

class Secretary extends Employee {
}
