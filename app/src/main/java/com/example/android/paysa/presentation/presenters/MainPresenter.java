package com.example.android.paysa.presentation.presenters;

import android.content.Context;

import com.example.android.paysa.presentation.presenters.base.BasePresenter;
import com.example.android.paysa.presentation.ui.BaseView;

/**
 * Created by S_Husnain on 2017-10-24.
 */

public interface MainPresenter extends BasePresenter {
    interface MainView extends BaseView{

    }

    boolean isLoggedIn(Context context);
}
