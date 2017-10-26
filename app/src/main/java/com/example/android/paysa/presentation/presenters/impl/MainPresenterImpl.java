package com.example.android.paysa.presentation.presenters.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.utilities.LoginUtils;
import com.example.android.paysa.presentation.presenters.MainPresenter;
import com.example.android.paysa.presentation.presenters.base.AbstractPresenter;

/**
 * Created by S_Husnain on 2017-10-24.
 */

public class MainPresenterImpl extends AbstractPresenter implements MainPresenter {

    private MainView mView;

    public MainPresenterImpl(Executor executor,
                              MainThread mainThread,
                              MainView view){
        super(executor, mainThread);
        mView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public boolean isLoggedIn(Context context){
        return LoginUtils.isLoggedIn(context);
    }
}
