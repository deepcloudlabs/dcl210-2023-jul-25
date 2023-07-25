package com.example;

public class StudySealedClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

sealed interface Calculator permits ArithmeticCalculator, TrigonometricCalculator{
	double add(double x,double y);
}

// Error
/*
class Z implements Calculator {

	@Override
	public double add(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
*/

final class ArithmeticCalculator implements Calculator {

	@Override
	public double add(double x, double y) {
		return x+y;
	}

	
}

final class TrigonometricCalculator implements Calculator {

	@Override
	public double add(double x, double y) {
		return x+y;
	}

	
}
sealed class U permits R {}
final class R extends U {}
// Error: final class S extends U {}