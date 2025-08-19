package com.example.__Weather_Project.controller;

import com.example.__Weather_Project.dto.ForecastResponse;
import com.example.__Weather_Project.dto.WeatherResponse;
import com.example.__Weather_Project.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/my/{city}")
    public WeatherResponse getWeatherData(@PathVariable String city){
        return weatherService.getWeatherData(city);
    }

    @GetMapping("/forecast")
    public ForecastResponse getForecast(@RequestParam String city, @RequestParam int days){
        return weatherService.getWeatherForecast(city,days);
    }
}
