package com.example.android.paysa.presentation.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.executors.impl.ThreadExecutor;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.domain.utilities.CardUtil;
import com.example.android.paysa.domain.utilities.JobUtils;
import com.example.android.paysa.presentation.presenters.JobCardsPresenter;
import com.example.android.paysa.presentation.presenters.impl.JobCardsPresenterImpl;
import com.example.android.paysa.presentation.ui.activities.JobInformationActivity;
import com.example.android.paysa.presentation.ui.adapters.CardAdapter;
import com.example.android.paysa.threading.MainThreadImpl;

import java.util.List;

/**
 * Created by S_Husnain on 2017-10-25.
 */

public class JobCardsFragment extends Fragment implements
        JobCardsPresenter.HomeView,
        CardAdapter.CardAdapterOnClickHandler{

    private RecyclerView mRecyclerView;

    private CardAdapter mCardAdapter;

    private JobCardsPresenter mJobCardsPresenter;

    private CardUtil.CardType mType = CardUtil.CardType.APPLIED;

    View mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mType = (CardUtil.CardType) getArguments().getSerializable("type");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_job_cards, container, false);
        init();
        return mView;
    }

    public static final JobCardsFragment newInstance(CardUtil.CardType type){
        JobCardsFragment fragment = new JobCardsFragment();
        Bundle bundle = new Bundle(1);
        bundle.putSerializable("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void init(){
        mRecyclerView = mView.findViewById(R.id.recyclerview_card);

        int recylerViewOrientation = LinearLayoutManager.VERTICAL;

        boolean shouldReverseLayout = false;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), recylerViewOrientation, shouldReverseLayout);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

        mCardAdapter = new CardAdapter(this);

        mJobCardsPresenter = new JobCardsPresenterImpl(
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
    public void onResume() {
        super.onResume();
        mJobCardsPresenter.resume();
    }

    @Override
    public void setCards(List<Job> jobs) {
        mCardAdapter.setCardData(jobs);
    }

    @Override
    public CardUtil.CardType getType() {
        return mType;
    }

    @Override
    public void onClick(int viewID, Job job) {
        if(viewID == R.id.iv_save){
            job.toggleSaved();
            mCardAdapter.notifyDataSetChanged();
        } else if (viewID == R.id.iv_info){
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
