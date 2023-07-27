package com.example.imdb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Entity
@Table(name = "movies")
@NamedQueries({ 
	@NamedQuery(name = "Movie.findAll", query = "select m from Movie m"),
	@NamedQuery(name = "Movie.findAllByYearBetween", query = "select m from Movie m where m.year between :from and :to") 
})
@DynamicUpdate
public class Movie {
	@Id
	@Column(name = "movieId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String imdb;
	private int year;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "moviedirectors", 
	    joinColumns = {
			@JoinColumn(name = "movieId", referencedColumnName = "movieId", nullable = false) 
		}, 
	    inverseJoinColumns = {
			@JoinColumn(name = "directorId", referencedColumnName = "directorId", nullable = false) 
		}
	)
	private List<Director> directors;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "moviegenres", 
		joinColumns = {
			@JoinColumn(name = "movieId", referencedColumnName = "movieId", nullable = false) 
		}, 
		inverseJoinColumns = {
			@JoinColumn(name = "genreId", referencedColumnName = "genreId", nullable = false) 
		}
	)
	private List<Genre> genres;

	public Movie() {
	}

	public Movie(String title, int year, String imdb) {
		this.title = title;
		this.year = year;
		this.imdb = imdb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", imdb=" + imdb + "]";
	}

}