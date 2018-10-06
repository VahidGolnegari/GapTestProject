package com.vahidglngy.testproject.di.module;

import android.content.Context;

import com.vahidglngy.testproject.di.scope.FragmentScope;
import com.vahidglngy.testproject.ui.base.BaseFragment;
import com.vahidglngy.testproject.ui.fragment.first.FirstFragmentPresenterImpl;
import com.vahidglngy.testproject.ui.fragment.first.IFirstFragmentPresenter;
import com.vahidglngy.testproject.ui.fragment.first.IFirstFragmentView;
import com.vahidglngy.testproject.ui.fragment.second.ISecondFragmentPresenter;
import com.vahidglngy.testproject.ui.fragment.second.ISecondFragmentView;
import com.vahidglngy.testproject.ui.fragment.second.SecondFragmentPresenterImpl;
import com.vahidglngy.testproject.utl.rxjava.AppSchedulerProvider;
import com.vahidglngy.testproject.utl.rxjava.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vahidglngy on 10/6/18.
 */
@Module
public class FragmentModule {

    private BaseFragment baseFragment;

    public FragmentModule(BaseFragment baseFragment){
        this.baseFragment = baseFragment;
    }



    @Provides
    @FragmentScope
    public BaseFragment provideFragment(){
        return this.baseFragment;
    }

    @Provides
    @FragmentScope
    public Context provideContext(){
        return this.baseFragment.getActivity();
    }

    @FragmentScope
    @Provides
    public IFirstFragmentPresenter<IFirstFragmentView> provideFirstMvpPresenter(FirstFragmentPresenterImpl<IFirstFragmentView> presenter){
        return presenter;
    }

    @FragmentScope
    @Provides
    public ISecondFragmentPresenter<ISecondFragmentView> provideSecondMvpPresenter(SecondFragmentPresenterImpl<ISecondFragmentView> presenter){
        return presenter;
    }


}
