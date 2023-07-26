package com.example.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfilingHandler implements InvocationHandler {
    private final Object targetObject;
	
	public ProfilingHandler(Object targetObject) {
		this.targetObject = targetObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var start = System.nanoTime();
		var result = method.invoke(targetObject, args);
		var stop = System.nanoTime();
		System.err.println("[ProfilingHandler] %s runs %d ns.".formatted(method.getName(),stop-start));
		return result;
	}

}
