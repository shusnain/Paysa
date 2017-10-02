package com.example.android.paysa.domain.models;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Card {

    private String mTitle;
    private String mInfo;
    private double mWage;

    public Card(String title, String info, double wage) {

        mTitle = title;
        mInfo = info;
        mWage = wage;
    }

    public void setTitle(String title){ mTitle = title; }

    public void setInfo(String info){ mInfo = info; }

    public void setWage(double wage){ mWage = wage; }

    public String getTitle() {
        return mTitle;
    }

    public String getInfo(){ return mInfo; }

    public double getWage(){ return mWage; }
}
