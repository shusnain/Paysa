package com.example.android.paysa.presentation.presenters.impl;

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.interactors.LoginInteractor;
import com.example.android.paysa.domain.interactors.impl.LoginInteractorImpl;
import com.example.android.paysa.presentation.presenters.LoginPresenter;
import com.example.android.paysa.presentation.presenters.base.AbstractPresenter;

/**
 * Created by S_Husnain on 2017-10-23.
 */

public class LoginPresenterImpl extends AbstractPresenter implements LoginPresenter, LoginInteractor.LoginCallback {

    private LoginView mView;

    public LoginPresenterImpl(Executor executor,
                              MainThread mainThread,
                              LoginView view){
        super(executor, mainThread);
        mView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public boolean isEmailValid(String email) {
        return email.contains("@");
    }

    @Override
    public boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    @Override
    public void loginSuccess() {
        mView.loginSuccess();
    }

    @Override
    public void loginFail() {
        mView.loginFail();
    }

    @Override
    public void tryLogin(String email, String password) {
        LoginInteractor loginInteractor = new LoginInteractorImpl(mExecutor, mMainThread, this, null, email, password);
        loginInteractor.execute();
    }
}
