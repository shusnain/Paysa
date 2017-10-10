package com.example.android.paysa;

import android.util.Log;

import com.example.android.paysa.domain.models.Employer;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.domain.models.Seeker;
import com.example.android.paysa.domain.utilities.JobUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JobEmployerSeekerUnitTest {

    Date startDate = new GregorianCalendar(2017, Calendar.JANUARY, 1).getTime();
    Date endDate = new GregorianCalendar(2017, Calendar.JANUARY, 2).getTime();

    private Employer employer1 = new Employer("1", "1", "loc", "#", "@");

    private Seeker seeker1 = new Seeker("1", "f", "", "l", "loc", "#", "@");


    @Test
    public void job_ThrowsException() throws Exception{

        try{
            Job a = new Job("1", "1", 1, endDate, startDate, null);
            fail("Expected an exception to be thrown");
        }catch(Exception e){
            assertEquals(e.getMessage(), "startDate is after endDate");
        }
    }

    @Test
    public void find_Job() throws Exception{
        Job job1 = null;
        try{
            job1 = new Job(1, "1", "1", 1, startDate, endDate, employer1);

        } catch (Exception e){
            fail("ERROR: Job not created");
        }

        long id = job1.getId();
        int find = JobUtils.findJob(employer1.getAllJobs(), id);
        assertEquals(find, -1);

        employer1.addToAllJobs(job1);

        find = JobUtils.findJob(employer1.getAllJobs(), id);
        assertNotEquals(-1, find);
    }

    @Test
    public void find_Jobs() throws Exception{
        int x = 10;
        Job[] jobsList = new Job[x];
        for(int i =0; i < x; i++){
            jobsList[i] = (null);
        }

        try{
            for(int i = 0; i < x; i++){
                String s = Integer.toBinaryString(i);
                jobsList[i] = new Job(i, s, s, i, startDate, endDate, employer1);
            }

        } catch (Exception e){
            fail("ERROR: Jobs not created");
        }
        int find;
        for(int i = 0; i < x; i++){
            employer1.addToAllJobs(jobsList[x - i - 1]);
        }


        for(int i = 0; i < x; i++){
            long id = jobsList[i].getId();
            find = JobUtils.findJob(employer1.getAllJobs(), id);
            assertEquals(i, find);
        }
    }

    @Test
    public void job_Offer_Accepted() throws Exception{
        Job job1 = null;
        try{
            job1 = new Job(1, "1", "1", 1, startDate, endDate, employer1);

        } catch (Exception e){
            fail("ERROR: Job not created");
        }
        // Ensure job is added to openJobs
        employer1.addToOpenJobs(job1);
        int find = JobUtils.findJob(employer1.getOpenJobs(), job1.getId());
        assertNotEquals(-1, find);

        // Ensure job is added to jobsAppliedTo
        seeker1.applyToJob(job1);
        find = JobUtils.findJob(seeker1.getJobsAppliedTo(), job1.getId());
        assertNotEquals(-1, find);

        // Ensure seeker is added to Applicants
        assertEquals(job1.getApplicants().get(0), seeker1);

        // Offer job and ensure job is added to jobsOffered
        employer1.offerJob(job1.getApplicants().get(0), job1);
        assertEquals(seeker1.getJobOffered().get(0), job1);

        seeker1.acceptOffer(job1);
        // Ensure job is closed
        assertEquals(job1.canApply(), false);

        // Ensure the employee for the job is seeker1
        assertEquals(job1.getEmployee(), seeker1);

        // Ensure job is removed from openJobs
        find = JobUtils.findJob(employer1.getOpenJobs(), job1.getId());
        assertEquals(-1, find);
    }

    @Test
    public void job_Offer_Declined() throws Exception{
        Job job1 = null;
        try{
            job1 = new Job(1, "1", "1", 1, startDate, endDate, employer1);

        } catch (Exception e){
            fail("ERROR: Job not created");
        }
        // Ensure job is added to openJobs
        employer1.addToOpenJobs(job1);
        int find = JobUtils.findJob(employer1.getOpenJobs(), job1.getId());
        assertNotEquals(-1, find);

        // Ensure job is added to jobsAppliedTo
        seeker1.applyToJob(job1);
        find = JobUtils.findJob(seeker1.getJobsAppliedTo(), job1.getId());
        assertNotEquals(-1, find);

        // Ensure seeker is added to Applicants
        assertEquals(job1.getApplicants().get(0), seeker1);

        // Offer job and ensure job is added to jobsOffered
        employer1.offerJob(job1.getApplicants().get(0), job1);
        assertEquals(seeker1.getJobOffered().get(0), job1);

        seeker1.declineOffer(job1);

        // Ensure job is removed from offered
        find = JobUtils.findJob(seeker1.getJobOffered(), job1.getId());
        assertEquals(-1, find);
    }

}