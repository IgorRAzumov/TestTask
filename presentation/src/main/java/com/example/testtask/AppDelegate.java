package com.example.testtask;

import android.app.Application;

import com.example.testtask.di.AppComponent;
import com.example.testtask.di.DaggerAppComponent;


public class AppDelegate extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
