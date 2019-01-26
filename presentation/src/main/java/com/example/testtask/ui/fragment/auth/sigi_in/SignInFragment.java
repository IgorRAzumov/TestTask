package com.example.testtask.ui.fragment.auth.sigi_in;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testtask.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class SignInFragment extends MvpAppCompatFragment implements SignInView {
    @BindView(R.id.tb_fr_sign_in)
    Toolbar toolbar;

    @BindView(R.id.til_fr_sign_in_login)
    TextInputLayout loginInputLayout;
    @BindView(R.id.tet_fr_sign_in_login)
    TextInputEditText loginEditText;

    @BindView(R.id.til_fr_sign_in_password)
    TextInputLayout passwordLayout;
    @BindView(R.id.tet_fr_sign_in_password)
    TextInputEditText passwordEditText;
    @BindView(R.id.abt_fr_sign_in_sign_in)
    AppCompatButton signInButton;

    @InjectPresenter
    SignInPresenter presenter;
    private Unbinder unbinder;


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
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void initUi() {

    }
}
