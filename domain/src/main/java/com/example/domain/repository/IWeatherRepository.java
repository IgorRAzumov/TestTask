package com.example.domain.repository;

import com.example.domain.model.weather.WeatherForecast;

import io.reactivex.Single;

public interface IWeatherRepository {
    Single<WeatherForecast> getWeatherByLatLang(String latitude, String longitude,  String language,
                                                boolean hours);
}
