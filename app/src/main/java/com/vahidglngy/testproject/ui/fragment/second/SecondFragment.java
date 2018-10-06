package com.vahidglngy.testproject.ui.fragment.second;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vahidglngy.testproject.R;
import com.vahidglngy.testproject.ui.base.BaseFragment;
import com.vahidglngy.testproject.ui.fragment.second.adapter.RndomAdapter;
import com.vahidglngy.testproject.utl.EventBus.AdapterModel;
import com.vahidglngy.testproject.utl.EventBus.SecondFragmenteEventModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class SecondFragment extends BaseFragment implements ISecondFragmentView{

    public static final String TAG = SecondFragment.class.getSimpleName();

    public static SecondFragment newInstance(){
        return new SecondFragment();
    }

    @BindView(R.id.recyclerview_seconfragment_itemlistview)
    RecyclerView mRecyclerView;

    @Inject
    ISecondFragmentPresenter<ISecondFragmentView> presenter;

    private RndomAdapter mRandomAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentComponent().inject(this);

        presenter.attachView(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {

        presenter.detachView();

        EventBus.getDefault().unregister(this);

        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second,container,false);
    }

    @Override
    public void setUpViews(View views) {

        setUpUnbinder(ButterKnife.bind(this,views));

        presenter.initalView();

        presenter.createRandomNumbers();

    }

    @Override
    public void initaiRandomAdapter(ArrayList<String> items) {
        mRandomAdapter = new RndomAdapter(items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setAdapter(mRandomAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void notifyRandomAdapter() {
        mRandomAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onAadpterEventOn(AdapterModel event) {
        Log.d("firstItemClicked",event.isFirstItemClicked() + " ");
        EventBus.getDefault().post(new SecondFragmenteEventModel());
    }
}
