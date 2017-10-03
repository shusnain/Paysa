package com.example.android.paysa.domain.models;

/**
 * Created by S_Husnain on 2017-09-30.
 */

public class Seeker {

   private String mSeekerId;

    private String mLastName;

    private String mFirstName;

    private String mMiddleName;

    private String mLocation;

    private String mPhoneNumber;

    public Seeker(String seekerId, String firstName, String middleName, String lastName, String location, String phoneNumber) {
        mSeekerId = seekerId;
        mFirstName = firstName;
        mMiddleName = middleName;
        mLastName = lastName;
        mLocation = location;
        mPhoneNumber = phoneNumber;
    }

    public Seeker(String seekerId, String firstName, String lastName, String location, String phoneNumber) {
        mSeekerId = seekerId;
        mFirstName = firstName;
        mMiddleName = "";
        mLastName = lastName;
        mLocation = location;
        mPhoneNumber = phoneNumber;
    }

    public String getSeekerId() { return mSeekerId; }

    public String getFirstName(){ return mFirstName; }

    public String getMiddleName(){ return mMiddleName; }

    public String getLastName(){ return mLastName; }

    public String getFullName() {
        if(mMiddleName == ""){
            return mFirstName + " " + mLastName;
        } else{
            return mFirstName + " " + mMiddleName + " " + mLastName;
        }
    }

    public String getLocation(){ return mLocation; }

    public String getPhoneNumber(){ return mPhoneNumber; }
}
