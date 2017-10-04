package com.example.android.paysa.domain.models;

import com.example.android.paysa.domain.utilities.JobUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Seeker {

   private String mSeekerId;

    private String mLastName;

    private String mFirstName;

    private String mMiddleName;

    private String mLocation;

    private String mPhoneNumber;

    private List<String> mSkills;

    private List<Job> mJobsAppliedTo;

    private List<Job> mJobsSaved;

    public Seeker(String seekerId, String firstName, String middleName, String lastName, String location, String phoneNumber) {
        mSeekerId = seekerId;
        mFirstName = firstName;
        mMiddleName = middleName;
        mLastName = lastName;
        mLocation = location;
        mPhoneNumber = phoneNumber;
        mSkills = new ArrayList<String>();
        mJobsAppliedTo = new ArrayList<Job>();
        mJobsSaved = new ArrayList<Job>();
    }

    public Seeker(String seekerId, String firstName, String middleName, String lastName, String location, String phoneNumber, List<String> skills, List<Job> jobsAppliedTo, List<Job> jobsSaved) {
        mSeekerId = seekerId;
        mFirstName = firstName;
        mMiddleName = middleName;
        mLastName = lastName;
        mLocation = location;
        mPhoneNumber = phoneNumber;
        mSkills = skills;
        mJobsAppliedTo = jobsAppliedTo;
        mJobsSaved = jobsSaved;
    }

    public Seeker(String seekerId, String firstName, String lastName, String location, String phoneNumber, List<String> skills, List<Job> jobsAppliedTo, List<Job> jobsSaved) {
        mSeekerId = seekerId;
        mFirstName = firstName;
        mMiddleName = "";
        mLastName = lastName;
        mLocation = location;
        mPhoneNumber = phoneNumber;
        mSkills = skills;
        mJobsAppliedTo = jobsAppliedTo;
        mJobsSaved = jobsSaved;
    }

    public String getSeekerId() { return mSeekerId; }

    public String getFirstName(){ return mFirstName; }

    public String getMiddleName(){ return mMiddleName; }

    public String getLastName(){ return mLastName; }

    public String getFullName() {
        if(mMiddleName == ""){
            return mFirstName + " " + mLastName;
        } else{
            return mFirstName + " " + mMiddleName + " " + mLastName;
        }
    }

    public String getLocation(){ return mLocation; }

    public String getPhoneNumber(){ return mPhoneNumber; }

    public List<String> getSkills() { return mSkills; }

    public List<Job> getJobsAppliedTo() { return mJobsAppliedTo; }

    public List<Job> getJobsSaved() { return mJobsSaved; }

    public void addToJobsSaved(Job job){
        mJobsSaved.add(job);
        Collections.sort(mJobsSaved);
    }

    public void addToJobsApplied(Job job) {
        mJobsAppliedTo.add(job);
        Collections.sort(mJobsAppliedTo);
    }

    public void removeFromJobsSaved(Job job){
        long jobId = job.getId();
        int position = JobUtils.findJob(mJobsSaved, jobId);

        if(position == -1){
            return;
        }

        mJobsSaved.remove(position);
    }

}
