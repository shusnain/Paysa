package com.example.android.paysa.domain.models;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Card {

    private String mTitle;
    private String mInfo;
    private float mWage;

    public Card(String title, String info, float wage) {

        mTitle = title;
        mInfo = info;
        mWage = wage;
    }

    public void setTitle(String title){ mTitle = title; }

    public void setInfo(String info){ mInfo = info; }

    public void setWage(float wage){ mWage = wage; }

    public String getTitle() {
        return mTitle;
    }

    public String getInfo(){ return mInfo; }

    public float getWage(){ return mWage; }
}
