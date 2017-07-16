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
    private static String tokenKey = "UserStateToken";

    //returns a string if saved, null otherwise.
    public static String getToken(Context ctx){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        return pref.getString(UserState.tokenKey, null);
    }

    public static void setToken(String token, Context ctx){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor e = pref.edit();
        e.putString(tokenKey, token);
        e.commit();
    }
}
