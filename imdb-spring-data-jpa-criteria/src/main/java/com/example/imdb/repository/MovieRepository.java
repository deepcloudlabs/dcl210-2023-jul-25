package com.example.imdb.repository;

import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.imdb.entity.Movie;
import com.example.imdb.entity.Movie_;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public interface MovieRepository extends JpaRepository<Movie, Integer>,CriteriaMovieRepository,JpaSpecificationExecutor<Movie> {
	@Transactional
	Stream<Movie> findAllStreamByYearBetween(int from, int to);

	Optional<Movie> findOneByImdb(String imdb);
	
	static Specification<Movie> titleContains(String title) {
	    return (movie, cq, cb) -> cb.like(movie.get(Movie_.title), "%" + title + "%");
	}	
	
}
