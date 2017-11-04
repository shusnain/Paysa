package com.example.android.paysa.domain.models;

import com.example.android.paysa.domain.utilities.JobUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Seeker implements Serializable {

   private String mSeekerId;

    private String mLastName;

    private String mFirstName;

    private String mMiddleName;

    private String mLocation;

    private String mPhoneNumber;

    private String mEmailAddress;

    private List<String> mSkills;

    private List<Job> mJobsAppliedTo;

    private List<Job> mJobsSaved;

    private List<Job> mJobsOffered;

    public Seeker(String seekerId, String firstName, String middleName, String lastName, String location, String phoneNumber, String emailAddress) {
        mSeekerId = seekerId;
        mFirstName = firstName;
        mMiddleName = middleName;
        mLastName = lastName;
        mLocation = location;
        mPhoneNumber = phoneNumber;
        mEmailAddress = emailAddress;
        mSkills = new ArrayList<String>();
        mJobsAppliedTo = new ArrayList<Job>();
        mJobsSaved = new ArrayList<Job>();
        mJobsOffered = new ArrayList<Job>();
    }

    public Seeker(String seekerId, String firstName, String middleName, String lastName, String location, String phoneNumber, String emailAddress, List<String> skills, List<Job> jobsAppliedTo, List<Job> jobsSaved, List<Job> jobsOffered) {
        mSeekerId = seekerId;
        mFirstName = firstName;
        mMiddleName = middleName;
        mLastName = lastName;
        mLocation = location;
        mPhoneNumber = phoneNumber;
        mEmailAddress = emailAddress;
        mSkills = skills;
        mJobsAppliedTo = jobsAppliedTo;
        mJobsSaved = jobsSaved;
        mJobsOffered = jobsOffered;
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

    public String getEmailAddress() { return mEmailAddress; }

    public List<String> getSkills() { return mSkills; }

    public List<Job> getJobsAppliedTo() { return mJobsAppliedTo; }

    public List<Job> getJobsSaved() { return mJobsSaved; }

    public List<Job> getJobOffered() { return mJobsOffered; }

    public void setPhoneNumber(String phoneNumber) { mPhoneNumber = phoneNumber; }

    public void setEmailAddress(String emailAddress){ mEmailAddress = emailAddress; }

    public void addToJobsSaved(Job job){
        int positionJobsSaved = JobUtils.findJob(mJobsSaved, job.getId());
        if(positionJobsSaved == -1){
            JobUtils.addToJobsList(mJobsSaved, job);
        }
    }

    public void addToJobsApplied(Job job) {
        if(job.canApply()){
            addToJobsSaved(job);

            int positionJobsApplied = JobUtils.findJob(mJobsAppliedTo, job.getId());
            if(positionJobsApplied == -1){
                JobUtils.addToJobsList(mJobsAppliedTo, job);
            }
        }
    }

    public void addToJobsOffered(Job job){
        addToJobsSaved(job);

        int positionJobOffered = JobUtils.findJob(mJobsOffered, job.getId());
        if(positionJobOffered == -1){
            JobUtils.addToJobsList(mJobsOffered, job);
        }
    }

    public void removeFromJobsAppliedTo(Job job){
        long jobId = job.getId();

        int position = JobUtils.findJob(mJobsAppliedTo, jobId);

        if(position == -1){
            return;
        }

        mJobsAppliedTo.remove(position);
    }

    public void removeFromJobsSaved(Job job){
        long jobId = job.getId();
        int position = JobUtils.findJob(mJobsSaved, jobId);

        if(position == -1){
            return;
        }

        mJobsSaved.remove(position);
    }

    public void removeFromJobsOffered(Job job){
        long jobId = job.getId();

        int position = JobUtils.findJob(mJobsOffered, jobId);

        if(position == -1){
            return;
        }

        mJobsOffered.remove(position);
    }

    public void removeFromAllJobsLists(Job job){
        removeFromJobsAppliedTo(job);
        removeFromJobsSaved(job);
        removeFromJobsOffered(job);
    }

    public void applyToJob(Job job){
        addToJobsApplied(job);
        job.addToApplicants(this);
    }

    public void jobOffered(Job job){
        addToJobsOffered(job);
    }

    public void acceptOffer(Job job){
        job.acceptedOffer(this);
    }

    public void declineOffer(Job job){
        removeFromJobsOffered(job);
    }

    public void offerRevoked(Job job){
        removeFromJobsOffered(job);
    }

}
