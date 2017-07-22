package com.camvy.kai.iddsignin;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kai on 2017-07-16.
 */

class PoxyServer {

    private static Retrofit getRetrofitConnection(){
        return (new Retrofit.Builder()
                .baseUrl("http://soulcast.ml")
                .addConverterFactory(GsonConverterFactory.create())
                .build());
    }

    public static void authenticate(String token , Callback<Boolean> completion){
        // prepare call in Retrofit 2.0
        SoulpostAPI soulpostAPI = getRetrofitConnection().create(SoulpostAPI.class);


    }
}
