package com.vahidglngy.testproject.ui.activity.spalsh;

import com.vahidglngy.testproject.ui.base.IBasePresenterContract;

/**
 * Created by vahidglngy on 10/6/18.
 */

public interface ISpalshPresenter<V extends ISplashView> extends IBasePresenterContract<V> {

    void startTimer();
}
