package com.example.imdb.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.imdb.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, CustomCriteriaMovieRepository {
	List<Movie> findAllByYearBetween(int fromYear,int toYear);
	List<Movie> findAllByGenresIdIn(int genreId);
	Stream<Movie> findAllByYear(int year);
	Stream<Movie> findAllByGenresDescriptionIn(String genre);
	Stream<Movie> yillaraGoreAra(int year);
	Stream<Movie> birdenFazlaYonetmenliFilmler();
}
