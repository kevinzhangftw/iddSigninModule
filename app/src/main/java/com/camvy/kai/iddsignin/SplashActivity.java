package com.camvy.kai.iddsignin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.camvy.kai.iddsignin.Networking.AuthCallback;
import com.camvy.kai.iddsignin.Networking.Badge;
import com.camvy.kai.iddsignin.Networking.PoxyServer;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.findViewById(android.R.id.content).setBackgroundColor(Color.BLACK);

        authenticateToken();

    }

    private void authenticateToken() {
        if (!isNetworkConnected()) {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show();
        }

        //DEBUG
//        Badge newbadge = new Badge(123, "samplesesstoken");
//        UserState.setBadge(newbadge, this);

        Badge userBadge = UserState.getBadge(this);
        if (userBadge == null) {
            //TODO: show welcome message...
            Log.v("user state", "token is null");
            //direct to signup activity
        }
//        Log.v("user state", userBadge.getSession_token());

        PoxyServer.authenticate(userBadge, new AuthCallback() {
            @Override
            public void completion(boolean bool) {
                if (bool){
                    Intent parklistIntent = new Intent(getBaseContext(), ParkListActivity.class);
                    startActivity(parklistIntent);
                }else {
                    Intent signinIntent = new Intent(getBaseContext(), SigninActivity.class);
                    startActivity(signinIntent);
                }
            }
        });

//        PoxyServer.authenticate(userBadge) {
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
