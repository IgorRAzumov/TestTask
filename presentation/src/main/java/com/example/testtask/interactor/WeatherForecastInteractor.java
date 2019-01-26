package com.example.testtask.interactor;

import com.example.data.interactor.IWeatherForecastInteractor;
import com.example.domain.model.weather.WeatherForecast;
import com.example.domain.repository.IWeatherRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class WeatherForecastInteractor implements IWeatherForecastInteractor {
    @Inject
    IWeatherRepository repository;

    @Override
    public Single<WeatherForecast> getWeatherByLatLang(String latitude, String longitude) {
        return repository.getWeatherByLatLang(latitude,longitude,"ru_RU",false);
    }
}
