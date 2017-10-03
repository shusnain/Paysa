package com.example.android.paysa.domain.interactors;

import com.example.android.paysa.domain.interactors.base.Interactor;
import com.example.android.paysa.domain.models.Job;

import java.util.List;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public interface GetCardsInteractor extends Interactor {

    interface Callback {
        // TODO: Add interactor callback methods here
        void onCardsRetrieved(List<Job> cardsList);
    }

    // TODO: Add interactor methods here
}

