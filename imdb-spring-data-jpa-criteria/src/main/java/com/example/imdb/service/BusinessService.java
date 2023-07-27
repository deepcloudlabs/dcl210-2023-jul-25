package com.example.imdb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.imdb.entity.Movie;
import com.example.imdb.repository.MovieRepository;

@Service
public class BusinessService {
	private MovieRepository movieRepo;

	public BusinessService(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}

	@Transactional
	public List<Movie> findAllByYearBetween(int from, int to) {
		return movieRepo.findAllStreamByYearBetween(from, to).collect(Collectors.toList());
	}
}
