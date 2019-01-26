package com.example.testtask.ui.fragment.auth.sigi_in;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.data.interactor.IDataValidatorInteractor;
import com.example.data.interactor.ISignInInteractor;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SignInPresenter extends MvpPresenter<SignInView> {
    @Inject
    IDataValidatorInteractor dataValidatorInteractor;
    @Inject
    ISignInInteractor signInInteractor;

    private final Scheduler scheduler;
    private final CompositeDisposable compositeDisposable;

    SignInPresenter(Scheduler mainThread) {
        this.scheduler = mainThread;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initUi();
    }

     void signInButtonClick(String login, String password) {
        compositeDisposable.add(
                signInInteractor
                        .signIn(login, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(scheduler)
                        .subscribe()
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
