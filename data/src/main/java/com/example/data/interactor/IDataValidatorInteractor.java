package com.example.data.interactor;

import io.reactivex.Single;

public interface IDataValidatorInteractor {
    Single<Boolean> checkEmail(String email);

    Single<Boolean> checkAuthPassword(String password);
}
