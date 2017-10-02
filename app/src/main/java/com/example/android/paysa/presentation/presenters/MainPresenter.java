package com.example.android.paysa.presentation.presenters;

import com.example.android.paysa.domain.models.Card;
import com.example.android.paysa.presentation.presenters.base.BasePresenter;
import com.example.android.paysa.presentation.ui.BaseView;

import java.util.List;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        // TODO: Add your view methods
        public void setCards(List<Card> cards);
    }

    // TODO: Add your presenter methods
    void getCards();
}
