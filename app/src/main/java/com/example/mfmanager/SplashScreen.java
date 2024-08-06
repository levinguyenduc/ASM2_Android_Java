package com.example.mfmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    // Static field for setting the delay
    private static final long DELAY = 3000;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // Initialize SharedPreferences in advance
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                // Check if login is enabled
                boolean loginEnabled = prefs.getBoolean(LoginActivity.ENABLE_LOGIN, true);

                // Start the appropriate activity
                if(loginEnabled){
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                } else {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                }
                finish();
            }
        }, DELAY);
    }
}
