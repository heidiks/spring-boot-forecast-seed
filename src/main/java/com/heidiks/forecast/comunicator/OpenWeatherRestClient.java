package com.heidiks.forecast.comunicator;

import com.heidiks.forecast.model.City;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by heidi on 17/05/2017.
 */
@Component
@Configurable
public class OpenWeatherRestClient {

    @Value("${openweather.api.key}")
    private String API_KEY;

    private static final String GET_FORECAST_URI = "http://api.openweathermap.org/data/2.5/forecast?q={cityName}&mode=json&appid={apiKey}";

    public String getForecast(City city) throws HttpClientErrorException {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(GET_FORECAST_URI, String.class, city.getName(), API_KEY);
        } catch (HttpClientErrorException exception) {
            if (exception.getStatusCode().equals(HttpStatus.NOT_FOUND))
                throw new RuntimeException("Invalid city name");
            else
                throw new RuntimeException("Invalid request");
        }
    }
}
