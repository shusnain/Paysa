package com.example.android.paysa.presentation.presenters.impl;

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.interactors.SampleInteractor;
import com.example.android.paysa.presentation.presenters.MainPresenter;
import com.example.android.paysa.presentation.presenters.base.AbstractPresenter;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class MainPresenterImpl extends AbstractPresenter implements MainPresenter,
        SampleInteractor.Callback {

    private MainPresenter.View mView;

    public MainPresenterImpl(Executor executor,
                             MainThread mainThread,
                             View view) {
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
}
