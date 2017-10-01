package com.example.android.paysa.domain.executors;

/**
 * Created by S_Husnain on 2017-09-30.
 */

import com.example.android.paysa.domain.interactors.base.AbstractInteractor;

/**
 * This executor is responsible for running interactors on background threads.
 *
 */
public interface Executor {

    /**
     * This method should call the interactor's run method and thus start the interactor. This should be called
     * on a background thread as interactors might do lengthy operations.
     *
     * @param interactor The interactor to run.
     */
    void execute(final AbstractInteractor interactor);
}