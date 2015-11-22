package com.example.toni.p03_math;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        // Comprueba si se está usando el Activity con el FrameLayout
        // fragment_container para usar versión móvil o tablet
        if (findViewById(R.id.fragment_container) != null) {

            // Si está siendo restaurado de un estado anterior
            // no hace nada y pasa al return, sino se
            // podrían solapar fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Crea un nuevo Fragment para poner en la Activity
            StaticFragment mainFragment = new StaticFragment();

            /*
            // En el caso de que la Activity comience con instrucciones especiales
            // de un Intent, pasa los extras del Intent al fragment como argumentos
            mainFragment.setArguments(getIntent().getExtras());
            */

            // Añade el fragment a el FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, mainFragment).commit();
        }

    }
}
