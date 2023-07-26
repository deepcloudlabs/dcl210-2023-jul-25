package com.example;

import java.lang.reflect.InvocationTargetException;

public class Exercise {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		var jack = new Employee("11111111110", "jack", 1956);
		var identity = Employee.class
				               .getDeclaredMethod("getIdentity")
		                       .invoke(jack);
		// jack.getIdentity();
		System.out.println(identity);
	}

}

class Employee {
	private String identity;
	private String fullname;
	private int birthYear;

	public Employee(String identity, String fullname, int birthYear) {
		this.identity = identity;
		this.fullname = fullname;
		this.birthYear = birthYear;
	}

	public String getIdentity() {
		return identity;
	}

	public String getFullname() {
		return fullname;
	}

	public int getBirthYear() {
		return birthYear;
	}

	
}