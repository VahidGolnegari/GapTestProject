package com.vahidglngy.testproject.ui.fragment.first;

import com.vahidglngy.testproject.di.scope.FragmentScope;
import com.vahidglngy.testproject.ui.base.IBasePresenterContract;

/**
 * Created by vahidglngy on 10/6/18.
 */
@FragmentScope
public interface IFirstFragmentPresenter<V extends IFirstFragmentView> extends IBasePresenterContract<V> {

    void checkYahooHost(String url);

    void selectRandomIamge();

    void showDefaultUrl();

}
