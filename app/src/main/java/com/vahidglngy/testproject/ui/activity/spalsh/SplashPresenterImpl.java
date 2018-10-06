package com.vahidglngy.testproject.ui.activity.spalsh;

import android.util.Log;

import com.vahidglngy.testproject.ui.base.BasePresenterImpl;
import com.vahidglngy.testproject.utl.rxjava.SchedulerProvider;

import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class SplashPresenterImpl<V extends ISplashView> extends BasePresenterImpl<V>
        implements ISpalshPresenter<V> {

    @Inject
    public SplashPresenterImpl(SchedulerProvider schedulerProvider){
        super(schedulerProvider);
    };


    @Override
    public void startTimer() {

        Observable.timer(3,TimeUnit.SECONDS)
                .observeOn(getSchedulerProvider().Ui())
                .subscribeOn(getSchedulerProvider().Io())
                .subscribeWith(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        getMvpView().gotoMainActivity();

                    }
                });


    }
}
