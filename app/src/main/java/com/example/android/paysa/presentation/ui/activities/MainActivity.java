package com.example.android.paysa.presentation.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.executors.impl.ThreadExecutor;
import com.example.android.paysa.presentation.presenters.MainPresenter;
import com.example.android.paysa.presentation.presenters.impl.MainPresenterImpl;
import com.example.android.paysa.threading.MainThreadImpl;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView {

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this);

        startup();
    }

    private void startup(){
        boolean isLoggedIn = mPresenter.isLoggedIn(this);
        if(isLoggedIn){
            Intent startHomeActivity = new Intent(this, NavigationActivity.class);
            startActivity(startHomeActivity);
        }else{
            Intent startLoginActivity = new Intent(this, LoginActivity.class);
            startActivity(startLoginActivity);
        }
        finish();
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
