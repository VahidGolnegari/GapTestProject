package com.vahidglngy.testproject.ui.fragment.first;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vahidglngy.testproject.R;
import com.vahidglngy.testproject.ui.base.BaseFragment;
import com.vahidglngy.testproject.utl.EventBus.FirstFragmentEvent;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class FirstFragment extends BaseFragment implements IFirstFragmentView {

    public static final String TAG = FirstFragment.class.getSimpleName();

    public static FirstFragment newInstance(){
        return new FirstFragment();
    }

    @BindView(R.id.webview_firstfargment_showwebpages)
    WebView mWebView;

    @BindView(R.id.imageview_firstfragment_showrandomimages)
    ImageView mImageView;

    @Inject
    IFirstFragmentPresenter<IFirstFragmentView> presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            getFragmentComponent().inject(this);

            presenter.attachView(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (isNetworkAvailable()) {

            presenter.showDefaultUrl();

            presenter.selectRandomIamge();

        }

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroy() {

        presenter.detachView();

        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first,container,false);
    }

    @Override
    public void setUpViews(View views) {

        setUpUnbinder(ButterKnife.bind(this,views));

        presenter.initalView();
    }


    @Override
    public void initialWEbView() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.setWebViewClient(new MyClientWebView());
        mWebView.getSettings().setAppCacheEnabled(true);
    }

    @Override
    public void showRandomImage(String url) {
        Glide.with(getContext()).load(url).into(mImageView);
    }

    @Override
    public void gotoSecondFragment() {
        EventBus.getDefault().post(new FirstFragmentEvent(true));
    }

    @Override
    public void loadUrl(String url) {
        mWebView.loadUrl(url);

    }

    private class MyClientWebView extends WebViewClient {

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);

            presenter.checkYahooHost(url);
        }
    }
}
