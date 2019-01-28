package com.example.testtask.di.module;

import com.example.domain.interactor.sign_in.ISignInInteractor;
import com.example.domain.interactor.sign_in.SignInInteractor;
import com.example.domain.interactor.weather_forecast.IWeatherForecastInteractor;
import com.example.domain.interactor.weather_forecast.WeatherForecastInteractor;
import com.example.domain.repository.IWeatherRepository;
import com.example.testtask.di.scope.AuthScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthModule {
    // not good - for presentation
    @Provides
    @AuthScope
    public IWeatherForecastInteractor weatherForecastInteractor(IWeatherRepository weatherRepository) {
        return new WeatherForecastInteractor(weatherRepository);
    }

    @Provides
    @AuthScope
    public ISignInInteractor signInInteractor() {
        return new SignInInteractor();
    }
}
