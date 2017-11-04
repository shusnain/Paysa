package com.example.android.paysa.presentation.ui.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.models.Employer;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmployerProfileActivity extends AppCompatActivity {

    private Employer mEmployer;

    private TextView mEmployerNameView, mLocationView, mPhoneNumberView, mEmailView;
    private ImageView mEmployerImageView;
    private CircleImageView mEmployerLogoView;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_profile);

        init();

        mEmployer = (Employer) getIntent().getSerializableExtra("employer");
        if(mEmployer != null){
            setEmployerData();
        }
    }

    private void init(){
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));

        mEmployerNameView = (TextView) findViewById(R.id.tv_employer_name);
        mLocationView = (TextView) findViewById(R.id.tv_employer_location);
        mPhoneNumberView = (TextView) findViewById(R.id.tv_employer_phone_number);
        mEmailView = (TextView) findViewById(R.id.tv_employer_email);

        mEmployerImageView = (ImageView) findViewById(R.id.iv_employer);
        mEmployerLogoView = (CircleImageView) findViewById(R.id.iv_employer_logo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setEmployerData(){
        String location = mEmployer.getLocation();
        mLocationView.setText(location);

        String employerName = mEmployer.getName();
        mEmployerNameView.setText(employerName);

        String phoneNumber = mEmployer.getPhoneNumber();
        mPhoneNumberView.setText(phoneNumber);

        String email = mEmployer.getEmailAddress();
        mEmailView.setText(email);

        mEmployerImageView.setImageResource(R.drawable.better_call_saul);
        mEmployerLogoView.setImageResource(R.drawable.kitten);
    }
}
