package com.heidiks.forecast.comunicator;

import com.heidiks.forecast.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by heidi on 17/05/2017.
 */
@Component
public class OpenWeatherRestClient {

    @Value("${openweather.api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    private static final String GET_FORECAST_URI = "http://api.openweathermap.org/data/2.5/forecast?q={cityName}&mode=json&units=metric&appid={apiKey}";

    public List<Object> getForecast(City city) throws HttpClientErrorException {
        try {
            Object objects = restTemplate.getForObject(GET_FORECAST_URI, Object.class, city.getName(), API_KEY);
            return Arrays.asList(objects);
        } catch (HttpClientErrorException exception) {
            if (exception.getStatusCode().equals(HttpStatus.NOT_FOUND))
                throw new RuntimeException("Invalid city name");
            else
                throw new RuntimeException("Invalid request");
        }
    }
}
