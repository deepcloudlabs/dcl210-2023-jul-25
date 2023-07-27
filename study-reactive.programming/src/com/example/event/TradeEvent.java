package com.example.event;

import java.util.Objects;

public record TradeEvent(String symbol,double price,double quantity) { }

final class TradeEventClass {
	private final String symbol;
	private final double price;
	private final double quantity;
	public TradeEventClass(String symbol, double price, double quantity) {
		this.symbol = symbol;
		this.price = price;
		this.quantity = quantity;
	}
	public String getSymbol() {
		return symbol;
	}
	public double getPrice() {
		return price;
	}
	public double getQuantity() {
		return quantity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(price, quantity, symbol);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeEventClass other = (TradeEventClass) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(quantity) == Double.doubleToLongBits(other.quantity)
				&& Objects.equals(symbol, other.symbol);
	}
	@Override
	public String toString() {
		return "TradeEventClass [symbol=" + symbol + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
