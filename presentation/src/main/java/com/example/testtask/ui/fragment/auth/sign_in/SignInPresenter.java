package com.example.testtask.ui.fragment.auth.sign_in;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.domain.interactor.date_validate.IDataValidatorInteractor;
import com.example.domain.interactor.sign_in.ISignInInteractor;
import com.example.domain.interactor.weather_forecast.IWeatherForecastInteractor;
import com.example.domain.model.error.InvalidAuthDataException;
import com.example.domain.model.weather.WeatherForecast;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

@InjectViewState
public class SignInPresenter extends MvpPresenter<SignInView> {
    private static final String DUMMY_LATITUDE = "55.75396";
    private static final String DUMMY_LONGITUDE = "37.620393";
    private static final String DUMMY_CITY = "Москва";
    private static final String DUMMY_FORECAST_TEMPLATE = "Погода в городе %s: температура -  %d, ощущается -  %d, влажность - %d,давление - %d мм.рт.ст..";


    @Inject
    public IDataValidatorInteractor dataValidatorInteractor;
    @Inject
    public ISignInInteractor signInInteractor;
    @Inject
    public IWeatherForecastInteractor weatherForecastInteractor;

    private final Scheduler scheduler;
    private final CompositeDisposable compositeDisposable;
    private final AtomicBoolean loginError;
    private final AtomicBoolean passwordError;

    SignInPresenter(Scheduler mainThread) {
        this.scheduler = mainThread;
        compositeDisposable = new CompositeDisposable();
        loginError = new AtomicBoolean();
        passwordError = new AtomicBoolean();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initUi();
    }

    void loginTextFocusChanged(boolean hasFocus) {
        if (hasFocus && loginError.get()) {
            getViewState().hideLoginError();
            loginError.set(false);
        }
    }

    void passwordTextFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            if (passwordError.get()) {
                getViewState().hidePasswordError();
                passwordError.set(false);
            }
            getViewState().showActivePasswordImage();
        } else {
            if (!passwordError.get()) {
                getViewState().showDefaultPasswordImage();
            }
        }
    }

    void loginTextChanged(String login) {
        compositeDisposable.add(
                dataValidatorInteractor
                        .checkEmail(login)
                        .subscribeOn(Schedulers.io())
                        .observeOn(scheduler)
                        .subscribe(valid -> loginCheckCompleted(valid, login)));
    }

    void passwordTextChanged(String password) {
        compositeDisposable.add(
                dataValidatorInteractor
                        .checkAuthPassword(password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(scheduler)
                        .subscribe(valid -> passwordCheckCompleted(valid, password)));
    }

    void signInButtonClick(String login, String password) {
        compositeDisposable.add(
                dataValidatorInteractor
                        .checkEmail(login)
                        .subscribeOn(Schedulers.io())
                        .observeOn(scheduler)
                        .doOnSuccess(isValid -> loginCheckCompleted(isValid, login))
                        .observeOn(Schedulers.io())
                        .flatMap(isValid -> dataValidatorInteractor.checkAuthPassword(password))
                        .observeOn(scheduler)
                        .doOnSuccess(isValid -> passwordCheckCompleted(isValid, password))
                        .filter(isValid -> !loginError.get() && !passwordError.get())
                        .observeOn(Schedulers.io())
                        .flatMapSingle(isValid -> weatherForecastInteractor.getWeatherByLatLang(DUMMY_LATITUDE,
                                DUMMY_LONGITUDE))
                        .observeOn(scheduler)
                        .subscribe(weatherForecast -> getViewState()
                                        .showWeatherForecast(createForecastString(weatherForecast))
                                , throwable -> {
                                    Timber.e(throwable);
                                    if (throwable instanceof InvalidAuthDataException) {
                                        getViewState().showInvalidSignInDataMessage();
                                    } else {
                                        getViewState().showErrorLoadWeatherMessage();
                                    }
                                }));
    }

    void onBackButtonClick() {
        getViewState().onBackButtonClick();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    private void loginCheckCompleted(boolean valid, String login) {
        if (valid) {
            loginValid();
            signInInteractor.setLogin(login);
        } else {
            loginInvalid();
            signInInteractor.clearLogin();
        }
    }

    private void loginInvalid() {
        if (!loginError.get()) {
            getViewState().showLoginError();
            loginError.set(true);
        }
    }

    private void loginValid() {
        if (loginError.get()) {
            getViewState().hideLoginError();
            loginError.set(false);
        }
    }

    private void passwordCheckCompleted(boolean valid, String password) {
        if (valid) {
            passwordValid();
            signInInteractor.setPassword(password);
        } else {
            passwordInvalid();
            signInInteractor.clearPassword();
        }
    }

    private void passwordInvalid() {
        if (!passwordError.get()) {
            getViewState().showPasswordError();
            getViewState().showErrorPasswordImage();
            passwordError.set(true);
        }
    }

    private void passwordValid() {
        if (passwordError.get()) {
            getViewState().hidePasswordError();
            getViewState().hideErrorPasswordImage();
            passwordError.set(false);
        }
    }

    private String createForecastString(WeatherForecast weatherForecast) {
        return String.format(Locale.getDefault(),
                DUMMY_FORECAST_TEMPLATE,
                DUMMY_CITY, weatherForecast.getTemperature(), weatherForecast.getRealFeelTemperature(),
                weatherForecast.getHumidity(), weatherForecast.getPressure());
    }
}
