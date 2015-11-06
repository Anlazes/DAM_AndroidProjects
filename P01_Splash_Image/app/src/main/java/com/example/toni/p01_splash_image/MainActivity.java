package com.example.toni.p01_splash_image;

import android.app.Activity;
import android.os.Bundle;

import android.widget.ListView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se generan arrays de string e integer con los nombres y los iconos
        final String[] listaNombres = new String[]{"PERFIL", "JUGAR", "INSTRUCCIONES", "INFO"};
        final Integer[] listaIconos = new Integer[]{R.drawable.ic_face_black_24dp, R.drawable.ic_play_circle_outline_black_24dp,
                R.drawable.ic_library_books_black_24dp, R.drawable.ic_info_black_24dp};

        ListView lista;

        //creamos el adapter personalizado con los arrays creados
        CustomAdapter adapter = new CustomAdapter(this, listaNombres, listaIconos);
        lista = (ListView) findViewById(R.id.listview);
        lista.setAdapter(adapter);

    }
}