package com.example.data.repository;

import com.example.domain.model.auth.Token;
import com.example.domain.repository.IAuthRepository;

import io.reactivex.Single;


public class AuthRepository implements IAuthRepository {
    private static String DUMMY_TOKEN_STRING = "ssfsdfergdy565r33rsw3343res";


    @Override
    public Single<Token> signIn() {
        return Single.fromCallable(()-> new Token(DUMMY_TOKEN_STRING));
    }
}
