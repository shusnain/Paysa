package com.example.android.paysa.domain.interactors.impl;

/**
 * Created by S_Husnain on 2017-09-30.
 */

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.interactors.SampleInteractor;
import com.example.android.paysa.domain.interactors.base.AbstractInteractor;
import com.example.android.paysa.domain.repository.Repository;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 *
 */
public class SampleInteractorImpl extends AbstractInteractor implements SampleInteractor {

    private SampleInteractor.Callback mCallback;
    private Repository mRepository;

    public SampleInteractorImpl(Executor threadExecutor,
                                MainThread mainThread,
                                Callback callback, Repository repository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mRepository = repository;
    }

    @Override
    public void run() {
        // TODO: Implement this with your business logic
    }
}