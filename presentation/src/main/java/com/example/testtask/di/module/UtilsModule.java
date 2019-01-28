package com.example.testtask.di.module;

import com.example.domain.interactor.date_validate.DataValidatorInteractor;
import com.example.domain.interactor.date_validate.IDataValidatorInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Provides
    @Singleton
    public IDataValidatorInteractor dataValidateInteractor() {
        return new DataValidatorInteractor();
    }


}
