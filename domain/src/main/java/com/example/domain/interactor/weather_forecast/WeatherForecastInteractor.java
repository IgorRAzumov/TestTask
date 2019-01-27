package com.example.domain.interactor.weather_forecast;

import com.example.domain.model.weather.WeatherForecast;
import com.example.domain.repository.IWeatherRepository;

import io.reactivex.Single;

public class WeatherForecastInteractor implements IWeatherForecastInteractor {
    private static final String DEFAULT_LANGUAGE_CODE = "ru_RU";
    private static final boolean DEFAULT_HOURS_FORECAST = false;

    private final IWeatherRepository repository;

    public WeatherForecastInteractor(IWeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<WeatherForecast> getWeatherByLatLang(String latitude, String longitude) {
        return repository.getWeatherByLatLang(latitude, longitude, DEFAULT_LANGUAGE_CODE,
                DEFAULT_HOURS_FORECAST);
    }
}
