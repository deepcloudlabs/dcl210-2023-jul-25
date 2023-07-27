package com.example.exercises;

import java.util.IdentityHashMap;
import java.util.Map;

public class Exercise02 {

	public static void main(String[] args) {
		Map<Integer, String> map = new IdentityHashMap<Integer, String>();
		map.put(Integer.valueOf(108), "108"); // 1   1
		map.put(108, "108"); // 1   1
		map.put(549, "549"); // 2   2
		map.put(549, "549"); // 3   2
		System.err.println(map.size());
	}

}
