package com.heidiks.forecast.controller;

import com.heidiks.forecast.comunicator.OpenWeatherRestClient;
import com.heidiks.forecast.model.City;
import com.heidiks.forecast.service.CityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by heidi on 18/05/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CityControllerTest {

    public static final long CITY_ID = 1L;
    @InjectMocks
    private CityController controller;

    @Mock
    private CityService service;

    @Mock
    private OpenWeatherRestClient openWeatherRestClient;

    private City city;

    @Before
    public void setUp() throws Exception {
        city = new City("Maringá", "Brazil");
    }

    @Test
    public void find() throws Exception {
        controller.find();

        verify(service).findAll();
    }

    @Test
    public void save() throws Exception {
        controller.save(city);

        verify(openWeatherRestClient).getForecast(city);
        verify(service).save(city);
    }

    @Test
    public void update() throws Exception {
        controller.update(city, CITY_ID);

        verify(openWeatherRestClient).getForecast(city);
        verify(service).save(city);
    }

    @Test
    public void getForecast() throws Exception {
        when(service.findOne(CITY_ID)).thenReturn(city);
        controller.getForecast(CITY_ID);

        verify(openWeatherRestClient).getForecast(city);
    }

    @Test
    public void delete() throws Exception {
        controller.delete(CITY_ID);

        verify(service).delete(CITY_ID);
    }

}