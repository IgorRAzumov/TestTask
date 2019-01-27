package com.example.data.repository;


import com.example.data.BuildConfig;
import com.example.data.api.WeatherApi;
import com.example.data.api.model.Fact;
import com.example.data.api.model.WeatherResponse;
import com.example.domain.model.weather.WeatherForecast;
import com.example.domain.repository.IWeatherRepository;

import io.reactivex.Single;
import timber.log.Timber;

public class WeatherRepository implements IWeatherRepository {
    private final WeatherApi weatherApi;

    public WeatherRepository(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Override
    public Single<WeatherForecast> getWeatherByLatLang(String latitude, String longitude,
                                                       String language, boolean hours) {
        return weatherApi
                .getWeatherForecast(BuildConfig.YandexWeatherApiKey, latitude, longitude, language, hours)
                .map(this::mapWeatherResponseToWeatherForecast)
                .doOnError(Timber::e);
    }

    private WeatherForecast mapWeatherResponseToWeatherForecast(WeatherResponse weatherResponse) {
        Fact fact = weatherResponse.getFact();
        return WeatherForecast.Builder()
                .setTemperature(fact.getTemp())
                .setRealFeelTemperature(fact.getFeelsLike())
                .setHumidity(fact.getHumidity())
                .setPressure(fact.getPressureMm());
    }

}
