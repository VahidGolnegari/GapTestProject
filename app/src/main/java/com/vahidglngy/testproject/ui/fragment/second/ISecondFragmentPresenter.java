package com.vahidglngy.testproject.ui.fragment.second;

import com.vahidglngy.testproject.ui.base.IBasePresenterContract;

/**
 * Created by vahidglngy on 10/6/18.
 */

public interface ISecondFragmentPresenter<V extends ISecondFragmentView> extends IBasePresenterContract<V> {

    void createRandomNumbers();
}
