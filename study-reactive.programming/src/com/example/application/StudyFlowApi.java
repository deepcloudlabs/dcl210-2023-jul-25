package com.example.application;

import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

public class StudyFlowApi {

	public static void main(String[] args) {
		System.err.println("Application is just started.");
		var events = List.of(new TradeEvent("orcl", 100, 200), new TradeEvent("ibm", 90, 300),
				new TradeEvent("gogle", 120, 400), new TradeEvent("orcl", 101, 500));
		var slowSubscriber = new SlowSubscriber();
		var fastSubscriber = new FastSubscriber();
		try (var publisher = new SubmissionPublisher<TradeEvent>();) {
			publisher.subscribe(slowSubscriber);
			publisher.subscribe(fastSubscriber);
			events.forEach(publisher::submit);
			System.err.println("Application is just completed.");
			try {
				TimeUnit.SECONDS.sleep(30);
			} catch (Exception e) {
			}
		}
	}

}

class SlowSubscriber implements Subscriber<TradeEvent> {
	
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("SlowSubscriber has successfully subscribed to the publisher.");
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(TradeEvent event) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
		}
		System.err.println("SlowSubscriber has received new event: %s".formatted(event));
        subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		System.err.println("SlowSubscriber has received an error: %s".formatted(t.getMessage()));
	}

	@Override
	public void onComplete() {
		System.err.println("SlowSubscriber has been completed.");
	}

}

class FastSubscriber implements Subscriber<TradeEvent> {
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("FastSubscriber has successfully subscribed to the publisher.");
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(TradeEvent event) {
		System.err.println("FastSubscriber has received new event: %s".formatted(event));
		subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		System.err.println("FastSubscriber has received an error: %s".formatted(t.getMessage()));
	}

	@Override
	public void onComplete() {
		System.err.println("FastSubscriber has been completed.");
	}

}
