package com.heidiks.forecast.repository;

import com.heidiks.forecast.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}