package com.heidiks.forecast.db;

import com.heidiks.forecast.model.City;
import com.heidiks.forecast.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final CityRepository repository;

	@Autowired
    public DatabaseLoader(CityRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new City("Maringá", "Brazil"));
		this.repository.save(new City("Blumenau", "Brazil"));
	}
}