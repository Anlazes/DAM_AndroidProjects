package com.example.toni.p03_math;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity implements StaticFragment.StaticFragmentListener {

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

            // Añade el fragment a el FrameLayout
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, mainFragment).
                    addToBackStack(null).commit();

        }


    }

    public void onListSelected(int position) {


        switch (position) {
            case 0:
                Toast.makeText(this, "No implementado", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                //Checkamos si estamos en un dispositivo grande o no
                if (findViewById(R.id.fragment_container) != null) {
                    // Crea un nuevo Fragment para poner en la Activity
                    JuegoFragment jFrag = new JuegoFragment();
                    // Cargamos el fragment
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, jFrag).
                            addToBackStack(null).commit();

                }else{ //Dispositivo pequeño
                    Intent mainIntent = new Intent(this, JuegoActivity.class);
                    startActivity(mainIntent);
                }
                Toast.makeText(this, "Juego en construcción", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "No implementado", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "No implementado", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
