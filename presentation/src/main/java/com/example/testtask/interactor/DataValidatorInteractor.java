package com.example.testtask.interactor;

import com.example.data.interactor.IDataValidatorInteractor;

import java.util.regex.Pattern;

import io.reactivex.Single;

public class DataValidatorInteractor implements IDataValidatorInteractor {
    private static final String EMAIL_REGEX = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";


    @Override
    public Single<Boolean> checkEmail(String email) {
        return Single.fromCallable(() -> check(email, EMAIL_REGEX));
    }

    @Override
    public Single<Boolean> checkAuthPassword(String password) {
        return Single.fromCallable(() -> check(password, PASSWORD_REGEX));
    }

    private boolean check(String value, String regex) {
        return Pattern
                .compile(regex)
                .matcher(value)
                .matches();
    }

}
