package com.example.android.paysa.presentation.ui.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by S_Husnain on 2017-10-11.
 */

public class TimePickerFragment extends DialogFragment
                                implements TimePickerDialog.OnTimeSetListener{

    private TimePickerFragmentListener mListener;

    private int mId;

    public static TimePickerFragment newInstance(int id, TimePickerFragmentListener listener){
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setListener(listener);
        fragment.setFragmentId(id);
        return  fragment;
    }

    public interface TimePickerFragmentListener{
        void onTimeSet(int id, int hour, int minute);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        notifyTimePickerListener(hour, minute);
    }

    public TimePickerFragmentListener getListener(){
        return mListener;
    }

    public void setListener(TimePickerFragmentListener listener){
        mListener = listener;
    }

    public int getFragmentId(){
        return mId;
    }

    public void setFragmentId(int id){
        mId = id;
    }

    protected void notifyTimePickerListener(int hour, int minute){
        if(mListener != null){
            mListener.onTimeSet(mId, hour, minute);
        }
    }
}
