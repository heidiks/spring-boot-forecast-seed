package com.heidiks.forecast.controller;

import com.heidiks.forecast.model.City;
import com.heidiks.forecast.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<City> findItems() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public City addItem(@RequestBody City city) {
        return repo.saveAndFlush(city);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public City updateItem(@RequestBody City updatedCity, @PathVariable Integer id) {
        return repo.saveAndFlush(updatedCity);
    }

}