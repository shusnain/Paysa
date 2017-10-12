package com.example.android.paysa.presentation.presenters.impl;

import android.view.View;

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.interactors.SampleInteractor;
import com.example.android.paysa.presentation.presenters.CreateJobPresenter;
import com.example.android.paysa.presentation.presenters.base.AbstractPresenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by S_Husnain on 2017-10-11.
 */

public class CreateJobPresenterImpl extends AbstractPresenter implements CreateJobPresenter,
        SampleInteractor.Callback{

    private CreateJobPresenter.CreateJobView mView;

    public CreateJobPresenterImpl(Executor executor,
                                  MainThread mainThread,
                                  CreateJobView view){
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

    @Override
    public String getStartDate() {
        // Create an instance of SimpleDateFormat used for formatting
// the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("EEE, MMM dd, yyyy");

// Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();

        return df.format(today);
    }

    @Override
    public String getStartTime() {
        // Create an instance of SimpleDateFormat used for formatting
// the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("hh:mm a");

// Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();
// Using DateFormat format method we can create a string
// representation of a date with the defined format.
        return df.format(today);
    }

    @Override
    public String formatDate(int year, int month, int day) {
        DateFormat df = new SimpleDateFormat("EEE, MMM dd, yyyy");
        Calendar date = new GregorianCalendar(year, month, day);
        return df.format(date.getTime());
    }

    @Override
    public String formatTime(int hour, int min) {
        DateFormat df = new SimpleDateFormat("hh:mm a");
        Calendar time = new GregorianCalendar(0, 0, 0, hour, min);
        return df.format(time.getTime());
    }
}
