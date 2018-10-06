package com.vahidglngy.testproject.ui.fragment.first;

import android.net.Uri;
import android.util.Log;

import com.vahidglngy.testproject.ui.base.BasePresenterImpl;
import com.vahidglngy.testproject.utl.rxjava.SchedulerProvider;

import java.util.Random;

import javax.inject.Inject;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class FirstFragmentPresenterImpl<V extends IFirstFragmentView> extends BasePresenterImpl<V>
        implements IFirstFragmentPresenter<V>  {

    private final String[] imageLinks = {
            "https://vignette.wikia.nocookie.net/undertale-au/images/5/54/Link.jpg/revision/latest?cb=20170903211129",
            "https://vignette.wikia.nocookie.net/walkingdead/images/5/54/Link.jpg/revision/latest?cb=20140613144939",
            "https://vignette.wikia.nocookie.net/dynastywarriors/images/6/60/Link_-_HW.png/revision/latest?cb=20140526003852",
            "https://vignette.wikia.nocookie.net/undertale-au/images/5/54/Link.jpg/revision/latest?cb=20170903211129"
    };


    @Inject
    public FirstFragmentPresenterImpl(SchedulerProvider schedulerProvider){
        super(schedulerProvider);
    };

    @Override
    public void initalView() {
        super.initalView();

        getMvpView().initialWEbView();

    }


    @Override
    public void checkYahooHost(String url) {

        Uri uri = Uri.parse(url);

        Log.d("urlHoat",uri.getHost()+" ");

        if (uri.getHost().equals("www.yahoo.com")) {
            Log.d("hostis","yahoo");
            getMvpView().gotoSecondFragment();
        }

    }

    @Override
    public void selectRandomIamge() {
        int random = new Random().nextInt(this.imageLinks.length);
        getMvpView().showRandomImage(imageLinks[random]);
    }

    @Override
    public void showDefaultUrl() {
        getMvpView().loadUrl("http://www.google.com");

    }

}
