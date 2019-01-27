package com.example.domain.interactor.date_validate;

import io.reactivex.Single;

public interface IDataValidatorInteractor {
    Single<Boolean> checkEmail(String email);

    Single<Boolean> checkAuthPassword(String password);
}
