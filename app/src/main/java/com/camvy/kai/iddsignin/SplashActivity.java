package com.camvy.kai.iddsignin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // remove notifiation bar
        setContentView(R.layout.activity_splash);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.findViewById(android.R.id.content).setBackgroundColor(Color.BLACK);

        authenticateToken();

    }

    private void authenticateToken() {
        if (!isNetworkConnected()) {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show();
        }
        String token = UserState.getToken(this);
        if (token == null) {
            //TODO: show welcome message...
            Log.v("user state", "token is null");
            //direct to signup activity
        }

//        PoxyServer.authenticate(token) {
//            Intent pushIntent;
//            if (success) {
//                //success -> make intent for parkList activity
//                Activity listAct = ParkListActivity();
//                pushIntent = Intent(push, parkList activity)
//            } else {
//                //fail -> make intent for login/signup acitivity...
//
//            }
//            //finally, startActivity(intent)...
//        }
    }

    private boolean isNetworkConnected() {
//        return false;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
