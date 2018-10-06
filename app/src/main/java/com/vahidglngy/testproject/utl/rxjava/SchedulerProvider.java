package com.vahidglngy.testproject.utl.rxjava;

import io.reactivex.Scheduler;

/**
 * Created by vahidglngy on 10/6/18.
 */

public interface SchedulerProvider {

    public Scheduler Ui();

    public Scheduler Computation();

    public Scheduler Io();


}
