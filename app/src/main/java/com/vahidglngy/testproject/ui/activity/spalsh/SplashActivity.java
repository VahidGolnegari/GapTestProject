package com.vahidglngy.testproject.ui.activity.spalsh;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vahidglngy.testproject.R;
import com.vahidglngy.testproject.ui.activity.main.MainActivity;
import com.vahidglngy.testproject.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class SplashActivity extends BaseActivity implements ISplashView {

    @Inject
    ISpalshPresenter<ISplashView> presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        presenter.attachView(this);

        setUpViews();
    }

    @Override
    protected void onDestroy() {

        presenter.detachView();

        super.onDestroy();
    }

    @Override
    public void setUpViews() {

        setUnbinder(ButterKnife.bind(this));

        presenter.initalView();

        presenter.startTimer();

    }

    @Override
    public void gotoMainActivity() {

        startActivity(MainActivity.showActivity(this));

        finish();
    }
}
