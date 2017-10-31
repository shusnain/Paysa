package com.example.android.paysa.presentation.ui.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.android.paysa.R;

public class SetJobDescriptionActivity extends AppCompatActivity {

    private EditText mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_job_description);
        init();
    }

    private void init(){
        ActionBar actionBar = this.getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mDescription = (EditText) findViewById(R.id.job_description_full_edit_text);

        Intent intent = getIntent();
        String description = intent.getStringExtra("description");
        if(description != ""){
            mDescription.setText(description);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.job_description, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            onBackPressed();
            return true;
        }

        if(id == R.id.action_save_job_description){
            Intent returnIntent = new Intent();
            String jobDescription = mDescription.getText().toString().trim();
            returnIntent.putExtra("description", jobDescription);
            setResult(AppCompatActivity.RESULT_OK, returnIntent);
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
