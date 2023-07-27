package com.example.application;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class StudyWebSocketClient {
	private static final String BINANCE_WS_API_URL= 
			"wss://stream.binance.com:9443/ws/btcusdt@trade";
	public static void main(String[] args) {
		HttpClient.newHttpClient()
		          .newWebSocketBuilder()
                  .buildAsync(URI.create(BINANCE_WS_API_URL), new BinanceWebSocketListener());
		try {TimeUnit.SECONDS.sleep(20);}catch (Exception e) {}
	}

}

class BinanceWebSocketListener implements Listener {

	@Override
	public void onOpen(WebSocket webSocket) {
		System.err.println("Connected to the binance websocket server.");
		webSocket.request(1);
	}

	@Override
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
		System.err.println(data);
		webSocket.request(1);
		return null;
	}

	@Override
	public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
		System.err.println("Disconnected from the binance websocket server.");
		return Listener.super.onClose(webSocket, statusCode, reason);
	}

	@Override
	public void onError(WebSocket webSocket, Throwable error) {
		System.err.println("An error has occurred: %s".formatted(error.getMessage()));		
		Listener.super.onError(webSocket, error);
	}
	
}
