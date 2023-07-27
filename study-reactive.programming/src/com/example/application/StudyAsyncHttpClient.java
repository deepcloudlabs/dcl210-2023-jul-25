package com.example.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class StudyAsyncHttpClient {
	private static final String BINANCE_REST_API_URL= 
			"https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";
	private static final AtomicInteger counter = new AtomicInteger();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		var httpClient = HttpClient.newBuilder().build();
		var httpRequest = HttpRequest.newBuilder(URI.create(BINANCE_REST_API_URL)).build();
		long start = System.currentTimeMillis();
		for (var i=0;i<30;++i) {
			httpClient.sendAsync(httpRequest, BodyHandlers.ofString())
			          .thenAcceptAsync(response -> {
			        	  System.err.println(response.body());
			        	  if(counter.incrementAndGet()==30) {
			        		  long stop = System.currentTimeMillis();
			        		  System.err.println("Duration is %d ms.".formatted(stop-start));				        		  
			        	  }
			             }
			          );
		}
		try {TimeUnit.SECONDS.sleep(20);}catch (Exception e) {}
	}

}
