package com.example.toni.actividad_1f;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    private WebView navegador;
    private EditText url;
    private Button boton;
    private ProgressBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se asigna a la variable navegador la view Webview
        navegador = (WebView) findViewById(R.id.webkit);

        //se habilita el zoom y javascript
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.getSettings().setBuiltInZoomControls(true);


        navegador.setWebViewClient(new WebViewClient() {
            // evita que los enlaces se abran fuera de nuestra app en el navegador de android
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            //gestión de errores
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(description).setPositiveButton("Aceptar", null).setTitle("onReceivedError");
                builder.show();
            }

        });

        //se asigna el view progressbar a la variable barra
        barra = (ProgressBar) findViewById(R.id.progressbar);

       navegador.setWebChromeClient(new WebChromeClient() {
           @Override

           //metodo para usar una barra de progreso ya así saber si el navegador responde o no
           public void onProgressChanged(WebView view, int progress) {
               barra.setProgress(0);
               barra.setVisibility(View.VISIBLE);
               MainActivity.this.setProgress(progress * 1000);

               barra.incrementProgressBy(progress);

               //en cuanto la barra llegue al 100% desaparecerá
               if (progress == 100) {
                  barra.setVisibility(View.GONE);
               }
           }
       });

        //sea asigna a la variable url la view edittext
        url = (EditText) findViewById(R.id.url);
        url.setText("http://");

    }

    //método para usar el boton ir
    public void ir(View view)
    {
            boton = (Button)findViewById(R.id.buttonIr);
            boton.setEnabled(true);
            navegador.loadUrl(url.getText().toString());
    }

}


