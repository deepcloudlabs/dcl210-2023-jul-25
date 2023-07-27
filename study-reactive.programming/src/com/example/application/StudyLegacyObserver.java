package com.example.application;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

@SuppressWarnings("deprecation")
public class StudyLegacyObserver {

	public static void main(String[] args) {
		System.err.println("Application is just started.");
		var events = List.of(
				new TradeEvent("orcl",100,200),
				new TradeEvent("ibm",90,300),
				new TradeEvent("gogle",120,400),
				new TradeEvent("orcl",101,500)
	   );
		var observable = new TradeEventObservable();
		Observer slowObserver = (o,event) -> {
			try {TimeUnit.SECONDS.sleep(5);}catch(Exception e) {}
			System.err.println("[SlowObserver] New event has arrived: %s".formatted(event));
		};
		Observer fastObserver = (o,event) -> {
			System.err.println("[FastObserver] New event has arrived: %s".formatted(event));
		};
		observable.addObserver(slowObserver);
		observable.addObserver(fastObserver);
		events.forEach(observable::notifyObservers);
		System.err.println("Application is just completed.");
	}

}

@SuppressWarnings("deprecation")
class TradeEventObservable extends Observable {

	@Override
	public void notifyObservers(Object event) {
		setChanged();
		super.notifyObservers(event);
	}
	
}