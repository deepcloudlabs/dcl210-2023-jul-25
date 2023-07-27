package com.example.imdb;

import java.util.Collection;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;

import com.example.imdb.config.DatabaseConfig;
import com.example.imdb.entity.Movie;
import com.example.imdb.repository.MovieRepository;
import com.example.imdb.service.BusinessService;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = new AnnotationConfigApplicationContext(DatabaseConfig.class);
		MovieRepository repo = container.getBean(MovieRepository.class);
		System.err.println(repo.getClass());
		repo.findById(1).ifPresent(System.out::println);
		repo.findAll(PageRequest.of(4, 10))
		    .getContent()
		    .stream()
		    .map(Movie::getDirectors)
		    .flatMap(Collection::stream)
		    .forEach(System.out::println);
		System.err.println("repo.findAllByYearBetween(1970, 1979):");
		container.getBean(BusinessService.class).findAllByYearBetween(1970, 1979).forEach(System.out::println);
		System.err.println("findMoviesByYearRangeAndTitle(1970, 1979, \"the\")");
		repo.findMoviesByYearRangeAndTitle(1970, 1979, "the").forEach(System.out::println);
		System.err.println("MovieRepository.titleContains(\"the\"))");
		repo.findAll(MovieRepository.titleContains("the")).forEach(System.out::println);
		System.err.println("MovieRepository.findMoviesByGenre(\"Drama\"))");
		repo.findMoviesByGenre("Drama").forEach(System.out::println);
//		try (Stream<Movie> items = repo.findAllStreamByYearBetween(1970, 1979)) {
//			items.forEach(System.out::println);
//		}
//		Movie movie = new Movie("My Movie 1024",2155,"tt124555");
//		Movie saved = repo.save(movie);
//		System.out.println(saved);
//		movie.setTitle("My Movie 2048");
//		repo.update(movie).ifPresent(System.err::println);
//		repo.deleteById(256);
		container.close();
		System.err.println("COMPLETED!");
	}
}
