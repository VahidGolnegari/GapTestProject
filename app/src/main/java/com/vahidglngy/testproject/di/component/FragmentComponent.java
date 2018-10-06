package com.vahidglngy.testproject.di.component;

import com.vahidglngy.testproject.di.module.FragmentModule;
import com.vahidglngy.testproject.di.scope.FragmentScope;
import com.vahidglngy.testproject.ui.fragment.first.FirstFragment;
import com.vahidglngy.testproject.ui.fragment.second.SecondFragment;

import dagger.Component;

/**
 * Created by vahidglngy on 10/6/18.
 */
@FragmentScope
@Component (modules = FragmentModule.class , dependencies = ActivityComponent.class)
public interface FragmentComponent {

    void inject(FirstFragment firstFragment);

    void inject(SecondFragment secondFragment);
}
