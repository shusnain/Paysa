package com.example.android.paysa.domain.interactors;

import com.example.android.paysa.domain.interactors.base.Interactor;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public interface LoginInteractor extends Interactor {

    interface LoginCallback {
        // TODO: Add interactor callback methods here
        void loginSuccess();

        void loginFail();
    }

    // TODO: Add interactor methods here
    boolean doInBackGround();
}

