package com.example.domain.interactor.sign_in;

import com.example.domain.model.error.InvalidAuthDataException;

import io.reactivex.Completable;

public class SignInInteractor implements ISignInInteractor {
    private static final int DUMMY_DELAY_TIME = 300;
    private String password;
    private String login;

    @Override
    public Completable signIn() {
        return Completable.fromAction(() -> {
            if (login == null || password == null) {
                throw new InvalidAuthDataException();
            }
            Thread.sleep(DUMMY_DELAY_TIME);
        });
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void clearLogin() {
        if (login != null) {
            login = null;
        }
    }

    @Override
    public void clearPassword() {
        if (password != null) {
            password = null;
        }
    }
}
