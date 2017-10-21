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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S_Husnain on 2017-10-18.
 */

public class CardSwipeAdapter extends BaseAdapter {
    private List<Job> mJobData;
    private Activity mActivity;

    public CardSwipeAdapter(Activity activity){
        mJobData = new ArrayList<>();
        mActivity = activity;
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
//        public final TextView mCardTextView;
        public final TextView mJobTitleView, mJobWageView, mJobWageFrequencyView, mEmployerNameView, mJobLocationView;
        public final ImageView mCardImageView;

        public ViewHolder(View itemView){
//            mCardTextView = (TextView) itemView.findViewById(R.id.tv_info_text);
            mJobTitleView = (TextView) itemView.findViewById(R.id.tv_title_text);
            mJobWageView = (TextView) itemView.findViewById(R.id.tv_wage);
            mJobWageFrequencyView = (TextView) itemView.findViewById(R.id.tv_wage_frequency);
            mEmployerNameView = (TextView) itemView.findViewById(R.id.tv_employer_name);
            mJobLocationView = (TextView) itemView.findViewById(R.id.tv_location);
            mCardImageView = (ImageView) itemView.findViewById(R.id.iv_card);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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

        String jobWage = Double.toString(job.getWage());
        holder.mJobWageView.setText(jobWage);

        String jobFrequency = job.getWageFrequency();
        holder.mJobWageFrequencyView.setText(jobFrequency);

        holder.mCardImageView.setImageResource(R.drawable.better_call_saul);

        return convertView;
    }

    public void setCardData(List<Job> jobData){
        mJobData = jobData;

        notifyDataSetChanged();
    }
}
