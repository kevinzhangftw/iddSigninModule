package com.camvy.kai.iddsignin.Networking;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kai on 2017-07-22.
 */

public class Badge {
    @SerializedName("user_id") private int user_id;
    @SerializedName("session_token") private String session_token;

    public Badge(int user_id, String session_token) {
        this.user_id = user_id;
        this.session_token = session_token;
    }

    public int getUser_id() {
        return user_id;
    }
    public String getSession_token() {
        return session_token;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setSession_token(String session_token) {
        this.session_token = session_token;
    }
}

