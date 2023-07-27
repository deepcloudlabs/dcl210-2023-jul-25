package com.example.imdb.repository.criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Genre_;
import com.example.imdb.entity.Movie;
import com.example.imdb.entity.Movie_;
import com.example.imdb.repository.CriteriaMovieRepository;

@Repository
public class CriteriaMovieRepositoryImpl implements CriteriaMovieRepository {
	private EntityManager entityManager;

	public CriteriaMovieRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Movie> findMoviesByYearRangeAndTitle(int from, int to, String title) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);

		Root<Movie> movie = cq.from(Movie.class);
		List<Predicate> predicates = new ArrayList<>();

		predicates.add(
				cb.and(cb.greaterThanOrEqualTo(movie.get(Movie_.year), from), cb.lessThan(movie.get(Movie_.year), to)));
		if (title != null) {
			predicates.add(cb.like(movie.get(Movie_.title), "%" + title + "%"));
		}
		cq.where(predicates.toArray(new Predicate[0]));

		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public List<Movie> findMoviesByGenre(String genreName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> movie = cq.from(Movie.class);
		Join<Movie, Genre> join = movie.join(Movie_.genres);
		Predicate condition = cb.equal(join.get(Genre_.description), genreName);
		cq.select(movie).where(condition);
		return entityManager.createQuery(cq).getResultList();
	}

}
