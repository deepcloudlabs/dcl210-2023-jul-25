package com.example.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class StudySyncHttpClient {
	private static final String BINANCE_REST_API_URL= 
			"https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";

	public static void main(String[] args) throws IOException, InterruptedException {
		var httpClient = HttpClient.newBuilder().build();
		var httpRequest = HttpRequest.newBuilder(URI.create(BINANCE_REST_API_URL)).build();
		long start = System.currentTimeMillis();
		for (var i=0;i<10;++i) {
			var response = httpClient.send(httpRequest, BodyHandlers.ofString()).body();
			System.err.println(response);
		}
		long stop = System.currentTimeMillis();
		System.err.println("Duration is %d ms.".formatted(stop-start));			
	}

}
