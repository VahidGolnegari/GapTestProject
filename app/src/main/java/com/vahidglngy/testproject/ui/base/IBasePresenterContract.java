package com.vahidglngy.testproject.ui.base;

/**
 * Created by vahidglngy on 10/6/18.
 */

public interface IBasePresenterContract<V extends IBaseContractView> {

    void attachView(V view);

    void detachView();

    void initalView();




}
