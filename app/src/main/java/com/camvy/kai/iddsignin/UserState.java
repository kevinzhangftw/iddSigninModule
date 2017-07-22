package com.camvy.kai.iddsignin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by kai on 2017-07-16.
 * Stores user memory, token, user id, park, a
 * anything app has to remember
 * cache store fore token
 */

public class UserState {
    private static String tokenKey = "UserStateSampleTokenKey";

    //returns a string if saved, null otherwise.
    public static String getToken(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString(UserState.tokenKey, null);
    }

    public static void setToken(String tokenString, Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor e = pref.edit();
        e.putString(tokenKey, tokenString);
        e.commit();
    }
}
