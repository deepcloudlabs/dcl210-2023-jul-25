package com.example.service.business;

import com.example.service.Calculator;

public class StandardCalculator implements Calculator {

	@Override
	public int add(int x, int y) {
		return x+y;
	}

	@Override
	public int sub(int x, int y) {
		return x-y;
	}

	@Override
	public int mul(int x, int y) {
		return x*y;
	}

	@Override
	public int div(int x, int y) {
		return x/y;
	}

}