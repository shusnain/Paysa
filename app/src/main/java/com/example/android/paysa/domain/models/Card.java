package com.example.android.paysa.domain.models;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Card {

    private String mTitle;
    private String mInfo;
    private double mWage;
    private boolean mSaved;

    public Card(String title, String info, double wage) {

        mTitle = title;
        mInfo = info;
        mWage = wage;
        mSaved = false;

    }

    public Card(String title, String info, double wage, boolean saved) {

        mTitle = title;
        mInfo = info;
        mWage = wage;
        mSaved = saved;
    }

    public void setTitle(String title){ mTitle = title; }

    public void setInfo(String info){ mInfo = info; }

    public void setWage(double wage){ mWage = wage; }

    public void setSaved(boolean saved){ mSaved = saved;}

    public String getTitle() {
        return mTitle;
    }

    public String getInfo(){ return mInfo; }

    public double getWage(){ return mWage; }

    public boolean isSaved(){ return mSaved;}

    public void toggleSaved(){ mSaved = !mSaved; }
}
