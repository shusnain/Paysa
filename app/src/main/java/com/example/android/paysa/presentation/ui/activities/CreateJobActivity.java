package com.example.android.paysa.presentation.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    private EditText mJobTitleEditTextView, mJobDescriptionEditTextView, mWageEditTextView;

    Spinner mWageSpinner;

    private CreateJobPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_job);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.job_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }

        if(id == R.id.action_job_save){
            onBackPressed();
            Context context = getApplicationContext();
            String toastText = "Job saved";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, toastText, duration);
            toast.show();
            return true;
        }

        if(id == R.id.action_job_post){
            onBackPressed();
            Context context = getApplicationContext();
            String toastText = "Job posted";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, toastText, duration);
            toast.show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void init(){

        ActionBar actionBar = this.getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mJobTitleEditTextView = (EditText) findViewById(R.id.job_title_edit_text);

        mJobDescriptionEditTextView = (EditText) findViewById(R.id.job_description_edit_text);

        mWageEditTextView = (EditText) findViewById(R.id.wage_edit_text);

        mWageSpinner = (Spinner) findViewById(R.id.wage_spinner);

        mStartDateTextView = (TextView) findViewById(R.id.start_date_text_view);

        mStartTimeTextView = (TextView) findViewById(R.id.start_time_text_view);

        mEndDateTextView = (TextView) findViewById(R.id.end_date_text_view);

        mEndTimeTextView = (TextView) findViewById(R.id.end_time_text_view);

        mPresenter = new CreateJobPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this);

        String[] spinnerItems = mPresenter.getWageTime();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerItems);

        mWageSpinner.setAdapter(adapter);

        mWageSpinner.setSelection(0);

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

    public void showJobDescription(View view){
        Intent startJobDescriptionActivity = new Intent(this, JobDescriptionActivity.class);
        String description = mJobDescriptionEditTextView.getText().toString();
        startJobDescriptionActivity.putExtra("description", description);
        startActivityForResult(startJobDescriptionActivity, 1);
    }

    // TODO:
    public void showGoogleMapsLocation(View view){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                String description = data.getStringExtra("description");
                mJobDescriptionEditTextView.setText(description);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }
}
