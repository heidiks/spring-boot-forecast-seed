package com.heidiks.forecast.comunicator;

import com.heidiks.forecast.model.City;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by heidi on 18/05/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class OpenWeatherRestClientTest {

    public static final String FORECAST_API_RETURN = "FORECAST";
    @InjectMocks
    private OpenWeatherRestClient openWeatherRestClient;

    @Mock
    private RestTemplate restTemplate;

    @Rule
    public ExpectedException expectation = ExpectedException.none();

    private City city;
    private static final String GET_FORECAST_URI = "http://api.openweathermap.org/data/2.5/forecast?q={cityName}&mode=json&appid={apiKey}";

    @Before
    public void setUp() {
        city = new City("Maringá", "Brazil");
    }

    @Test
    public void getForecast_should_return_the_forecast_for_the_city() {
        when(restTemplate.getForObject(GET_FORECAST_URI, Object.class, city.getName(), null)).thenReturn(FORECAST_API_RETURN);
        List<Object> forecast = openWeatherRestClient.getForecast(city);

        assertNotNull(forecast);
        assertFalse(forecast.isEmpty());
        assertThat(forecast, CoreMatchers.hasItem(FORECAST_API_RETURN));
    }

    @Test
    public void getForecast_should_return_not_found() {
        when(restTemplate.getForObject(GET_FORECAST_URI, Object.class, city.getName(), null)).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        expectation.expect(RuntimeException.class);
        expectation.expectMessage("Invalid city name");

        openWeatherRestClient.getForecast(city);
    }

    @Test
    public void getForecast_should_return_invalid_request() {
        when(restTemplate.getForObject(GET_FORECAST_URI, Object.class, city.getName(), null)).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

        expectation.expect(RuntimeException.class);
        expectation.expectMessage("Invalid request");

        openWeatherRestClient.getForecast(city);
    }

}