package com.example.testtask.ui.fragment.auth.sign_in;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Dimension;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testtask.AppDelegate;
import com.example.testtask.R;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.Objects;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;


public class SignInFragment extends MvpAppCompatFragment implements SignInView {
    @BindView(R.id.sv_fr_sign_in_root)
    ScrollView rootScroll;
    @BindView(R.id.tb_fr_sign_in)
    Toolbar toolbar;
    @BindView(R.id.vi_fr_sign_in_toolbar_shadow)
    View toolbarShadow;

    @BindView(R.id.til_fr_sign_in_login)
    TextInputLayout loginInputLayout;
    @BindView(R.id.tet_fr_sign_in_login)
    TextInputEditText loginEditText;

    @BindView(R.id.til_fr_sign_in_password)
    TextInputLayout passwordInputLayout;
    @BindView(R.id.tet_fr_sign_in_password)
    TextInputEditText passwordEditText;
    @BindView(R.id.abt_fr_sign_in_sign_in)
    AppCompatButton signInButton;

    @InjectPresenter
    SignInPresenter presenter;

    @BindDrawable(R.drawable.ic_password_default)
    Drawable defaultPasswordImage;
    @BindDrawable(R.drawable.ic_password_active)
    Drawable activePasswordImage;
    @BindDrawable(R.drawable.ic_password_error)
    Drawable errorPasswordImage;

    @BindColor(R.color.red_a700)
    int redAccent;

    private Unbinder unbinder;
    private CompositeDisposable compositeDisposable;

    public static SignInFragment newInstance() {
        return new SignInFragment();
    }

    public SignInFragment() {
        compositeDisposable = new CompositeDisposable();
    }

    @ProvidePresenter
    SignInPresenter providePresenter() {
        SignInPresenter signInPresenter = new SignInPresenter(AndroidSchedulers.mainThread());
        AppDelegate.getAppComponent().inject(signInPresenter);
        return signInPresenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        setHasOptionsMenu(true);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void initUi() {
        initToolbar();
        initLoginInput();
        initPasswordInput();
        initSignInButton();
    }

    @Override
    public void onBackButtonClick() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override
    public void showWeatherForecast(String weatherForecast) {
        Snackbar snackBarView = Snackbar.make(rootScroll,
                weatherForecast, Snackbar.LENGTH_LONG);
        TextView mainTextView = (snackBarView.getView()).findViewById(
                android.support.design.R.id.snackbar_text);
        mainTextView.setTextSize(Dimension.SP, getResources().getInteger(R.integer.weather_snackbar_text_size));
        mainTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        snackBarView.show();
    }

    @Override
    public void showErrorLoadWeatherMessage() {

    }

    @Override
    public void showLoginError() {
        loginInputLayout.setError(getString(R.string.error_invalid_email_hint));
    }

    @Override
    public void hideLoginError() {
        loginInputLayout.setError(null);
    }

    @Override
    public void showPasswordError() {
        passwordInputLayout.setError(getString(R.string.error_ivalid_password_hint));
    }

    @Override
    public void hidePasswordError() {
        passwordInputLayout.setError(null);
    }

    @Override
    public void showErrorPasswordImage() {
        passwordEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, errorPasswordImage, null);
    }

    @Override
    public void showActivePasswordImage() {
        passwordEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, activePasswordImage, null);
    }

    @Override
    public void showDefaultPasswordImage() {
        passwordEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, defaultPasswordImage, null);
    }

    @Override
    public void showInvalidSignInDataMessage() {
        Snackbar snackBarView = Snackbar.make(rootScroll,
                R.string.sign_in_error_data_validate, Snackbar.LENGTH_LONG);
        TextView mainTextView = (snackBarView.getView()).findViewById(
                android.support.design.R.id.snackbar_text);
        mainTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        mainTextView.setTextColor(redAccent);
        snackBarView.show();
    }

    @Override
    public void hideErrorPasswordImage() {
        passwordEditText.setCompoundDrawablesWithIntrinsicBounds(null, null,
                passwordEditText.isFocused() ? activePasswordImage : defaultPasswordImage, null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    private void initToolbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(v -> presenter.onBackButtonClick());
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            toolbarShadow.setVisibility(View.VISIBLE);
        }
    }

    private void initLoginInput() {
        compositeDisposable.add(RxView
                .focusChanges(loginEditText)
                .skipInitialValue()
                .filter(hasFocus -> loginEditText.getText() != null)
                .doOnNext(hasFocus -> presenter.loginTextFocusChanged(hasFocus))
                .filter(hasFocus -> !hasFocus)
                .forEach(hasFocus -> presenter.loginTextChanged(
                        Objects.requireNonNull(loginEditText.getText()).toString())));
    }

    private void initPasswordInput() {
        compositeDisposable.add(RxView
                .focusChanges(passwordEditText)
                .skipInitialValue()
                .filter(hasFocus -> passwordEditText.getText() != null)
                .doOnNext(hasFocus -> presenter.passwordTextFocusChanged(hasFocus))
                .filter(hasFocus -> !hasFocus)
                .forEach(hasFocus -> presenter.passwordTextChanged(
                        Objects.requireNonNull(passwordEditText.getText()).toString())));
    }

    private void initSignInButton() {
        compositeDisposable.add(RxView
                .clicks(signInButton)
                .filter(click -> loginEditText.getText() != null)
                .filter(click -> passwordEditText.getText() != null)
                .subscribe(click -> presenter.signInButtonClick(
                        Objects.requireNonNull(loginEditText.getText()).toString(),
                        Objects.requireNonNull(passwordEditText.getText()).toString())));
    }
}
