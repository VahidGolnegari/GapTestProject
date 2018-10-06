package com.vahidglngy.testproject.ui.fragment.second;

import android.util.Log;

import com.vahidglngy.testproject.ui.activity.spalsh.ISpalshPresenter;
import com.vahidglngy.testproject.ui.base.BasePresenterImpl;
import com.vahidglngy.testproject.utl.rxjava.SchedulerProvider;

import java.util.ArrayList;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class SecondFragmentPresenterImpl<V extends ISecondFragmentView>
        extends BasePresenterImpl<V> implements ISecondFragmentPresenter<V> {

    private Random ra;

    private ArrayList<String> randomItems = new ArrayList<>();

    @Inject
    public SecondFragmentPresenterImpl(SchedulerProvider schedulerProvider){
        super(schedulerProvider);
    }

    @Override
    public void initalView() {
        super.initalView();

        getMvpView().initaiRandomAdapter(randomItems);


    }

    @Override
    public void createRandomNumbers() {
        getObservale()
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return getnumber(aLong);
                    }
                })
                .observeOn(getSchedulerProvider().Ui())
                .subscribeOn(getSchedulerProvider().Io())
                .subscribe(getObserver());
    }

    private Observable<Long> getObservale() {
        return Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                if (!emitter.isDisposed()){
                    for (int i  = 0 ; i < 100 ; i++) {
                        emitter.onNext(getRandomValue());
                    }
                    emitter.onComplete();
                }

            }
        });
    }

    private Observer<String> getObserver(){
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d("onNext",s+" ");
                randomItems.add(s);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                getMvpView().notifyRandomAdapter();

            }
        };
    }

    private Long getRandomValue(){
        Random ra = new Random();
        long n = (long) (1000000000000000000L + ra.nextFloat() * 9000000000000000000L);
        return n;
    }

    private String getnumber(long number){
        String s = String.valueOf(number);
        char[] digits = s.toCharArray();
        int size = digits.length;
        int firstNumbr;
        int secNumber;
        StringBuilder stringBuilder = new StringBuilder();
        firstNumbr = Character.getNumericValue(digits[0]);
        secNumber = Character.getNumericValue(digits[1]);
        stringBuilder.append(Character.getNumericValue(digits[0]));
        if (firstNumbr == secNumber){
            stringBuilder.append(String.valueOf(secNumber));
        } else {
            stringBuilder.append(",");
            stringBuilder.append(String.valueOf(secNumber));
        }

        for (int index = 2 ; index < size ; index++){
            if (secNumber == Character.getNumericValue(digits[index])) {
                stringBuilder.append(digits[index]);
                secNumber = Character.getNumericValue(digits[index]);
            } else {
                stringBuilder.append(",");
                stringBuilder.append(digits[index]);
                secNumber = Character.getNumericValue(digits[index]);
            }
        }
        return stringBuilder.toString();

    }
}
