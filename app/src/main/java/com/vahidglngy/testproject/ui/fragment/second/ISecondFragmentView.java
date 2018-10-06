package com.vahidglngy.testproject.ui.fragment.second;

import com.vahidglngy.testproject.ui.base.IBaseContractView;

import java.util.ArrayList;

/**
 * Created by vahidglngy on 10/6/18.
 */

public interface ISecondFragmentView extends IBaseContractView {

    void initaiRandomAdapter(ArrayList<String> items);

    void notifyRandomAdapter();
}
