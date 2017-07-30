package com.camvy.kai.iddsignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.camvy.kai.iddsignin.Networking.AuthCallback;
import com.camvy.kai.iddsignin.Networking.Badge;
import com.camvy.kai.iddsignin.Networking.PoxyServer;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent splashIntent = new Intent(this, SplashActivity.class);
//        startActivity(splashIntent);

        //DEBUG
        Intent signinIntent = new Intent(getBaseContext(), SigninActivity.class);
        startActivity(signinIntent);
    }
}
