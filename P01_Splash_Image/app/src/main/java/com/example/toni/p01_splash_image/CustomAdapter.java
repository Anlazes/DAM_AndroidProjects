package com.example.toni.p01_splash_image;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/*
Clase para crear un adapter personalizado que recoja un array de string para los
textos que se incluirán en el ListView y un array de integer con los id de las imagenes que
irán junto a cada texto
 */
public class CustomAdapter extends ArrayAdapter {

    private final Context context;
    private final String[] nombres;
    private final Integer[] iconos;

    //constructor de la clase donde pasamos el activity context y los arrays de string e integer
    public CustomAdapter(Activity context, String[] nombres, Integer[] iconos) {
        super(context, R.layout.lista_layout, nombres);

        this.context=context;
        this.nombres=nombres;
        this.iconos=iconos;
    }

    //creamos una view con el layout lista que incluye un texto y una imagen
    public View getView(int posicion,View view, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.lista_layout, parent, false);

        //creamos un TextView e ImageView con los id del layout
        TextView txtTitle = (TextView) view.findViewById(R.id.texto_principal);
        ImageView imageView = (ImageView) view.findViewById(R.id.icono);

        //indicamos que se rellenen los views con la posicion del array que corresponda
        txtTitle.setText(nombres[posicion]);
        imageView.setImageResource(iconos[posicion]);

        return view;
    }

}
