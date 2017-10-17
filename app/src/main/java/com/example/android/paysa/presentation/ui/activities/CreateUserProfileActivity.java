package com.example.android.paysa.presentation.ui.activities;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.executors.impl.ThreadExecutor;
import com.example.android.paysa.presentation.presenters.CreateUserProfilePresenter;
import com.example.android.paysa.presentation.presenters.impl.CreateUserProfilePresenterImpl;
import com.example.android.paysa.threading.MainThreadImpl;

public class CreateUserProfileActivity extends AppCompatActivity implements CreateUserProfilePresenter.CreateUserProfileView {

    private CreateUserProfilePresenter mPresenter;

    private EditText mFirstNameEditText, mLastNameEditText, mLocationEditText, mEmailAddressEditText, mPhoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_profile);
        init();
    }

    private void init(){
        ActionBar actionBar = this.getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mFirstNameEditText = (EditText) findViewById(R.id.user_first_name_edit_text);

        mLastNameEditText = (EditText) findViewById(R.id.user_last_name_edit_text);

        mLocationEditText = (EditText) findViewById(R.id.user_location_edit_text);

        mEmailAddressEditText = (EditText) findViewById(R.id.user_email_address_edit_text);

        mPhoneNumberEditText = (EditText) findViewById(R.id.user_email_address_edit_text);

        mPresenter = new CreateUserProfilePresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
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
