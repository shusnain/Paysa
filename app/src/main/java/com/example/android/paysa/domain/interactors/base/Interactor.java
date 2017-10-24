package com.example.android.paysa.domain.interactors.base;

/**
 * Created by S_Husnain on 2017-09-30.
 */

/**
 * This is the home interface of an interactor. Each interactor serves a specific use case.
 */
public interface Interactor {

    /**
     * This is the home method that starts an interactor. It will make sure that the interactor operation is done on a
     * background thread.
     */
    void execute();
}
