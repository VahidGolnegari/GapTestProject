package com.vahidglngy.testproject.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vahidglngy.testproject.di.component.ActivityComponent;
import com.vahidglngy.testproject.di.component.DaggerFragmentComponent;
import com.vahidglngy.testproject.di.component.FragmentComponent;
import com.vahidglngy.testproject.di.module.FragmentModule;

import butterknife.Unbinder;

/**
 * Created by vahidglngy on 10/6/18.
 */

public abstract class BaseFragment extends Fragment implements IBaseContractView {

    private Unbinder unbinder;

    private FragmentComponent fragmentComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            fragmentComponent = DaggerFragmentComponent.builder()
                    .activityComponent(getBaseActivityComponent())
                    .fragmentModule(new FragmentModule(this))
                    .build();
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("configuaraton",true);
        super.onSaveInstanceState(outState);
    }

    public FragmentComponent getFragmentComponent() {
        return fragmentComponent;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpViews(view);
    }

    @Override
    public void onDestroy() {

        unbinder.unbind();

        super.onDestroy();
    }

    private ActivityComponent getBaseActivityComponent(){
       return  ((BaseActivity)getActivity()).getActivityComponent();
    }

    private BaseActivity getBaseActivity(){
        return ((BaseActivity)getActivity());
    }

    public void setUpUnbinder(Unbinder upUnbinder){
        this.unbinder = upUnbinder;
    }

    @Override
    public boolean isNetworkAvailable() {
        return getBaseActivity().isNetworkAvailable();
    }

    public abstract void setUpViews(View views);
}
