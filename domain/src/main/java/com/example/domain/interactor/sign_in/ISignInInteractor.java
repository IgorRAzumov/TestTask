package com.example.domain.interactor.sign_in;

import io.reactivex.Completable;

public interface ISignInInteractor {
    Completable signIn();

    void setLogin(String login);

    void setPassword(String password);

    void clearLogin();

    void clearPassword();
}
