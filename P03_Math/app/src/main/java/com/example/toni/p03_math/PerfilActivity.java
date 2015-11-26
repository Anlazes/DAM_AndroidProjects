package com.example.toni.p03_math;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PerfilActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_perfil);


        final EditText nom = (EditText) findViewById(R.id.edit_nom);
        final EditText edad = (EditText) findViewById(R.id.edit_edad);


        //Se crea boton para recoger en variables el texto de los editText y añadirlos
        //al intent que abrirá el MainActivity
        Button boton = (Button) findViewById(R.id.bot_jugar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("nombre", nom.getText().toString());
                intent.putExtra("edad", edad.getText().toString());
                startActivity(intent);
                finish();

            }
        });
    }

}
