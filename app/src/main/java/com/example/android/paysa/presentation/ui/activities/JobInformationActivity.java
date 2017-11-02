package com.example.android.paysa.presentation.ui.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.domain.utilities.JobUtils;

public class JobInformationActivity extends AppCompatActivity {

    private Job mJob;

    private TextView mJobTitleView, mJobWageView, mJobDescriptionView, mEmployerNameView, mJobLocationView;
    private ImageView mCardImageView;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_information);

        init();


        mJob = (Job) getIntent().getSerializableExtra("job");
        if(mJob != null){
            setJobData();
        }
    }

    private void init(){

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));


        mJobTitleView = (TextView) findViewById(R.id.tv_job_title);
        mEmployerNameView = (TextView) findViewById(R.id.tv_job_employer);
        mJobLocationView = (TextView) findViewById(R.id.tv_job_location);
        mJobWageView = (TextView) findViewById(R.id.tv_job_wage);
        mJobDescriptionView = (TextView) findViewById(R.id.tv_job_description);

        //TODO: Fix CollapsingToolbar
        mCardImageView = (ImageView) findViewById(R.id.iv_job);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setJobData(){
        String location = mJob.getLocation();
        mJobLocationView.setText(location);

        String employerName = mJob.getEmployerName();
        mEmployerNameView.setText(employerName);

        String jobTitle = mJob.getTitle();
        mJobTitleView.setText(jobTitle);
        mCollapsingToolbarLayout.setTitle(jobTitle);

        double jobWage = mJob.getWage();
        String jobFrequency = mJob.getWageFrequency();
        String jobWageFormatted = JobUtils.formatJobWage(jobWage, jobFrequency);
        mJobWageView.setText(jobWageFormatted);

        String description = mJob.getDescription();
        mJobDescriptionView.setText(description);

        mCardImageView.setImageResource(R.drawable.better_call_saul);
    }
}
