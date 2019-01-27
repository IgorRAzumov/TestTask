package com.example.testtask.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.testtask.R;
import com.example.testtask.ui.fragment.auth.sign_in.SignInFragment;

import butterknife.BindColor;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @BindColor(R.color.white_smoke)
    int whiteSmoothColor;
    @BindColor(R.color.transparent_black_1)
    int transparentBlackColor;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showSignInFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_act_main_root_frame, SignInFragment.newInstance())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    @Override
    public void initUi() {
        setStatusBarColor();
    }

    private void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int uiFlags = getWindow().getDecorView().getSystemUiVisibility();
            uiFlags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(
                    Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                            ? whiteSmoothColor
                            : transparentBlackColor);
        }
    }
}
