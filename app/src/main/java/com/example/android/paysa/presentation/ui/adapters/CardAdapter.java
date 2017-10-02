package com.example.android.paysa.presentation.ui.adapters;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.models.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by S_Husnain on 2017-09-27.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardAdapterViewHolder> {
    private List<Card> mCardData;

    public CardAdapter(){
        mCardData = new ArrayList<Card>();
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

        String cardTitle = mCardData.get(position).getTitle();
        String cardText = mCardData.get(position).getInfo();

        holder.mCardTextView.setText(cardText);
        holder.mCardTitleView.setText(cardTitle);
        holder.mCardImageView.setImageResource(R.drawable.better_call_saul);
        holder.mCardSaveImageView.setImageResource(R.drawable.star_filled);
    }

    @Override
    public int getItemCount() {return mCardData == null ? 0 : mCardData.size();}

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

    public void setCardData(List<Card> cardData){
        mCardData = cardData;

        notifyDataSetChanged();
    }
}
