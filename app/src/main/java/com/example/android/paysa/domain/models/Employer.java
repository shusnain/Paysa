package com.example.android.paysa.domain.models;

import com.example.android.paysa.domain.utilities.JobUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Employer {

    private String mName;

    private String mLocation;

    private List<Job> mOpenJobs;

    private List<Job> mAllJobs;

    public Employer(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public String getLocation() { return mLocation; }

    public List<Job> getOpenJobs() { return mOpenJobs; }

    public List<Job> getAllJobs() { return mAllJobs; }

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
}
