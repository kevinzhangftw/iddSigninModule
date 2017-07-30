package com.camvy.kai.iddsignin.Networking;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kai on 2017-07-30.
 */

public class LoginCred {
    @SerializedName("email") private String email;
    @SerializedName("password") private String password;

    public LoginCred(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
