package com.project.hoangminh.famcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    private long sec = 0;
    private long splashTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timeThread = new Thread() {
            @Override
            public void run() {
                try {
                    while(sec < splashTime) {
                        sec += 100;
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch(Exception e) {}
                finally {
                    Intent intent = new Intent(Splash.this, Login.class);
                    startActivity(intent);
                }
            }
        };
        timeThread.start();
    }
}
