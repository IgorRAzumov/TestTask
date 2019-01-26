package com.example.testtask.ui.fragment.auth.sigi_in;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.data.interactor.IDataValidatorInteractor;
import com.example.data.interactor.ISignInInteractor;

import javax.inject.Inject;

import io.reactivex.Scheduler;

@InjectViewState
public class SignInPresenter extends MvpPresenter<SignInView> {
    @Inject
    IDataValidatorInteractor dataValidatorInteractor;
    @Inject
    ISignInInteractor signInInteractor;

    private final Scheduler scheduler;

    public SignInPresenter(Scheduler mainThread) {
        this.scheduler = mainThread;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }
}
