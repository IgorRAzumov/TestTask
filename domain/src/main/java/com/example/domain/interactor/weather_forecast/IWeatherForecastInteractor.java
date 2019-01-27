package com.example.domain.interactor.weather_forecast;

import com.example.domain.model.weather.WeatherForecast;

import io.reactivex.Single;

public interface IWeatherForecastInteractor {

    Single<WeatherForecast> getWeatherByLatLang(String latitude, String longitude);

}
