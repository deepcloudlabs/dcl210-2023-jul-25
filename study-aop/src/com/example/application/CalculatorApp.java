package com.example.application;

import java.lang.reflect.Proxy;

import com.example.handler.AuditingHandler;
import com.example.handler.ProfilingHandler;
import com.example.service.Calculator;
import com.example.service.business.StandardCalculator;

public class CalculatorApp {

	public static void main(String[] args) {
		// requirement #1: auditing
		// requirement #2: profiling
		var standardCalculator = new StandardCalculator();
		var clazz = standardCalculator.getClass();
		var clazzLoader = clazz.getClassLoader();
		var auditingHandler = new AuditingHandler(standardCalculator);
		var calculatorProxy = (Calculator) Proxy.newProxyInstance(clazzLoader, clazz.getInterfaces(), auditingHandler);
		var profilingHandler = new ProfilingHandler(calculatorProxy);
		var calculator = (Calculator) Proxy.newProxyInstance(clazzLoader, clazz.getInterfaces(), profilingHandler);
		System.err.println("Proxy class: %s".formatted(calculator.getClass().getName()));
		System.out.println("3+5=%d".formatted(calculator.add(3, 5)));
		System.out.println("3*5=%d".formatted(calculator.mul(3, 5)));
	}

}
