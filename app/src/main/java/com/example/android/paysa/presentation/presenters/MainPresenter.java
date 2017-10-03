package com.example.android.paysa.presentation.presenters;

import com.example.android.paysa.domain.models.Job;
import com.example.android.paysa.presentation.presenters.base.BasePresenter;
import com.example.android.paysa.presentation.ui.BaseView;

import java.util.List;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        // TODO: Add your view methods
        public void setCards(List<Job> jobs);
    }

    // TODO: Add your presenter methods
    void getCards();
}
