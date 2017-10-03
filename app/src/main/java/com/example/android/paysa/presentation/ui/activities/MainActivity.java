package com.example.android.paysa.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.paysa.domain.executors.impl.ThreadExecutor;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.presentation.presenters.MainPresenter;
import com.example.android.paysa.presentation.presenters.MainPresenter.View;
import com.example.android.paysa.presentation.presenters.impl.MainPresenterImpl;
import com.example.android.paysa.presentation.ui.adapters.CardAdapter;
import com.example.android.paysa.R;
import com.example.android.paysa.threading.MainThreadImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements
        View,
        CardAdapter.CardAdapterOnClickHandler{

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;

    private CardAdapter mCardAdapter;

    private MainPresenter mMainPresenter;


    Map<String, String> dummyData = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_card);

        int recylerViewOrientation = LinearLayoutManager.VERTICAL;

        boolean shouldReverseLayout = false;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, recylerViewOrientation, shouldReverseLayout);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

        mCardAdapter = new CardAdapter(this);

        mMainPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this
        );

        mRecyclerView.setAdapter(mCardAdapter);
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
    protected void onResume() {
        super.onResume();
        mMainPresenter.resume();
    }

    @Override
    public void setCards(List<Job> jobs) {
        mCardAdapter.setCardData(jobs);
    }

    @Override
    public void onClick(int viewID, Job job) {
        if(viewID == R.id.iv_save){
            job.toggleSaved();
        } else if (viewID == R.id.iv_card){
            job.setTitle("Change");
        }
        mCardAdapter.notifyDataSetChanged();
    }
}
