package com.vahidglngy.testproject.di.module;

import android.support.v4.app.FragmentManager;

import com.vahidglngy.testproject.di.ActivityContext;
import com.vahidglngy.testproject.di.scope.ActivityScope;
import com.vahidglngy.testproject.ui.activity.main.IMainPresenter;
import com.vahidglngy.testproject.ui.activity.main.IMainView;
import com.vahidglngy.testproject.ui.activity.main.MainPresenterImpl;
import com.vahidglngy.testproject.ui.activity.spalsh.ISpalshPresenter;
import com.vahidglngy.testproject.ui.activity.spalsh.ISplashView;
import com.vahidglngy.testproject.ui.activity.spalsh.SplashPresenterImpl;
import com.vahidglngy.testproject.ui.base.BaseActivity;
import com.vahidglngy.testproject.utl.rxjava.AppSchedulerProvider;
import com.vahidglngy.testproject.utl.rxjava.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vahidglngy on 10/6/18.
 */
@Module
public class ActivityModule {

    private BaseActivity activity;

    public ActivityModule(BaseActivity baseActivity) {
        this.activity = baseActivity;
    }

    @Provides
    public SchedulerProvider provideScheduler(){
        return new AppSchedulerProvider();
    }

    @ActivityContext
    @Provides
    public BaseActivity provodeAvcivityContext(){
        return activity;
    }

    @Provides
    public FragmentManager provideFragmentManager() {
        return this.activity.getSupportFragmentManager();
    }

    @ActivityScope
    @Provides
    public IMainPresenter<IMainView> provideMainMvpPresenter(MainPresenterImpl<IMainView> presenter){
        return presenter;
    }

    @ActivityScope
    @Provides
    public ISpalshPresenter<ISplashView> provideSplashPresenter(SplashPresenterImpl<ISplashView> presenter){
        return presenter;
    }
}


