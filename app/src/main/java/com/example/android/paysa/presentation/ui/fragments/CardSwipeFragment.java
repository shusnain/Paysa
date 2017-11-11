package com.example.android.paysa.presentation.ui.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.executors.impl.ThreadExecutor;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.domain.utilities.CardUtil;
import com.example.android.paysa.presentation.presenters.JobCardsPresenter;
import com.example.android.paysa.presentation.presenters.impl.JobCardsPresenterImpl;
import com.example.android.paysa.presentation.ui.activities.JobInformationActivity;
import com.example.android.paysa.presentation.ui.adapters.CardSwipeAdapter;
import com.example.android.paysa.threading.MainThreadImpl;

import java.util.List;

import link.fls.swipestack.SwipeStack;

public class CardSwipeFragment extends Fragment implements
        JobCardsPresenter.HomeView,
        CardSwipeAdapter.CardSwipeAdapterClickHandler{

    private SwipeStack mCardStack;

    private CardSwipeAdapter mCardSwipeAdapter;

    private JobCardsPresenter mMainPresenter;

    private CardUtil.CardType mType;

    private View mView;

    private int mCurrentPosition;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_card_swipe);
//
//        init();
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.activity_card_swipe, container, false);
        init();
        return mView;
    }

    private void init(){

        mCurrentPosition = 0;

        mType = CardUtil.CardType.SAVED;

        mCardStack = mView.findViewById(R.id.swipe_stack);

        mCardSwipeAdapter = new CardSwipeAdapter(this.getActivity(), this);

        mCardStack.setAdapter(mCardSwipeAdapter);

        mMainPresenter = new JobCardsPresenterImpl(
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

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if(id == android.R.id.home){
//            onBackPressed();
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.card_swipe, menu);
//        return true;
//    }

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
    public void onResume() {
        super.onResume();
        mMainPresenter.resume();
    }

    @Override
    public void setCards(List<Job> jobs) {
        mCardSwipeAdapter.setCardData(jobs);
    }

    @Override
    public CardUtil.CardType getType() {
        return mType;
    }

    @Override
    public void onClick(int viewID, Job job) {
        if (viewID == R.id.iv_info){
            startJobInformationActivity(job);
        }
    }

    private void startJobInformationActivity(Job job){
        Context context = getContext();
        Intent startJobInfromationActivity = new Intent(context, JobInformationActivity.class);
        startJobInfromationActivity.putExtra("job",job);
        startActivity(startJobInfromationActivity);
    }
}
