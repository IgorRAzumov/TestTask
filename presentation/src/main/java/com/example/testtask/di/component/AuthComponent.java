package com.example.testtask.di.component;

import com.example.testtask.di.module.AuthModule;
import com.example.testtask.di.scope.AuthScope;
import com.example.testtask.ui.fragment.auth.sign_in.SignInPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = AuthModule.class)
@AuthScope
public interface AuthComponent {
    void inject(SignInPresenter presenter);
}
