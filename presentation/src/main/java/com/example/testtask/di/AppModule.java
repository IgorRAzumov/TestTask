package com.example.testtask.di;


import com.example.testtask.AppDelegate;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final AppDelegate mApp;

    public AppModule(AppDelegate mApp) {
        this.mApp = mApp;
    }

    @Provides
    @Singleton
    AppDelegate provideApp() {
        return mApp;
    }

}
