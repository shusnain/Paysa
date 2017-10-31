package com.example.android.paysa.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.models.Job;

public class JobInformationActivity extends AppCompatActivity {

    private Job mJob;

    private TextView mJobTitleView, mJobWageView, mJobWageFrequencyView, mEmployerNameView, mJobLocationView;
    private ImageView mCardImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_information);

        init();


        mJob = (Job) getIntent().getSerializableExtra("job");

        String location = mJob.getLocation();
        mJobLocationView.setText(location);

        String employerName = mJob.getEmployerName();
        mEmployerNameView.setText(employerName);

        String cardTitle = mJob.getTitle();
        mJobTitleView.setText(cardTitle);

        String jobWage = Double.toString(mJob.getWage());
        mJobWageView.setText(jobWage);

//        String jobFrequency = mJob.getWageFrequency();
//        mJobWageFrequencyView.setText(jobFrequency);

        mCardImageView.setImageResource(R.drawable.better_call_saul);
    }

    private void init(){
        mJobTitleView = (TextView) findViewById(R.id.tv_job_title);
        mEmployerNameView = (TextView) findViewById(R.id.tv_job_employer);
        mJobLocationView = (TextView) findViewById(R.id.tv_job_location);
        mJobWageView = (TextView) findViewById(R.id.tv_job_wage);

        mCardImageView = (ImageView) findViewById(R.id.iv_job);
    }
}
