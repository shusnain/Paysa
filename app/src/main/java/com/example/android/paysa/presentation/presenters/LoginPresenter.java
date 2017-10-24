package com.example.android.paysa.presentation.presenters;

import com.example.android.paysa.presentation.presenters.base.BasePresenter;
import com.example.android.paysa.presentation.ui.BaseView;

/**
 * Created by S_Husnain on 2017-10-23.
 */

public interface LoginPresenter extends BasePresenter {
    interface LoginView extends BaseView{
        void resetErrors();

        void loginFail();

        void loginSuccess();
    }

    boolean isEmailValid(String email);

    boolean isPasswordValid(String password);

    void tryLogin(String email, String password);

}
