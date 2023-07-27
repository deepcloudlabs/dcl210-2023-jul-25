package com.example.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class BusinessService {
	
	public int doBusiness() { // synchronous/blocking function
		try {TimeUnit.SECONDS.sleep(5);}catch (Exception e) {}
		return 42;
	}

	public CompletableFuture<Integer> doAsyncBusiness() { // asynchronous/non-blocking function
		return CompletableFuture.supplyAsync(()->{
			try {TimeUnit.SECONDS.sleep(5);}catch (Exception e) {}
			return 42;			
		});
	}
	
}
