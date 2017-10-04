package com.example.android.paysa.domain.utilities;

import com.example.android.paysa.domain.models.Job;

import java.util.Collections;
import java.util.List;

/**
 * Created by S_Husnain on 2017-10-04.
 */

public final class JobUtils {

    public static int findJob(List<Job> jobsList, long jobId){
        int length = jobsList.size();
        int low = 0;
        int high = length - 1;
        while(high >= low){
            int mid = (low+high)/2;
            Job x = jobsList.get(mid);
            long xId = x.getId();
            if(jobId == xId){
                return mid;
            } else if(xId > jobId){
                low = mid + 1;
            } else if(xId < jobId){
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void addToJobsList(List<Job> jobList, Job job){
        jobList.add(job);
        Collections.sort(jobList);
    }
}
