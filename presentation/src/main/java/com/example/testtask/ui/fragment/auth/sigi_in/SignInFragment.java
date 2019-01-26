package com.example.testtask.ui.fragment.auth.sigi_in;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testtask.R;

import io.reactivex.android.schedulers.AndroidSchedulers;


public class SignInFragment extends MvpAppCompatFragment implements SignInView {
    @InjectPresenter
    SignInPresenter presenter;


    public static SignInFragment newInstance() {
        return new SignInFragment();
    }

    public SignInFragment() {
    }

    @ProvidePresenter
    SignInPresenter providePresenter() {
        SignInPresenter signInPresenter = new SignInPresenter(AndroidSchedulers.mainThread());

        return signInPresenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }
}
