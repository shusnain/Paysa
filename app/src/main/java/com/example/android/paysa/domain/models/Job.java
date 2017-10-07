package com.example.android.paysa.domain.models;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Job implements Comparable<Job>{

    private long mId;
    private String mTitle;
    private String mInfo;
    private double mWage;
    private boolean mSaved;
    private Date mStartDate;
    private Date mEndDate;
    private List<Seeker> mApplicants;

    public Job(String title, String info, double wage, Date startDate, Date endDate) throws Exception{
        if(startDate.after(endDate)){
            throw new Exception("startDate is after endDate");
        }
        mId = System.currentTimeMillis();
        mTitle = title;
        mInfo = info;
        mWage = wage;
        mSaved = false;
        mStartDate = startDate;
        mEndDate = endDate;
        mApplicants = new ArrayList<Seeker>();
    }

    public Job(String title, String info, double wage, boolean saved,  Date startDate, Date endDate) throws Exception {
        if(startDate.after(endDate)){
            throw new Exception("startDate is after endDate");
        }
        mId = System.currentTimeMillis();
        mTitle = title;
        mInfo = info;
        mWage = wage;
        mSaved = saved;
        mStartDate = startDate;
        mEndDate = endDate;
    }

    @Override
    public int compareTo(@NonNull Job job) {
        long compareId = job.getId();
        return mId < compareId ? -1 :
                mId > compareId ? 1 :
                        0;
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

    public Date getStartDate(){ return mStartDate; }

    public Date getEndDate(){ return mEndDate; }

    public List<Seeker> getApplicants(){ return mApplicants; }

    public boolean isSaved(){ return mSaved;}

    public void toggleSaved(){ mSaved = !mSaved; }

    public void addToApplicants(Seeker seeker){
        mApplicants.add(seeker);
    }
}
