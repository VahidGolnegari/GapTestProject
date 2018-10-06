package com.vahidglngy.testproject.ui.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.vahidglngy.testproject.R;
import com.vahidglngy.testproject.di.component.ActivityComponent;
import com.vahidglngy.testproject.di.component.DaggerActivityComponent;
import com.vahidglngy.testproject.di.module.ActivityModule;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by vahidglngy on 10/6/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseContractView {

    private Unbinder unbinder;

    private ActivityComponent activityComponent;

    private AlertDialog.Builder noInternetDailogBuilder;
    private AlertDialog noInteretDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent = DaggerActivityComponent.builder().
                activityModule(new ActivityModule(this))
                .build();

        initialNoInternetDailog();

    }

    @Override
    protected void onDestroy() {

        unbinder.unbind();

        super.onDestroy();
    }

    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public boolean isNetworkAvailable() {
        if (checkInternetConnection()) {
            return true;
        }
        noInteretDialog.show();
        return false;
    }

    private boolean checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private void initialNoInternetDailog(){
        noInternetDailogBuilder = new AlertDialog.Builder(this);
        noInternetDailogBuilder.setMessage(R.string.nointernetdialog_turnaonmessage);
        noInternetDailogBuilder.setTitle(R.string.nointerbetdialog_title);
        noInternetDailogBuilder.setPositiveButton("شبکه wifi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent wifi = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(wifi);
                noInteretDialog.dismiss();
            }
        }).setNegativeButton("شبکه دیتا", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent data = new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
                startActivity(data);
                noInteretDialog.dismiss();

            }
        }).setNeutralButton("فعلا نه", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                noInteretDialog.dismiss();

            }
        });
        noInteretDialog = noInternetDailogBuilder.create();


    }

    public abstract void setUpViews();
}
