package com.example.testtask.interactor;

import com.example.data.interactor.ISignInInteractor;

import io.reactivex.Completable;

public class SignInInteractor implements ISignInInteractor {
    private static final int DUMMY_DELAY_TIME = 300;

    @Override
    public Completable signIn(String login, String password) {
        return Completable.fromAction(() -> Thread.sleep(DUMMY_DELAY_TIME));
    }
}
