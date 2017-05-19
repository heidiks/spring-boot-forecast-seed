package com.heidiks.forecast.controller;

import com.heidiks.forecast.comunicator.OpenWeatherRestClient;
import com.heidiks.forecast.model.City;
import com.heidiks.forecast.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService service;

    @Autowired
    private OpenWeatherRestClient openWeatherRestClient;

    @RequestMapping(method = RequestMethod.GET)
    public List<City> find() {
        return service.findAll();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public City save(@RequestBody City city) {
        openWeatherRestClient.getForecast(city);

        return service.save(city);
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public City update(@RequestBody City updatedCity, @PathVariable Long id) {
        openWeatherRestClient.getForecast(updatedCity);

        return service.save(updatedCity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/{id}/forecast", method = RequestMethod.GET)
    public @ResponseBody List<Object> getForecast(@PathVariable Long id) {
        City city = service.findOne(id);

        return openWeatherRestClient.getForecast(city);
    }

}