package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class Exercise2 {
	public static void main(String[] args) {
		var grades = List.of(100, 45, 23, 96, 33, 88);
		int state = 10;
		// ii) Pure Function: a) lambda expression
		Predicate<Integer> largerThan50 = number -> (number+ state)>50;
		// ii) Pure Function: b) method reference
		Comparator<Integer> numeric = Integer::compare;
        grades.stream().filter(NumberUtility::largerThan50)
                       .map(number->number-number%10)
                       .max(numeric);
	}
}

interface NumberUtility {
	public static boolean largerThan50(int number) {
		return number>50;
	}
}