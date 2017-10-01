package com.example.android.paysa.presentation.presenters.base;

/**
 * Created by S_Husnain on 2017-09-30.
 */

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;

/**
 * This is a base class for all presenters which are communicating with interactors. This base class will hold a
 * reference to the Executor and MainThread objects that are needed for running interactors in a background thread.
 */
public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
