package com.example.android.paysa.presentation.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.paysa.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by S_Husnain on 2017-09-27.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardAdapterViewHolder> {
    private List<String> mCardTextData;
    private List<String> mCardTitleData;

    public CardAdapter(){
        mCardTextData = new ArrayList<String>();
        mCardTitleData = new ArrayList<String>();
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
    public void onBindViewHolder(CardAdapter.CardAdapterViewHolder holder, int position) {
        String cardText = mCardTextData.get(position);
        String cardTitle = mCardTitleData.get(position);
        holder.mCardTextView.setText(cardText);
        holder.mCardTitleView.setText(cardTitle);
        holder.mCardImageView.setImageResource(R.drawable.better_call_saul);
        holder.mCardSaveImageView.setImageResource(R.drawable.star_filled);
    }

    @Override
    public int getItemCount() {return mCardTextData == null ? 0 : mCardTextData.size();}

    class CardAdapterViewHolder extends RecyclerView.ViewHolder{
        public final TextView mCardTextView;
        public final TextView mCardTitleView;
        public final ImageView mCardImageView;
        public final ImageView mCardSaveImageView;

        public CardAdapterViewHolder(View itemView){
            super(itemView);
            mCardTextView = (TextView) itemView.findViewById(R.id.tv_info_text);
            mCardTitleView = (TextView) itemView.findViewById(R.id.tv_title_text);
            mCardImageView = (ImageView) itemView.findViewById(R.id.iv_card);
            mCardSaveImageView = (ImageView) itemView.findViewById(R.id.iv_save);
        }
    }

    public void setCardData(Map<String, String> cardData){
        for(Map.Entry<String, String> entry : cardData.entrySet()){
            String title = entry.getKey();
            mCardTitleData.add(title);

            String text = entry.getValue();
            mCardTextData.add(text);
        }

        notifyDataSetChanged();
    }
}
