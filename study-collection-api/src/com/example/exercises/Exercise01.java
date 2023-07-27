package com.example.exercises;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Exercise01 {
	private static final String basicRules=  "< z < b < c < ç < d < e < f < g < ğ < h "+
	        "< ı < i < j < k < l < m < n < o < ö < p "+
	        "< r < s < ş < t < u < ü < v < y < a ";
	private static final String trExpension= "& şi ; she & ş ; sch & s ; ş & u ; ü & i ; ı " + 
            "& c ; ç & o ; ö & ğ ; g" ;
	public static void main(String[] args) throws ParseException {
		final Collator collator= new RuleBasedCollator(basicRules+trExpension);
		Collator.getInstance(Locale.of("tr","TR"));
		collator.setStrength(Collator.PRIMARY);
		// 1. List i) Allows duplicates ii) Ordered
		List<Integer> numbers = new ArrayList<>();
		numbers.add(4);
		numbers.add(42);
		numbers.add(8);
		numbers.add(4);
		numbers.add(0,15);
		numbers.add(4);
		numbers.sort((x,y) -> y-x); // HoF
		System.out.println(numbers.get(4));
		numbers.remove(2);
		System.out.println(numbers);
		System.out.println(numbers.contains(4));
		// 2. Set  i) Distinct          ii) Unordered
		Set<String> names = new TreeSet<>(collator::compare); // LinkedHashSet, HashSet, TreeSet
		names.add("ali");
		names.add("ayşegül");
		names.add("veli");
		names.add("şima");
		names.add("veli");
		names.add("şule");
		names.add("veli");
		names.add("zehra");
		names.add("veli");
		System.out.println(names);
		System.out.println("shema==şima: %d".formatted(collator.compare("şima", "shema")));
		System.out.println(names.contains("zehra"));
		// 3. Deque -> List: i) Allows duplicates ii) Ordered
		Deque<Integer> nums = new ArrayDeque<>();
		nums.add(4);
		nums.add(42);
		nums.add(8);
		nums.add(4);
		nums.add(15);
		nums.add(4);
		nums.forEach(System.out::println);
		// 4. Map<K, V>
        // Key --> Value
		Map<String,Integer> areaCodes = new HashMap<>(1_000_000); // LinkedHashMap, TreeMap, IdentityMap,... 
		areaCodes.put("istanbul-anadolu", 216);
		areaCodes.put("istanbul-avrupa", 212);
		areaCodes.put("ankara", 312);
		System.out.println(areaCodes.get("ankara"));
		areaCodes.keySet().forEach(System.out::println);
		areaCodes.values().forEach(System.out::println);
		areaCodes.entrySet().forEach(entry -> System.out.println("%24s -> %3d".formatted(entry.getKey(),entry.getValue())));
	}

}
