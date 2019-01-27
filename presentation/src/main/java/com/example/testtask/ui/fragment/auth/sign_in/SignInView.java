package com.example.testtask.ui.fragment.auth.sign_in;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SignInView extends MvpView {
    void initUi();

    void onBackButtonClick();

    void showWeatherForecast(String weatherForecast);

    void showErrorLoadWeatherMessage();

    void showLoginError();

    void hideLoginError();

    void showPasswordError();

    void hidePasswordError();

    void showErrorPasswordImage();

    void showActivePasswordImage();

    void showDefaultPasswordImage();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showInvalidSignInDataMessage();

    void hideErrorPasswordImage();
}
