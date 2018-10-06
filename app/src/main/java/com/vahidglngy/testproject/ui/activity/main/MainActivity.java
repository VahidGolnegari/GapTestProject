package com.vahidglngy.testproject.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.vahidglngy.testproject.R;
import com.vahidglngy.testproject.ui.base.BaseActivity;
import com.vahidglngy.testproject.ui.fragment.first.FirstFragment;
import com.vahidglngy.testproject.ui.fragment.second.SecondFragment;
import com.vahidglngy.testproject.utl.EventBus.FirstFragmentEvent;
import com.vahidglngy.testproject.utl.EventBus.SecondFragmenteEventModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainView {

    public static Intent showActivity(Context context) {
        return new Intent(context,MainActivity.class);
    }

    @BindView(R.id.framelayout_main_fragmentcontainer)
    FrameLayout mFragmentContainer;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    IMainPresenter<IMainView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            getActivityComponent().inject(this);

            EventBus.getDefault().register(this);

            presenter.attachView(this);

            setUpViews();


    }

    @Override
    protected void onDestroy() {

        presenter.detachView();

        EventBus.getDefault().unregister(this);

        super.onDestroy();
    }

    @Override
    public void setUpViews() {

        setUnbinder(ButterKnife.bind(this));

        presenter.initalView();

    }

    @Override
    public void showFirstFragment() {
        FirstFragment firstFragment = FirstFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_main_fragmentcontainer,firstFragment,FirstFragment.TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void showSecondFragment() {
        SecondFragment secondFragment = SecondFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_main_fragmentcontainer,secondFragment,SecondFragment.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Subscribe
    public void onSecondFragment(SecondFragmenteEventModel event) {
        Log.d("backToFirstFragment","back");
        fragmentManager.popBackStackImmediate();
    }

    @Subscribe
    public void onFirstFragmentEvent(FirstFragmentEvent event) {
        showSecondFragment();
    }

}
