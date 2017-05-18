package com.heidiks.forecast.controller;

import com.heidiks.forecast.comunicator.OpenWeatherRestClient;
import com.heidiks.forecast.model.City;
import com.heidiks.forecast.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityRepository repo;

    @Autowired
    private OpenWeatherRestClient openWeatherRestClient;

    @RequestMapping(method = RequestMethod.GET)
    public List<City> find() {
        return repo.findAll();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public City save(@RequestBody City city) {
        openWeatherRestClient.getForecast(city);

        return repo.saveAndFlush(city);
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public City update(@RequestBody City updatedCity, @PathVariable Integer id) {
        openWeatherRestClient.getForecast(updatedCity);

        return repo.saveAndFlush(updatedCity);
    }

}