package com.example.android.paysa.domain.executors;

/**
 * Created by S_Husnain on 2017-09-30.
 */

/**
 * This interface will define a class that will enable interactors to run certain operations on the home (UI) thread. For example,
 * if an interactor needs to show an object to the UI this can be used to make sure the show method is called on the UI
 * thread.
 */
public interface MainThread {

    /**
     * Make runnable operation run in the home thread.
     *
     * @param runnable The runnable to run.
     */
    void post(final Runnable runnable);
}
