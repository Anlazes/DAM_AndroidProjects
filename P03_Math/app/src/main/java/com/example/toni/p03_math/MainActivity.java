package com.example.toni.p03_math;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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


            /*
            // En el caso de que la Activity comience con instrucciones especiales
            // de un Intent, pasa los extras del Intent al fragment como argumentos
            mainFragment.setArguments(getIntent().getExtras());
            */

            // Añade el fragment a el FrameLayout
            getFragmentManager().beginTransaction().add(R.id.fragment_container, mainFragment).commit();

        }
            Bundle bundle = getIntent().getExtras();
            String nombre = bundle.getString("nombre");
            String edad = bundle.getString("edad");

            Log.i("Nombre:", nombre);
            Log.i("Edad:", edad);

            PerfilFragment pFrag = new PerfilFragment();
            getFragmentManager().beginTransaction().add(R.id.detailFragment, pFrag).commit(); //carga el fragment

    }

    public void onListSelected(int position) {

        JuegoFragment jFrag = new JuegoFragment();
        PerfilFragment pFrag = new PerfilFragment();
        switch (position) {
            case 0:
                getFragmentManager().beginTransaction().replace(R.id.detailFragment, pFrag).commit();
                break;
            case 1:
                getFragmentManager().beginTransaction().replace(R.id.detailFragment, jFrag).commit();
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
