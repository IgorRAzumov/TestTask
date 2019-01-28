package com.example.testtask.di.module;

import com.example.data.api.WeatherApi;
import com.example.data.repository.WeatherRepository;
import com.example.domain.repository.IWeatherRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = NetworkModule.class)
public class RepositoryModule {

    @Provides
    @Singleton
    public IWeatherRepository weatherRepository(WeatherApi weatherApi) {
        return new WeatherRepository(weatherApi);
    }
}
