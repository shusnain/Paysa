package com.example.android.paysa.presentation.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.models.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S_Husnain on 2017-09-27.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardAdapterViewHolder> {
    private List<Job> mJobData;

    final private CardAdapterOnClickHandler mClickHandler;

    public interface CardAdapterOnClickHandler{

        /**
         *
         * @param viewID - ID of the view
         * @param job
         */
        void onClick(int viewID, Job job);
    }

    /**
     * Creates a Job Adapter
     *
     * @param clickHandler
     */

    public CardAdapter(CardAdapterOnClickHandler clickHandler){
        mJobData = new ArrayList<Job>();
        mClickHandler = clickHandler;
    }


    @Override
    public CardAdapter.CardAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForCardItem = R.layout.card_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForCardItem, viewGroup, shouldAttachToParentImmediately);
        return new CardAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardAdapter.CardAdapterViewHolder holder, final int position) {

        Job job = mJobData.get(position);

        String location = job.getLocation();
        holder.mJobLocationView.setText(location);

        String employerName = job.getEmployerName();
        holder.mEmployerNameView.setText(employerName);

        String cardTitle = job.getTitle();
        holder.mJobTitleView.setText(cardTitle);

        String jobWage = Double.toString(job.getWage());
        holder.mJobWageView.setText(jobWage);

        String jobFrequency = job.getWageFrequency();
        holder.mJobWageFrequencyView.setText(jobFrequency);

        holder.mCardImageView.setImageResource(R.drawable.better_call_saul);

        boolean saved = job.isSaved();
        if(saved){
            holder.mCardSaveImageView.setImageResource(R.drawable.star_filled);
        } else{
            holder.mCardSaveImageView.setImageResource(R.drawable.star);
        }
    }

    @Override
    public int getItemCount() {return mJobData == null ? 0 : mJobData.size();}


    class CardAdapterViewHolder extends RecyclerView.ViewHolder  {
//        public final TextView mCardTextView;
        public final TextView mJobTitleView, mJobWageView, mJobWageFrequencyView, mEmployerNameView, mJobLocationView;
        public final ImageView mCardImageView;
        public final ImageView mCardSaveImageView;

        public CardAdapterViewHolder(View itemView){
            super(itemView);
//            mCardTextView = (TextView) itemView.findViewById(R.id.tv_info_text);
            mJobTitleView = (TextView) itemView.findViewById(R.id.tv_title_text);
            mJobWageView = (TextView) itemView.findViewById(R.id.tv_wage);
            mJobWageFrequencyView = (TextView) itemView.findViewById(R.id.tv_wage_frequency);
            mEmployerNameView = (TextView) itemView.findViewById(R.id.tv_employer_name);
            mJobLocationView = (TextView) itemView.findViewById(R.id.tv_location);
            mCardImageView = (ImageView) itemView.findViewById(R.id.iv_card);
            mCardSaveImageView = (ImageView) itemView.findViewById(R.id.iv_save);

            mCardSaveImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int adapterPosition = getAdapterPosition();
                    Job job = mJobData.get(adapterPosition);
                    int id = view.getId();
                    mClickHandler.onClick(id, job);
                }
            });

            mCardImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int adapterPosition = getAdapterPosition();
                    Job job = mJobData.get(adapterPosition);
                    int id = view.getId();
                    mClickHandler.onClick(id, job);
                }
            });
        }

    }

    public void setCardData(List<Job> jobData){
        mJobData = jobData;

        notifyDataSetChanged();
    }
}
