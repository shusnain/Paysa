package com.example.android.paysa.domain.interactors.impl;

/**
 * Created by S_Husnain on 2017-09-30.
 */

import com.example.android.paysa.domain.executors.Executor;
import com.example.android.paysa.domain.executors.MainThread;
import com.example.android.paysa.domain.interactors.LoginInteractor;
import com.example.android.paysa.domain.interactors.SampleInteractor;
import com.example.android.paysa.domain.interactors.base.AbstractInteractor;
import com.example.android.paysa.domain.repository.Repository;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 *
 */
public class LoginInteractorImpl extends AbstractInteractor implements LoginInteractor {

    private LoginCallback mCallback;
    private Repository mRepository;
    private String mEmail;
    private String mPassword;

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    public LoginInteractorImpl(Executor threadExecutor,
                               MainThread mainThread,
                               LoginCallback callback,
                               Repository repository,
                               String email,
                               String password) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mRepository = repository;
        mEmail = email;
        mPassword = password;
    }

    @Override
    public void run() {
        // TODO: Implement this with your business logic
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                boolean ret = doInBackGround();
                if(ret){
                    mCallback.loginSuccess();
                }else{
                    mCallback.loginFail();
                }
            }
        });
    }

    @Override
    public boolean doInBackGround() {
        // TODO: attempt authentication against a network service.

        try {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return false;
        }

        for (String credential : DUMMY_CREDENTIALS) {
            String[] pieces = credential.split(":");
            if (pieces[0].equals(mEmail)) {
                // Account exists, return true if the password matches.
                return pieces[1].equals(mPassword);
            }
        }

        // TODO: register the new account here.
        return true;
    }
}