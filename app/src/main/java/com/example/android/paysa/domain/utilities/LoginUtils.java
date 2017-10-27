package com.example.android.paysa.domain.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.android.paysa.R;
import com.example.android.paysa.presentation.ui.activities.LoginActivity;

/**
 * Created by S_Husnain on 2017-10-24.
 */

public final class LoginUtils {

    public static void logout(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("shared_preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getString(R.string.saved_email), "");
        editor.putString(context.getString(R.string.saved_password), "");
        editor.putBoolean(context.getString(R.string.saved_is_logged_in), false);
        editor.commit();

        startLogin(context);

    }

    public static void startLogin(Context context){
        Intent startLoginActivity = new Intent(context, LoginActivity.class);
        startLoginActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startLoginActivity);
    }

    public static boolean isLoggedIn(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("shared_preferences",Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedPref.getBoolean(context.getString(R.string.saved_is_logged_in), false);
        String email = sharedPref.getString(context.getString(R.string.saved_email), "");
        String password = sharedPref.getString(context.getString(R.string.saved_password), "");

        return isLoggedIn && email != "" && password != "";
    }

    public static void setLogin(Context context, String email, String password){
        SharedPreferences sharedPref = context.getSharedPreferences("shared_preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getString(R.string.saved_email), email);
        editor.putString(context.getString(R.string.saved_password), password);
        editor.putBoolean(context.getString(R.string.saved_is_logged_in), true);
        editor.commit();
    }

    public static void setEmail(Context context, String email){
        SharedPreferences sharedPref = context.getSharedPreferences("shared_preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getString(R.string.saved_email), email);
        editor.commit();
    }

    public static void setPassword(Context context, String password){
        SharedPreferences sharedPref = context.getSharedPreferences("shared_preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getString(R.string.saved_password), password);
        editor.commit();
    }
}
