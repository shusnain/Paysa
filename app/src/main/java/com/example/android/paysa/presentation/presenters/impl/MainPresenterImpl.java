package com.example.android.paysa.presentation.presenters.impl;

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.interactors.GetJobsInteractor;
import com.example.android.paysa.domain.interactors.impl.GetJobsInteractorImpl;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.presentation.presenters.MainPresenter;
import com.example.android.paysa.presentation.presenters.base.AbstractPresenter;

import java.util.List;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class MainPresenterImpl extends AbstractPresenter implements MainPresenter,
        GetJobsInteractor.Callback {

    private MainPresenter.View mView;

    public MainPresenterImpl(Executor executor,
                             MainThread mainThread,
                             View view) {
        super(executor, mainThread);
        mView = view;
    }

    @Override
    public void resume() {
        getCards();
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
    public void getCards() {
        GetJobsInteractor getJobsInteractor = new GetJobsInteractorImpl(mExecutor, mMainThread, this, null);
        getJobsInteractor.execute();
    }

    @Override
    public void onCardsRetrieved(List<Job> cardsList) {
        mView.setCards(cardsList);
    }
}
