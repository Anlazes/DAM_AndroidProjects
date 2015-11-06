package com.example.toni.p01_splash_image;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    //se establece el tiempo para el retardo en 3 segundos (3000 ms)
    private long SPLASH_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //uso de la libreria Ion para cargar un gif en la Splash Screen
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        Ion.with(image).load("http://oasisfm.cl/oasisfm/imag/master/iconoCargando.gif");

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
