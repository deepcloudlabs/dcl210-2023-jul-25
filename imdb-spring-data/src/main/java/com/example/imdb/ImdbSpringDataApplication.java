package com.example.imdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import com.example.imdb.entity.Movie;
import com.example.imdb.repository.MovieRepository;

@SpringBootApplication
public class ImdbSpringDataApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(ImdbSpringDataApplication.class, args);
	}
	
	@Autowired
	private MovieRepository movieRepo;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
//		Movie movie = new Movie();
//		movie.setTitle("test movie");
//		movie.setYear(2019);
//		movie.setImdb("tt1234567");
//		movieRepo.save(movie);
//		movieRepo.filminTuruneGoreAra("War").forEach(System.out::println);
//		movieRepo.filminYilinaVeAdinaGoreAra(1970,1979,"the").forEach(System.out::println);
		movieRepo.findAllByYearBetween(1970,1979).forEach(System.out::println);
		System.out.println("==============================================================");
		movieRepo.findAllByYear(2009).forEach(System.out::println);
		System.out.println("==============================================================");
		movieRepo.findAllByGenresIdIn(8).forEach(System.out::println);
		System.out.println("==============================================================");
		movieRepo.findAllByGenresDescriptionIn("War").forEach(System.out::println);
		System.out.println("==============================================================");
		movieRepo.yillaraGoreAra(1976).forEach(System.out::println);
		System.out.println("==============================================================");
		movieRepo.birdenFazlaYonetmenliFilmler().forEach(System.out::println);
		System.out.println("==============================================================");
		Movie movie76 = new Movie();
		movie76.setYear(1976);
		Example<Movie> yearExample = Example.of(movie76);
		movieRepo.findAll(yearExample).forEach(System.out::println);
	}

}
