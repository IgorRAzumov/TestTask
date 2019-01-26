package com.example.data.interactor;

import com.example.domain.model.weather.WeatherForecast;

import io.reactivex.Single;

public interface IWeatherForecastInteractor {

    Single<WeatherForecast> getWeatherByLatLang(String latitude, String longitude);

}
