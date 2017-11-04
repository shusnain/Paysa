package com.example.android.paysa.domain.models;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Job implements Comparable<Job>, Serializable{

    private long mId;
    private String mTitle;
    private String mDescription;
    private double mWage;
    private String mWageFrequency;
    private boolean mSaved;
    private Date mStartDate;
    private Date mEndDate;
    private Employer mEmployer;
    private Seeker mEmployee;
    private List<Seeker> mApplicants;
    private boolean mCanApply;

    public Job(String title, String description, double wage, String wageFrequency, Date startDate, Date endDate, Employer employer) throws Exception{
        if(startDate.after(endDate)){
            throw new Exception("startDate is after endDate");
        }
        mId = System.currentTimeMillis();
        mTitle = title;
        mDescription = description;
        mWage = wage;
        mWageFrequency = wageFrequency;
        mSaved = false;
        mStartDate = startDate;
        mEndDate = endDate;
        mEmployer = employer;
        mEmployee = null;
        mApplicants = new ArrayList<Seeker>();
        mCanApply = true;
    }

    // Constructor for Tests
    public Job(long id, String title, String description, double wage, String wageFrequency, Date startDate, Date endDate, Employer employer) throws Exception{
        if(startDate.after(endDate)){
            throw new Exception("startDate is after endDate");
        }
        mId = id;
        mTitle = title;
        mDescription = description;
        mWage = wage;
        mWageFrequency = wageFrequency;
        mSaved = false;
        mStartDate = startDate;
        mEndDate = endDate;
        mEmployer = employer;
        mEmployee = null;
        mApplicants = new ArrayList<Seeker>();
        mCanApply = true;
    }

    public Job(String title, String description, double wage, boolean saved,  Date startDate, Date endDate, Employer employer) throws Exception {
        if(startDate.after(endDate)){
            throw new Exception("startDate is after endDate");
        }
        mId = System.currentTimeMillis();
        mTitle = title;
        mDescription = description;
        mWage = wage;
        mSaved = saved;
        mStartDate = startDate;
        mEndDate = endDate;
        mEmployer = employer;
        mEmployee = null;
        mCanApply = true;
    }

    @Override
    public int compareTo(@NonNull Job job) {
        long compareId = job.getId();
        return mId < compareId ? -1 :
                mId > compareId ? 1 :
                        0;
    }

    public void setTitle(String title){ mTitle = title; }

    public void setInfo(String description){ mDescription = description; }

    public void setWage(double wage){ mWage = wage; }

    public void setWageFrequency(String frequency){ mWageFrequency = frequency; }

    public void setSaved(boolean saved){ mSaved = saved;}

    public long getId() { return mId; }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription(){ return mDescription; }

    public double getWage(){ return mWage; }

    public String getWageFrequency() { return mWageFrequency; }

    public Date getStartDate(){ return mStartDate; }

    public Date getEndDate(){ return mEndDate; }

    public Employer getEmployer() { return mEmployer; }

    public String getLocation(){
        return mEmployer.getLocation();
    }

    public String getEmployerName(){
        return mEmployer.getName();
    }

    public Seeker getEmployee() { return mEmployee; }

    public List<Seeker> getApplicants(){ return mApplicants; }

    public void setEmployee(Seeker seeker){
        mEmployee = seeker;
    }

    public boolean isSaved(){ return mSaved;}

    public boolean canApply() { return mCanApply; }

    public void toggleSaved(){ mSaved = !mSaved; }

    public void closeJob() { mCanApply = false; }

    public void addToApplicants(Seeker seeker){
        mApplicants.add(seeker);
    }

    public void acceptedOffer(Seeker seeker){
        mEmployer.acceptedOffer(this, seeker);
    }

    public void offerRevoked(){
        if(mEmployee != null){
            mEmployee = null;
        }
        if(!mCanApply){
            mCanApply = true;
        }
    }
}
