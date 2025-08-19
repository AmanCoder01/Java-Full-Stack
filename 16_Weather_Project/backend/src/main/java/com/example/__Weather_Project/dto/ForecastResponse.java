package com.example.__Weather_Project.dto;

import java.util.List;

public class ForecastResponse {
    private WeatherResponse weatherResponse;

    private List<DayTemp> dayTemp;

    public ForecastResponse() {
    }

    public ForecastResponse(WeatherResponse weatherResponse, List<DayTemp> dayTemp) {
        this.weatherResponse = weatherResponse;
        this.dayTemp = dayTemp;
    }

    public WeatherResponse getWeatherResponse() {
        return weatherResponse;
    }

    public void setWeatherResponse(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }

    public List<DayTemp> getDayTemp() {
        return dayTemp;
    }

    public void setDayTemp(List<DayTemp> dayTemp) {
        this.dayTemp = dayTemp;
    }
}
