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

public class UserProfileActivity extends AppCompatActivity {

    private TextView mUserNameView, mLocationView, mPhoneNumberView, mEmailView;
    private ImageView mUserImageView;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        init();

        setUserData();
    }

    private void init(){
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));

        mUserNameView = (TextView) findViewById(R.id.tv_user_name);
        mLocationView = (TextView) findViewById(R.id.tv_location);
        mPhoneNumberView = (TextView) findViewById(R.id.tv_user_phone_number);
        mEmailView = (TextView) findViewById(R.id.tv_user_email);

        mUserImageView = (ImageView) findViewById(R.id.iv_user);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUserData(){
        mUserImageView.setImageResource(R.drawable.better_call_saul);
    }
}
