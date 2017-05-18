package com.heidiks.forecast.service;

import com.heidiks.forecast.model.City;
import com.heidiks.forecast.repository.CityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by heidi on 18/05/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

    public static final long CITY_ID = 1L;
    @InjectMocks
    private CityService service;

    @Mock
    private CityRepository repository;

    private City city;

    @Before
    public void setUp() {
        city = new City("Maringá", "Brazil");
    }

    @Test
    public void findAll() {
        service.findAll();

        verify(repository).findAll();
    }

    @Test
    public void delete() {
        service.delete(CITY_ID);

        verify(repository).delete(CITY_ID);
    }

    @Test
    public void findOne() {
        service.findOne(CITY_ID);

        verify(repository).findOne(CITY_ID);
    }

    @Test
    public void save() {
        service.save(city);

        verify(repository).saveAndFlush(city);
    }

}