package com.camvy.kai.iddsignin.Networking;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kai on 2017-07-22.
 */

public class Badge {
    @SerializedName("user_id") private int user_id;
    @SerializedName("session_token") private float session_token;

    public Badge(int user_id, float session_token) {
        this.user_id = user_id;
        this.session_token = session_token;
    }
}
