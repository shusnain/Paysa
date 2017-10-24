package com.example.android.paysa.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.executors.impl.ThreadExecutor;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.presentation.presenters.HomePresenter;
import com.example.android.paysa.presentation.presenters.impl.HomePresenterImpl;
import com.example.android.paysa.presentation.ui.adapters.CardSwipeAdapter;
import com.example.android.paysa.threading.MainThreadImpl;

import java.util.List;

import link.fls.swipestack.SwipeStack;

public class CardSwipeActivity extends AppCompatActivity implements HomePresenter.View {

    private SwipeStack mCardStack;

    private CardSwipeAdapter mCardSwipeAdapter;

    private HomePresenter mMainPresenter;

    private int mCurrentPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_swipe);

        init();
    }

    private void init(){

        mCurrentPosition = 0;

        mCardStack = (SwipeStack) findViewById(R.id.swipe_stack);

        mCardSwipeAdapter = new CardSwipeAdapter(this);

        mCardStack.setAdapter(mCardSwipeAdapter);

        mMainPresenter = new HomePresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this
        );

        mCardStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {
                mCurrentPosition = position + 1;
            }

            @Override
            public void onViewSwipedToRight(int position) {
                mCurrentPosition = position + 1;
            }

            @Override
            public void onStackEmpty() {
                mCardStack.resetStack();
            }
        });
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.card_swipe, menu);
        return true;
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
        mCardSwipeAdapter.setCardData(jobs);
    }
}
