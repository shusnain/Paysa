package com.example.android.paysa.domain.models;

import android.support.annotation.NonNull;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Job implements Comparable<Job>{

    private long mId;
    private String mTitle;
    private String mInfo;
    private double mWage;
    private boolean mSaved;

    public Job(String title, String info, double wage) {
        mId = System.currentTimeMillis();
        mTitle = title;
        mInfo = info;
        mWage = wage;
        mSaved = false;

    }

    public Job(String title, String info, double wage, boolean saved) {
        mId = System.currentTimeMillis();
        mTitle = title;
        mInfo = info;
        mWage = wage;
        mSaved = saved;
    }

    public void setTitle(String title){ mTitle = title; }

    public void setInfo(String info){ mInfo = info; }

    public void setWage(double wage){ mWage = wage; }

    public void setSaved(boolean saved){ mSaved = saved;}

    public long getId() { return mId; }

    public String getTitle() {
        return mTitle;
    }

    public String getInfo(){ return mInfo; }

    public double getWage(){ return mWage; }

    public boolean isSaved(){ return mSaved;}

    public void toggleSaved(){ mSaved = !mSaved; }

    @Override
    public int compareTo(@NonNull Job job) {
        long compareId = job.getId();
        return mId < compareId ? 1 : -1;
    }
}
