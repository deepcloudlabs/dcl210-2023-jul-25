package com.example.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class AuditingHandler implements InvocationHandler {
    private final Object targetObject;
	
	public AuditingHandler(Object targetObject) {
		this.targetObject = targetObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println("[AuditingHandler] %s runs at %s.".formatted(method.getName(),new Date()));
		System.err.println("[AuditingHandler] Parameters are %s".formatted(Arrays.toString(args)));
		var result = method.invoke(targetObject, args);
		System.err.println("[AuditingHandler] %s returns %s.".formatted(method.getName(),result));
		return result;
	}

}
