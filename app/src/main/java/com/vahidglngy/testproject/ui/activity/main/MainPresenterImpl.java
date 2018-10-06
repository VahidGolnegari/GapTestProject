package com.vahidglngy.testproject.ui.activity.main;

import com.vahidglngy.testproject.ui.base.BasePresenterImpl;
import com.vahidglngy.testproject.utl.rxjava.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class MainPresenterImpl<V extends IMainView> extends BasePresenterImpl<V>
        implements IMainPresenter<V> {

    @Inject
    MainPresenterImpl(SchedulerProvider schedulerProvider){
        super(schedulerProvider);
    }

    @Override
    public void initalView() {
        super.initalView();
        getMvpView().showFirstFragment();
    }
}
