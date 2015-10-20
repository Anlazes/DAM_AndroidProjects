package com.example.toni.p01_splash_image;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    private long SPLASH_DELAY = 3000; //3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //llamada a la MainActivity
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
                //destruimos la activity para no poder volver a ella pulsando atrás
                finish();
            }
        };

        //se crea un objeto Timer y se ejecuta el metodo schedule pasándole el tiempo guardado en
        //la variable long
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);

    }
}
