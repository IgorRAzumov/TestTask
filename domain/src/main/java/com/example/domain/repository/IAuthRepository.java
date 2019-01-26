package com.example.domain.repository;

import com.example.domain.model.auth.Token;

import io.reactivex.Single;


public interface IAuthRepository {
    Single<Token> signIn();
}
