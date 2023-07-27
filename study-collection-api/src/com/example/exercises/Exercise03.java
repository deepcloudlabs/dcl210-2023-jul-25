package com.example.exercises;

public class Exercise03 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Integer x= Integer.valueOf(108);
		Integer y= 108;
		Integer u= 549;
		Integer v= 549;
		System.out.println("x==y? "+(x==y));
		System.out.println("u==v? "+(u==v));
		int i = 108; // 4-byte
		Integer j = 108; // 12-byte (header) + 4-byte = 16-byte
	}

}
