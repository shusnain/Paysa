package com.example.android.paysa.domain.models;

import com.example.android.paysa.domain.utilities.JobUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Employer {

    private String mId;

    private String mName;

    private String mLocation;

    private String mPhoneNumber;

    private String mEmailAddress;

    private String mPublicEmailAddress;

    private List<Job> mOpenJobs;

    private List<Job> mAllJobs;

    public Employer(String Id, String name, String location, String phoneNumber, String emailAddress) {

        mId = Id;
        mName = name;
        mLocation = location;
        mPhoneNumber = phoneNumber;
        mEmailAddress = emailAddress;
        mPublicEmailAddress = emailAddress;
        mOpenJobs = new ArrayList<Job>();
        mAllJobs = new ArrayList<Job>();
    }

    public String getId(){ return mId; }

    public String getName(){ return mName; }

    public String getLocation(){ return mLocation; }

    public String getPhoneNumber(){ return mPhoneNumber; }

    public String getEmailAddress(){ return mEmailAddress; }

    public String getPublicEmailAddress(){ return mPublicEmailAddress; }

    public void setPhoneNumber(String phoneNumber){ mPhoneNumber = phoneNumber; }

    public void setEmailAddress(String emailAddress){ mEmailAddress = emailAddress; }

    public void setPublicEmailAddress(String emailAddress){ mPublicEmailAddress = emailAddress; }

    public List<Job> getOpenJobs(){ return mOpenJobs; }

    public List<Job> getAllJobs(){ return mAllJobs; }

    public void addToOpenJobs(Job job) {
        addToAllJobs(job);

        int positionInOpenJobs = JobUtils.findJob(mOpenJobs, job.getId());
        if(positionInOpenJobs == -1){
            JobUtils.addToJobsList(mOpenJobs, job);
        }
    }

    public void addToAllJobs(Job job){
        int positionInAllJobs = JobUtils.findJob(mAllJobs, job.getId());
        if(positionInAllJobs == -1){
            JobUtils.addToJobsList(mAllJobs, job);
        }
    }

    public void removeFromOpenJobs(Job job){
        int position = JobUtils.findJob(mOpenJobs, job.getId());

        if(position == -1){
            return;
        }

        mOpenJobs.remove(position);
    }

    public void removeFromAllJobs(Job job){
        int position = JobUtils.findJob(mAllJobs, job.getId());

        if(position == -1){
            return;
        }

        mAllJobs.remove(position);
    }

    public void offerJob(Seeker seeker, Job job){
        seeker.jobOffered(job);
    }

    public void acceptedOffer(Job job, Seeker seeker){
        job.closeJob();
        job.setEmployee(seeker);
        removeFromOpenJobs(job);
    }
}
