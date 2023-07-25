package com.example;

public class SwitchExercise {

	public static void main(String[] args) {
		String weekDay = "Tuesday";
		String message = switch (weekDay) {
		case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> {
			yield "Work hard!";
		}
		case "Saturday", "Sunday" -> {
			yield "Rest!";
		}
		default -> {
			yield "Error";
		}
		};
		System.out.println(message);
	}

}
