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

    private Calendar getNearestHourCalendar(){
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.HOUR_OF_DAY, 1);

        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar;
    }

    @Override
    public String getStartDate() {
        DateFormat df = new SimpleDateFormat("EEE, MMM dd, yyyy");

        Date today = getNearestHourCalendar().getTime();

        return df.format(today);
    }

    @Override
    public String getStartTime() {
        DateFormat df = new SimpleDateFormat("hh:mm a");

        Date today = getNearestHourCalendar().getTime();

        return df.format(today);
    }

    @Override
    public String getEndDate() {
        DateFormat df = new SimpleDateFormat("EEE, MMM dd, yyyy");

        Calendar calendar = getNearestHourCalendar();

        calendar.add(Calendar.HOUR_OF_DAY, 8);

        Date date = calendar.getTime();

        return df.format(date);
    }

    @Override
    public String getEndTime() {
        DateFormat df = new SimpleDateFormat("hh:mm a");

        Calendar calendar = getNearestHourCalendar();

        calendar.add(Calendar.HOUR_OF_DAY, 8);

        Date date = calendar.getTime();

        return df.format(date);
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

    @Override
    public String[] getWageTime() {
        return new String[]{"Hourly", "Monthly", "Yearly"};
    }
}
