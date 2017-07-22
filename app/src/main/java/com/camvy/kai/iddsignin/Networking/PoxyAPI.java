package com.camvy.kai.iddsignin.Networking;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by kai on 2017-07-21.
 */

public interface PoxyAPI {

    @Headers("Accept: application/json")
    @POST("/authenticate")
    Call<Badge> authenticate(@Body Badge userBadge);



}
