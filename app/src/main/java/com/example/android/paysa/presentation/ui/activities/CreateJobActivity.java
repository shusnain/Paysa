package com.example.android.paysa.presentation.ui.activities;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.executors.impl.ThreadExecutor;
import com.example.android.paysa.presentation.presenters.CreateJobPresenter;
import com.example.android.paysa.presentation.presenters.impl.CreateJobPresenterImpl;
import com.example.android.paysa.presentation.ui.fragments.DatePickerFragment;
import com.example.android.paysa.presentation.ui.fragments.TimePickerFragment;
import com.example.android.paysa.threading.MainThreadImpl;

public class CreateJobActivity extends AppCompatActivity implements CreateJobPresenter.CreateJobView,
        DatePickerFragment.DatePickerFragmentListener,
        TimePickerFragment.TimePickerFragmentListener{

    private TextInputLayout mJobTitleInputLayout;

    private TextView mStartDateTextView, mStartTimeTextView, mEndDateTextView, mEndTimeTextView;

    DatePickerFragment mStartDateFragment, mEndDateFragment;

    TimePickerFragment mStartTimeFragment, mEndTimeFragment;

    private EditText mJobTitleEditTextView;

    private CreateJobPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_job);

        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void init(){

        ActionBar actionBar = this.getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mJobTitleInputLayout = (TextInputLayout) findViewById(R.id.job_title_text_input_layout);

        mJobTitleEditTextView = (EditText) findViewById(R.id.job_title_edit_text);

        mStartDateTextView = (TextView) findViewById(R.id.start_date_text_view);

        mStartTimeTextView = (TextView) findViewById(R.id.start_time_text_view);

        mEndDateTextView = (TextView) findViewById(R.id.end_date_text_view);

        mEndTimeTextView = (TextView) findViewById(R.id.end_time_text_view);

        mPresenter = new CreateJobPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this);

        String startDate = mPresenter.getStartDate();

        String startTime = mPresenter.getStartTime();

        String endDate = mPresenter.getEndDate();

        String endTime = mPresenter.getEndTime();

        mStartDateTextView.setText(startDate);

        mStartTimeTextView.setText(startTime);

        mEndDateTextView.setText(endDate);

        mEndTimeTextView.setText(endTime);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

    public void showTimePickerDialog(View v) {
        int id = v.getId();
        if(id == R.id.start_time_text_view){
            if(mStartTimeFragment == null){
                mStartTimeFragment = TimePickerFragment.newInstance(id, this);
            }
            mStartTimeFragment.show(getFragmentManager(), "timePicker");
        }

        if(id == R.id.end_time_text_view){
            if(mEndTimeFragment == null){
                mEndTimeFragment = TimePickerFragment.newInstance(id, this);
            }
            mEndTimeFragment.show(getFragmentManager(), "timePicker");
        }

    }

    public void showDatePickerDialog(View v) {
        int id = v.getId();
        if(id == R.id.start_date_text_view){
            if(mStartDateFragment == null){
                mStartDateFragment = DatePickerFragment.newInstance(id, this);
            }

            mStartDateFragment.show(getFragmentManager(), "datePicker");
        }

        if(id == R.id.end_date_text_view){
            if(mEndDateFragment == null){
                mEndDateFragment = DatePickerFragment.newInstance(id, this);
            }

            mEndDateFragment.show(getFragmentManager(), "datePicker");
        }

    }

    @Override
    public void onDateSet(int id, int year, int month, int day) {
        String date = mPresenter.formatDate(year, month, day);
        if(id == R.id.start_date_text_view){
            mStartDateTextView.setText(date);
        }

        if(id == R.id.end_date_text_view){
            mEndDateTextView.setText(date);
        }
    }

    @Override
    public void onTimeSet(int id, int hour, int minute) {
        String time = mPresenter.formatTime(hour, minute);
        if(id == R.id.start_time_text_view){
            mStartTimeTextView.setText(time);
        }

        if(id == R.id.end_time_text_view){
            mEndTimeTextView.setText(time);
        }
    }
}
