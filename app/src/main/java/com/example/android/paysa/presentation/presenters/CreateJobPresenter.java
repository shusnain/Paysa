package com.example.android.paysa.presentation.presenters;

import com.example.android.paysa.presentation.presenters.base.BasePresenter;
import com.example.android.paysa.presentation.ui.BaseView;

/**
 * Created by S_Husnain on 2017-10-11.
 */

public interface CreateJobPresenter extends BasePresenter {
    interface CreateJobView extends BaseView{

    }

    String getStartDate();

    String getStartTime();

    String getEndDate();

    String getEndTime();

    String formatDate(int year, int month, int day);

    String formatTime(int hour, int min);

    String[] getWageTime();
}
