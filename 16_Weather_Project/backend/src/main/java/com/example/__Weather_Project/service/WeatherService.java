package com.example.__Weather_Project.service;

import com.example.__Weather_Project.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.forecast.url}")
    private String forecastUrl;

    private RestTemplate template = new RestTemplate();

    public WeatherResponse getWeatherData(String city){
        String url = apiUrl+"?key="+apiKey+"&q="+city;
        Root response = template.getForObject(url, Root.class);
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCity(response.getLocation().getName());
        weatherResponse.setCountry(response.getLocation().getCountry());
        weatherResponse.setRegion(response.getLocation().getRegion());
        weatherResponse.setCondition(response.getCurrent().getCondition().getText());
        weatherResponse.setTemperature(response.getCurrent().getTemp_c());

        return weatherResponse;
    }


    public ForecastResponse getWeatherForecast(String city, int days){

        ForecastResponse forecast = new ForecastResponse();

        WeatherResponse weatherResponse = getWeatherData(city);
        forecast.setWeatherResponse(weatherResponse);

        String url = forecastUrl+"?key="+apiKey+"&q="+city+"&days="+days;
        Root response = template.getForObject(url,Root.class);

        Forecast forecast1 = response.getForecast();
        ArrayList<Forecastday> forecastday = forecast1.getForecastday();

        List<DayTemp> dayTempList = new ArrayList<>();

        for(Forecastday day:forecastday){
            DayTemp dayTemp = new DayTemp();

            dayTemp.setDate(day.getDate());
            dayTemp.setMinTemp(day.getDay().getMintemp_c());
            dayTemp.setMaxTemp(day.getDay().getMaxtemp_c());
            dayTemp.setAvgTemp(day.getDay().getAvgtemp_c());

            dayTempList.add(dayTemp);
        }

        forecast.setDayTemp(dayTempList);

        return forecast;
    }
}
