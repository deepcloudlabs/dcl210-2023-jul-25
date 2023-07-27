package com.example.imdb.repository;

import java.util.List;

import com.example.imdb.entity.Movie;

public interface CriteriaMovieRepository {
	List<Movie> findMoviesByYearRangeAndTitle(int from,int to,String title);
	List<Movie> findMoviesByGenre(String genreName);
	
}
