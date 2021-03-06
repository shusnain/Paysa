package com.example.android.paysa.domain.interactors.impl;

/**
 * Created by S_Husnain on 2017-09-30.
 */

import android.util.Log;

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.interactors.GetJobsInteractor;
import com.example.android.paysa.domain.interactors.base.AbstractInteractor;
import com.example.android.paysa.domain.models.Employer;
import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.domain.repository.Repository;
import com.example.android.paysa.domain.utilities.CardUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 *
 */
public class GetJobsInteractorImpl extends AbstractInteractor implements GetJobsInteractor {

    private Callback mCallback;
    private Repository mRepository;
    private CardUtil.CardType mType;

    private Employer mEmployer = new Employer("1", "Toronto Raptors", "Toronto, Ont", "1234567890", "fake@email.com");

    public GetJobsInteractorImpl(Executor threadExecutor,
                                 MainThread mainThread,
                                 Callback callback, Repository repository,
                                 CardUtil.CardType type) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mRepository = repository;
        mType = type;
    }

    public List<Job> createSavedDummyCards() {
        List<Job> dummyJobs = new ArrayList<>();
        Date startDate = new GregorianCalendar(2017, Calendar.JANUARY, 1).getTime();
        Date endDate = new GregorianCalendar(2017, Calendar.JANUARY, 2).getTime();

        try{
            Job a = new Job("Title 1",
                    "Lorem ipsum dolor sit amet, mauris vivamus dictumst faucibus vel felis arcu, morbi amet litora non sed, suscipit nulla nascetur metus in, a tincidunt montes nunc. Tempor lacus facilisis blandit suscipit phasellus magna, id velit nunc feugiat ipsum hymenaeos mattis, nec in pellentesque sollicitudin. Nec ut pharetra quis sit, in vitae, sit vestibulum condimentum, integer interdum consequat leo, ac fusce nec adipiscing placerat venenatis. Elit quam diam lectus arcu quam eu, arcu condimentum eget fringilla sed, urna et eget, interdum nec nullam. Eget illo, integer et sociis accumsan lectus. Mi ante at ligula pretium, eu porta molestie quibusdam consequat sed turpis, lorem est. Felis vivamus sapien porttitor, wisi lacinia praesent mi voluptatem quisque, quis litora arcu totam, commodo quam, eros penatibus. Ac dolor dignissim, quis wisi, sed et, dolor aenean in accumsan facilisi amet, sollicitudin erat fermentum id eu. Tortor nibh ornare mauris vestibulum integer nunc, commodo pellentesque, vehicula faucibus mi et lorem vel scelerisque, ante rutrum at vestibulum nascetur ipsum. Quis molestie ullamcorper dolor augue, dui ultricies morbi, auctor aenean in nec sed accumsan. Sem tempor aliquam morbi ante nunc cumque, pharetra arcu nulla ligula nulla, at facilisis. Metus sit dictum.",
                    10.0, "Hourly",
                    startDate,
                    endDate, mEmployer);
            dummyJobs.add(a);
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }

        for(int i = 0; i < 10; i++){
            int x = i + 2;
            String title = "Title " + Integer.toString(x);
            String text = "Text " + Integer.toString(x);
            double wage = (double) x;
            try{
                dummyJobs.add(new Job(title, text, wage, "Hourly", startDate, endDate, mEmployer));
            } catch(Exception e){
                Log.e(TAG, e.getMessage());
            }
        }

        return dummyJobs;
    }

    public List<Job> createAppliedDummyCards() {
        List<Job> dummyJobs = new ArrayList<>();
        Date startDate = new GregorianCalendar(2017, Calendar.JANUARY, 1).getTime();
        Date endDate = new GregorianCalendar(2017, Calendar.JANUARY, 2).getTime();

        try{
            Job a = new Job("Title 1",
                    "Lorem ipsum dolor sit amet, mauris vivamus dictumst faucibus vel felis arcu, morbi amet litora non sed, suscipit nulla nascetur metus in, a tincidunt montes nunc. Tempor lacus facilisis blandit suscipit phasellus magna, id velit nunc feugiat ipsum hymenaeos mattis, nec in pellentesque sollicitudin. Nec ut pharetra quis sit, in vitae, sit vestibulum condimentum, integer interdum consequat leo, ac fusce nec adipiscing placerat venenatis. Elit quam diam lectus arcu quam eu, arcu condimentum eget fringilla sed, urna et eget, interdum nec nullam. Eget illo, integer et sociis accumsan lectus. Mi ante at ligula pretium, eu porta molestie quibusdam consequat sed turpis, lorem est. Felis vivamus sapien porttitor, wisi lacinia praesent mi voluptatem quisque, quis litora arcu totam, commodo quam, eros penatibus. Ac dolor dignissim, quis wisi, sed et, dolor aenean in accumsan facilisi amet, sollicitudin erat fermentum id eu. Tortor nibh ornare mauris vestibulum integer nunc, commodo pellentesque, vehicula faucibus mi et lorem vel scelerisque, ante rutrum at vestibulum nascetur ipsum. Quis molestie ullamcorper dolor augue, dui ultricies morbi, auctor aenean in nec sed accumsan. Sem tempor aliquam morbi ante nunc cumque, pharetra arcu nulla ligula nulla, at facilisis. Metus sit dictum.",
                    10.0, "Hourly",
                    startDate,
                    endDate, mEmployer);
            dummyJobs.add(a);
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }

        for(int i = 0; i < 2; i++){
            int x = i + 2;
            String title = "Title " + Integer.toString(x);
            String text = "Text " + Integer.toString(x);
            double wage = (double) x;
            try{
                dummyJobs.add(new Job(title, text, wage, "Hourly", startDate, endDate, mEmployer));
            } catch(Exception e){
                Log.e(TAG, e.getMessage());
            }
        }

        return dummyJobs;
    }

    public List<Job> createOfferedDummyCards() {
        List<Job> dummyJobs = new ArrayList<>();
        Date startDate = new GregorianCalendar(2017, Calendar.JANUARY, 1).getTime();
        Date endDate = new GregorianCalendar(2017, Calendar.JANUARY, 2).getTime();

        try{
            Job a = new Job("Title 1",
                    "Lorem ipsum dolor sit amet, mauris vivamus dictumst faucibus vel felis arcu, morbi amet litora non sed, suscipit nulla nascetur metus in, a tincidunt montes nunc. Tempor lacus facilisis blandit suscipit phasellus magna, id velit nunc feugiat ipsum hymenaeos mattis, nec in pellentesque sollicitudin. Nec ut pharetra quis sit, in vitae, sit vestibulum condimentum, integer interdum consequat leo, ac fusce nec adipiscing placerat venenatis. Elit quam diam lectus arcu quam eu, arcu condimentum eget fringilla sed, urna et eget, interdum nec nullam. Eget illo, integer et sociis accumsan lectus. Mi ante at ligula pretium, eu porta molestie quibusdam consequat sed turpis, lorem est. Felis vivamus sapien porttitor, wisi lacinia praesent mi voluptatem quisque, quis litora arcu totam, commodo quam, eros penatibus. Ac dolor dignissim, quis wisi, sed et, dolor aenean in accumsan facilisi amet, sollicitudin erat fermentum id eu. Tortor nibh ornare mauris vestibulum integer nunc, commodo pellentesque, vehicula faucibus mi et lorem vel scelerisque, ante rutrum at vestibulum nascetur ipsum. Quis molestie ullamcorper dolor augue, dui ultricies morbi, auctor aenean in nec sed accumsan. Sem tempor aliquam morbi ante nunc cumque, pharetra arcu nulla ligula nulla, at facilisis. Metus sit dictum.",
                    10.0, "Hourly",
                    startDate,
                    endDate, mEmployer);
            dummyJobs.add(a);
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }

        return dummyJobs;
    }

    @Override
    public void run() {
        // TODO: Implement this with your business logic
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                List<Job> cardsList = new ArrayList<>();
                if(mType == CardUtil.CardType.SAVED){
                    cardsList = createSavedDummyCards();
                }
                else if (mType == CardUtil.CardType.APPLIED){
                    cardsList = createAppliedDummyCards();
                } else if (mType == CardUtil.CardType.OFFERED){
                    cardsList = createOfferedDummyCards();
                }
                mCallback.onCardsRetrieved(cardsList);
            }
        });
    }
}