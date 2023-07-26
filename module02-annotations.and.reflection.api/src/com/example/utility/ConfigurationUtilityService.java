package com.example.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import com.example.model.Configuration;

public class ConfigurationUtilityService {
	public void loadConfiguration(Object o) {
		var clazz = o.getClass();
		for (var field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(Configuration.class)) {
				var configuration = field.getAnnotation(Configuration.class);
				try {
					List<Integer> listOfValues = getLsv(configuration);
					field.setAccessible(true);
					field.set(o, listOfValues); // reflection
					field.setAccessible(false);
				} catch (IllegalArgumentException | IllegalAccessException | IOException e) {
					System.err.println("Error: %s.".formatted(e.getMessage()));
				}
			}
		}
	}

	private List<Integer> getLsv(Configuration configuration) throws IOException {
		var path = configuration.path();
		var file = configuration.file();
		var seperator = configuration.seperator();
		return Files.readAllLines(Path.of(path, file))
				    .stream()
				    .map(line -> Arrays.stream(line.split(seperator)).map(Integer::parseInt).toList())
				    .flatMap(List::stream)
				    .toList();
	}
}
