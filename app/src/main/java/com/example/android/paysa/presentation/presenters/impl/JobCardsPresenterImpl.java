package com.example.android.paysa.presentation.presenters.impl;

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.interactors.GetJobsInteractor;
import com.example.android.paysa.domain.interactors.impl.GetJobsInteractorImpl;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.domain.utilities.CardUtil;
import com.example.android.paysa.presentation.presenters.JobCardsPresenter;
import com.example.android.paysa.presentation.presenters.base.AbstractPresenter;

import java.util.List;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class JobCardsPresenterImpl extends AbstractPresenter implements JobCardsPresenter,
        GetJobsInteractor.Callback {

    private JobCardsPresenter.HomeView mView;

    public JobCardsPresenterImpl(Executor executor,
                                 MainThread mainThread,
                                 HomeView view) {
        super(executor, mainThread);
        mView = view;
        getCards();
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
        CardUtil.CardType type = mView.getType();
        GetJobsInteractor getJobsInteractor = new GetJobsInteractorImpl(mExecutor, mMainThread, this, null, type);
        getJobsInteractor.execute();
    }

    @Override
    public void onCardsRetrieved(List<Job> cardsList) {
        mView.setCards(cardsList);
    }
}
