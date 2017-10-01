package com.example.android.paysa.presentation.ui;

/**
 * Created by S_Husnain on 2017-09-30.
 */

/**
 * Represents a basic view. All views should implement these common methods
 */

public interface BaseView {


    /**
     * Shows progress during background task
     */

    void showProgress();

    /**
     * Hides progress information after background task finishes
     */

    void hideProgress();

    /**
     * Shows error messages on the UI
     *
     * @param message
     */

    void showError(String message);
}
