package com.example.exercises;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise05 {

	public static void main(String[] args) {
        var numbers = List.of(4,8,15,16,23,42);
        Predicate<Integer> even = n -> { 
        	System.err.println("even(%d)".formatted(n));
        	return n%2 == 0;
        };
		Function<Integer, Integer> _2n_plus_one = x -> { 
			System.err.println("_2n_plus_one(%d)".formatted(x));
			return 2*x+1;
		};
		BinaryOperator<Integer> add = (acc,u) -> { 
			System.err.println("add(%d,%d)".formatted(acc,u));
			return acc+u; 
		};
		var result = 
        numbers.stream()
               //.parallel() // intermediary methods
               .map( _2n_plus_one )  // 9, 17, 33, 85
               .filter( even) // 4, 8, 16, 42
               .reduce(0, add); // terminal method
        System.out.println(result); // 144 ?
	}

}
