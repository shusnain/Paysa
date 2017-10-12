package com.example.android.paysa.presentation.ui.fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by S_Husnain on 2017-10-11.
 */

public class DatePickerFragment extends DialogFragment
                                implements DatePickerDialog.OnDateSetListener{

    private DatePickerFragmentListener mListener;

    private int mId;

    public static DatePickerFragment newInstance(int id, DatePickerFragmentListener listener){
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setListener(listener);
        fragment.setFragmentId(id);
        return fragment;
    }

    public interface DatePickerFragmentListener{
        void onDateSet(int id, int year, int month, int day);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        notifyDatePickerListener(year, month, day);
    }

    public DatePickerFragmentListener getListner(){
        return mListener;
    }

    public void setListener(DatePickerFragmentListener listener){
        mListener = listener;
    }

    public int getFragmentId(){
        return mId;
    }

    public void setFragmentId(int id){
        mId = id;
    }

    protected void notifyDatePickerListener(int year, int month, int day){
        if(mListener != null){
            mListener.onDateSet(mId, year, month, day);
        }
    }
}
