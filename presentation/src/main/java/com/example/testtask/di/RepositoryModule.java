package com.example.testtask.di;

import com.example.data.api.WeatherApi;
import com.example.data.repository.WeatherRepository;
import com.example.domain.repository.IWeatherRepository;

import dagger.Module;
import dagger.Provides;

@Module(includes = NetworkModule.class)
public class RepositoryModule {
    @Provides
    public IWeatherRepository weatherRepository(WeatherApi weatherApi) {
        return new WeatherRepository(weatherApi);
    }
}
