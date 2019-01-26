package com.example.data.repository;


import com.example.data.api.WeatherApi;
import com.example.data.api.model.WeatherResponse;
import com.example.domain.model.weather.WeatherForecast;
import com.example.domain.repository.IWeatherRepository;

import io.reactivex.Single;
import timber.log.Timber;

public class WeatherRepository implements IWeatherRepository {
    private final WeatherApi weatherApi;

    private String apiKey;

    public WeatherRepository(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Override
    public Single<WeatherForecast> getWeatherByLatLang( String latitude, String longitude,
                                                        String language ,boolean hours) {
        return weatherApi
                .getWeatherForecast(apiKey,latitude,longitude,language,hours)
                .map(this::mapWeatherResponseToWeatherForecast)
                .doOnError(Timber::e);
    }

    private WeatherForecast mapWeatherResponseToWeatherForecast(WeatherResponse weatherResponse) {
        return new WeatherForecast();
    }

}
