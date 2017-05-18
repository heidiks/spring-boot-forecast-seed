package com.heidiks.forecast.service;

import com.heidiks.forecast.model.City;
import com.heidiks.forecast.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by heidi on 18/05/2017.
 */
@Service
public class CityService {

    @Autowired
    private CityRepository repo;

    public List<City> findAll() {
        return repo.findAll();
    }

    public City save(City city) {
        return repo.saveAndFlush(city);
    }

    public City findOne(Long id) {
        return repo.findOne(id);
    }

    public void delete(Long id) {
        repo.delete(id);
    }
}
