package com.example.testtask.di;

import com.example.testtask.ui.fragment.auth.sign_in.SignInPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, RepositoryModule.class,
        InteractorModule.class})
public interface AppComponent {

    void inject(SignInPresenter presenter);

}