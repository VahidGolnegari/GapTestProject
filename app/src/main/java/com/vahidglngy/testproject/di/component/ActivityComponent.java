package com.vahidglngy.testproject.di.component;

import com.vahidglngy.testproject.di.module.ActivityModule;
import com.vahidglngy.testproject.di.scope.ActivityScope;
import com.vahidglngy.testproject.ui.activity.main.MainActivity;
import com.vahidglngy.testproject.ui.activity.spalsh.SplashActivity;
import com.vahidglngy.testproject.utl.rxjava.SchedulerProvider;

import dagger.Component;

/**
 * Created by vahidglngy on 10/6/18.
 */
@ActivityScope
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    public SchedulerProvider provideSchedulers();

    void inject(MainActivity mainActivity);

    void inject(SplashActivity splashActivity);
}
