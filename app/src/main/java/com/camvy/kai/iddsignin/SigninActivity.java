package com.camvy.kai.iddsignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.camvy.kai.iddsignin.Networking.AuthCallback;
import com.camvy.kai.iddsignin.Networking.Badge;
import com.camvy.kai.iddsignin.Networking.BadgeCallback;
import com.camvy.kai.iddsignin.Networking.Cred;
import com.camvy.kai.iddsignin.Networking.LoginCred;
import com.camvy.kai.iddsignin.Networking.PoxyServer;

import junit.framework.Assert;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        //TODO: make GUI for register/login...
        registerWithServer(new Cred("lam@uncle.com", "12345678", "12345678"));
        logInWithServer(new LoginCred("lam@uncle.com", "12345678"));
    }

    private void logInWithServer(LoginCred cred) {
        PoxyServer.login(cred, new BadgeCallback() {
            @Override
            public void completion(boolean success, Badge badge) {
                if (!success) {
                    Toast.makeText(getBaseContext(),
                            "Login failed, please try again",
                            Toast.LENGTH_LONG).show(); return;
                }
                UserState.setBadge(badge, getBaseContext());
                beginAppEntry();
            }
        });
    }

    private void beginAppEntry() {
        Intent parklistIntent = new Intent(getBaseContext(), ParkListActivity.class);
        startActivity(parklistIntent);
    }

    private void registerWithServer(Cred cred) {
        PoxyServer.register(cred, new BadgeCallback() {
            @Override
            public void completion(boolean success, Badge badge) {
                if (!success) {
                    Toast.makeText(getBaseContext(),
                            "Sign up failed, please try again",
                            Toast.LENGTH_LONG).show(); return;
                }
                UserState.setBadge(badge, getBaseContext());
                beginAppEntry();
            }
        });
    }


}
