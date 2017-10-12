package com.example.android.paysa.presentation.ui.activities;

import android.app.DialogFragment;
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
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.presentation.presenters.CreateJobPresenter;
import com.example.android.paysa.presentation.presenters.impl.CreateJobPresenterImpl;
import com.example.android.paysa.presentation.ui.fragments.DatePickerFragment;
import com.example.android.paysa.presentation.ui.fragments.TimePickerFragment;
import com.example.android.paysa.threading.MainThreadImpl;

import java.util.List;

public class CreateJobActivity extends AppCompatActivity implements CreateJobPresenter.CreateJobView {

    private TextInputLayout mJobTitleInputLayout;

    private TextView mStartDateTextView, mStartTimeTextView, mEndDateTextView, mEndTimeTextView;

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

        mPresenter = new CreateJobPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this);

        mStartDateTextView.setText(mPresenter.getStartDate());

        mStartTimeTextView.setText(mPresenter.getStartTime());
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
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }
}
