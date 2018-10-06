package com.vahidglngy.testproject.ui.base;

import com.vahidglngy.testproject.utl.rxjava.SchedulerProvider;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class BasePresenterImpl<V extends IBaseContractView> implements IBasePresenterContract<V> {

    private V mvpView;
    private SchedulerProvider schedulerProvider;

    private boolean isViewInitial;

    public BasePresenterImpl(SchedulerProvider schedulerProvider){
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public void attachView(V view) {
        this.mvpView = view;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    @Override
    public void initalView() {
        isViewInitial = true;

    }

    public V getMvpView(){
        return mvpView;
    }

    public boolean isViewInitial() {
        return isViewInitial;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

}
