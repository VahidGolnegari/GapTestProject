package com.vahidglngy.testproject.utl.rxjava;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class AppSchedulerProvider implements SchedulerProvider {
    @Override
    public Scheduler Ui() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler Computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler Io() {
        return Schedulers.io();
    }
}
