package com.example.data.interactor;

import io.reactivex.Completable;

public interface ISignInInteractor {
    Completable signIn(String login, String password);
}
