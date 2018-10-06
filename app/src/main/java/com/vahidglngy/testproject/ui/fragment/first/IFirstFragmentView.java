package com.vahidglngy.testproject.ui.fragment.first;

import com.vahidglngy.testproject.ui.base.IBaseContractView;

/**
 * Created by vahidglngy on 10/6/18.
 */

public interface IFirstFragmentView extends IBaseContractView {

    void initialWEbView();

    void showRandomImage(String url);

    void gotoSecondFragment();

    void loadUrl(String url);
}
