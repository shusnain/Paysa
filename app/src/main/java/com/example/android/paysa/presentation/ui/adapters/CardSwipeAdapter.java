package com.example.android.paysa.presentation.ui.adapters;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.domain.utilities.JobUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S_Husnain on 2017-10-18.
 */

public class CardSwipeAdapter extends BaseAdapter {
    private List<Job> mJobData;
    private Activity mActivity;
    private CardSwipeAdapterClickHandler mClickHandler;

    public interface CardSwipeAdapterClickHandler{

        void onClick(int viewID, Job job);
    }

    public CardSwipeAdapter(Activity activity, CardSwipeAdapterClickHandler clickHandler){
        mJobData = new ArrayList<>();
        mActivity = activity;
        mClickHandler = clickHandler;
    }

    @Override
    public int getCount() {
        return mJobData == null ? 0 : mJobData.size();
    }

    @Override
    public Object getItem(int i) {
        return mJobData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        public final TextView mJobTitleView, mJobWageView, mEmployerNameView, mJobLocationView;
        public final ImageView mCardImageView, mCardInfoImageView;

        public ViewHolder(View itemView){
            mJobTitleView = itemView.findViewById(R.id.tv_title_text);
            mJobWageView = itemView.findViewById(R.id.tv_wage);
            mEmployerNameView = itemView.findViewById(R.id.tv_employer_name);
            mJobLocationView = itemView.findViewById(R.id.tv_location);
            mCardImageView = itemView.findViewById(R.id.iv_card);
            mCardInfoImageView = itemView.findViewById(R.id.iv_info);

            mCardInfoImageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.card_list_item, parent, false);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        Job job = mJobData.get(position);

        String location = job.getLocation();
        holder.mJobLocationView.setText(location);

        String employerName = job.getEmployerName();
        holder.mEmployerNameView.setText(employerName);

        String cardTitle = job.getTitle();
        holder.mJobTitleView.setText(cardTitle);

        Double jobWage = job.getWage();
        String jobFrequency = job.getWageFrequency();
        holder.mJobWageView.setText(JobUtils.formatJobWage(jobWage, jobFrequency));


        holder.mCardImageView.setImageResource(R.drawable.better_call_saul);

        holder.mCardInfoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Job job = mJobData.get(position);
                int id = view.getId();
                mClickHandler.onClick(id, job);
            }
        });

        return convertView;
    }

    public void setCardData(List<Job> jobData){
        mJobData = jobData;

        notifyDataSetChanged();
    }
}
