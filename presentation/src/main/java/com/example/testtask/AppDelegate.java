package com.example.testtask;

import android.app.Application;

import com.example.testtask.di.component.AppComponent;
import com.example.testtask.di.component.DaggerAppComponent;

import timber.log.Timber;


public class AppDelegate extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
