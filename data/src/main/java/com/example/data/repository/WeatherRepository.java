package com.example.data.repository;


import com.example.data.api.WeatherApi;
import com.example.domain.model.auth.Token;
import com.example.domain.repository.IWeatherRepository;

import javax.inject.Inject;

public class WeatherRepository implements IWeatherRepository {
    private final WeatherApi weatherApi;


    public WeatherRepository(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }
}
