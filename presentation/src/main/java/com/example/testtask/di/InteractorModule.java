package com.example.testtask.di;

import com.example.domain.interactor.date_validate.DataValidatorInteractor;
import com.example.domain.interactor.date_validate.IDataValidatorInteractor;
import com.example.domain.interactor.sign_in.ISignInInteractor;
import com.example.domain.interactor.sign_in.SignInInteractor;
import com.example.domain.interactor.weather_forecast.IWeatherForecastInteractor;
import com.example.domain.interactor.weather_forecast.WeatherForecastInteractor;
import com.example.domain.repository.IWeatherRepository;

import dagger.Module;
import dagger.Provides;

@Module(includes = RepositoryModule.class)
public class InteractorModule {
    @Provides
    public ISignInInteractor signInInteractor() {
        return new SignInInteractor();
    }

    @Provides
    public IDataValidatorInteractor dataValidateInteractor() {
        return new DataValidatorInteractor();
    }

    @Provides
    public IWeatherForecastInteractor weatherForecastInteractor(IWeatherRepository weatherRepository){
        return new WeatherForecastInteractor(weatherRepository);
    }
}
