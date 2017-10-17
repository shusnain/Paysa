package com.example.android.paysa.presentation.presenters.impl;

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.interactors.SampleInteractor;
import com.example.android.paysa.presentation.presenters.CreateUserProfilePresenter;
import com.example.android.paysa.presentation.presenters.base.AbstractPresenter;

/**
 * Created by S_Husnain on 2017-10-17.
 */

public class CreateUserProfilePresenterImpl extends AbstractPresenter
                        implements CreateUserProfilePresenter,
                                    SampleInteractor.Callback{

    private CreateUserProfilePresenter.CreateUserProfileView mView;

    public CreateUserProfilePresenterImpl(Executor executor,
                                  MainThread mainThread,
                                  CreateUserProfileView view){
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
