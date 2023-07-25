package com.example;

public class Exercise01 {

	public static void main(String[] args) {
		

	}

}

interface I {
	boolean fun(int a);
}

@SuppressWarnings("unused")
class A implements I {
	private int x;
	public A() {}
	@Override
	public boolean fun(int a) {
		// TODO Auto-generated method stub
		return false;
	}
	
}