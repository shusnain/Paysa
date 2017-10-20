package com.example.android.paysa.presentation.ui.activities;

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
        public final TextView mCardTextView;
        public final TextView mCardTitleView;
        public final ImageView mCardImageView;

        public ViewHolder(View itemView){
            mCardTextView = (TextView) itemView.findViewById(R.id.tv_info_text);
            mCardTitleView = (TextView) itemView.findViewById(R.id.tv_title_text);
            mCardImageView = (ImageView) itemView.findViewById(R.id.iv_card);
        }
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.card_list_item, parent, false);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        String cardTitle = mJobData.get(i).getTitle();
        holder.mCardTitleView.setText(cardTitle);

        String cardText = mJobData.get(i).getInfo();
        holder.mCardTextView.setText(cardText);

        holder.mCardImageView.setImageResource(R.drawable.better_call_saul);

        return convertView;
    }

    public void setCardData(List<Job> jobData){
        mJobData = jobData;

        notifyDataSetChanged();
    }
}
