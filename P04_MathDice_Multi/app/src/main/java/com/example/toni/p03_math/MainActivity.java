package com.example.toni.p03_math;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity implements StaticFragment.StaticFragmentListener, PerfilFragment.PerfilFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        // Comprueba si se está usando el Activity con el FrameLayout
        // fragment_container para usar versión móvil o tablet
        if (findViewById(R.id.fragment_container) != null) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

            // Crea un nuevo Fragment para poner en la Activity
            StaticFragment mainFragment = new StaticFragment();

            // Añade el fragment
            getFragmentManager().beginTransaction().add(R.id.listFragment, mainFragment)
                    .commit();

            // Cargamos el fragment de perfil en el fragment dinámico
            PerfilFragment pFrag = new PerfilFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, pFrag).commit();

        } else {
            StaticFragment mainFragment = new StaticFragment();
            getFragmentManager().beginTransaction().replace(R.id.single_frag, mainFragment).commit();
        }

    }

    public void onListSelected(int position) {


        switch (position) {
            case 0:
                //Checkamos si estamos en un dispositivo grande o no
                if (findViewById(R.id.fragment_container) != null) {
                    // Crea un nuevo Fragment para poner en la Activity
                    PerfilFragment pFrag = new PerfilFragment();
                    // Cargamos el fragment
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, pFrag).commit();

                }else{ //Dispositivo pequeño
                    Intent mainIntent = new Intent(this, PerfilActivity.class);
                    startActivity(mainIntent);
                }
                Toast.makeText(this, "En construcción", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                //Checkamos si estamos en un dispositivo grande o no
                if (findViewById(R.id.fragment_container) != null) {
                    // Crea un nuevo Fragment para poner en la Activity
                    JuegoFragment jFrag = new JuegoFragment();
                    // Cargamos el fragment
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, jFrag).commit();

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


    @Override
    public void onClick(View v) {

    }
}
