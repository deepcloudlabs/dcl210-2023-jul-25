package com.example.exercises;

import java.util.Objects;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise24 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Functional Programming -> Stream API -> filter/map/reduce
		// Find the highest populated capital city
		var capital =
        countryDao.findAllCountries()   // List<Country>
                  .stream()				// Stream<Country>
                  .parallel()
                  .peek(System.out::println)
                  // .map(country -> country.getCapital())
                  .map(Country::getCapital) // Stream<Integer>
                  .peek(System.out::println)
                  // .map(cityId -> cityDao.findCityById(cityId)) // Stream<City>
                  .map(cityDao::findCityById) // Stream<City>
                  .peek(System.out::println)
                  .filter(Objects::nonNull)
                  .peek(System.out::println);
                  //.max(Comparator.comparing(City::getPopulation));
        //capital.ifPresent(System.out::println);  
        var totalCapitalCityPopulation =
        countryDao.findAllCountries()   // List<Country>
		        .stream()				// Stream<Country>
		        .parallel()
		        // .map(country -> country.getCapital())
		        .map(Country::getCapital) // Stream<Integer>
		        // .map(cityId -> cityDao.findCityById(cityId)) // Stream<City>
		        .map(cityDao::findCityById) // Stream<City>
		        .filter(Objects::nonNull)
		        .mapToLong(City::getPopulation)
		        .reduce(Long::sum);
        System.out.println(totalCapitalCityPopulation.getAsLong());
	}

}
