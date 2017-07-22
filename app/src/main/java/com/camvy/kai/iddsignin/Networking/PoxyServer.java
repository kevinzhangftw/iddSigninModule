package com.camvy.kai.iddsignin.Networking;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.*;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kai on 2017-07-21.
 */

public class PoxyServer {
    private static Retrofit getRetrofitConnection(){
        return (new Retrofit.Builder()
                .baseUrl("http://soulcast.ml")
                .addConverterFactory(GsonConverterFactory.create())
                .build());
    }

    public static void authenticate(Badge userbadge){
        // prepare call in Retrofit 2.0
        PoxyAPI poxyAPI = getRetrofitConnection().create(PoxyAPI.class);
        Call<Badge> call = poxyAPI.authenticate(userbadge);
        call.enqueue(new Callback<Badge>() {
            @Override
            public void onResponse(Call<Badge> call, Response<Badge> response) {
                if (response.isSuccessful()){
                    Log.d("Response Success", new Gson().toJson(response.body()));
                }else {
                    Log.d("Response Err Code",new Gson().toJson(response));
                }
            }

            @Override
            public void onFailure(Call<Badge> call, Throwable t) {

            }
        });



    }
}
