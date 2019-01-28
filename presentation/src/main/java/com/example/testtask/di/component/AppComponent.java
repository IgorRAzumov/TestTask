package com.example.testtask.di.component;


import com.example.testtask.di.module.AuthModule;
import com.example.testtask.di.module.NetworkModule;
import com.example.testtask.di.module.RepositoryModule;
import com.example.testtask.di.module.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, RepositoryModule.class,
        UtilsModule.class})
public interface AppComponent {
    AuthComponent getAuthComponent(AuthModule authModule);
}