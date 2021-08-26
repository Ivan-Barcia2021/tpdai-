package com.ort.daitp5;

import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
public class activityprincipal extends AppCompatActivity {
    FragmentManager administrador;
    FragmentTransaction Transacciones;
    private  fragent miingreso;
private fragentmostrar mostrar;
    String ciudadingresada_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_actividadprincipal);


        miingreso= new fragent ();
        administrador=getFragmentManager ();
        Transacciones=administrador.beginTransaction ();
        Transacciones.replace (R.id.alojador, miingreso);

        Transacciones.commit ();
        tareaAsincronica mitarea= new tareaAsincronica ();
        mitarea.execute ();
    }
private  class  tareaAsincronica extends AsyncTask<Void, Void, Void>{
        @Override
    protected Void doInBackground(Void...voids){
            try {
                URL miruta= new URL ("api.openweathermap.org/data/2.5/weather?q={ciudadingresada_}&appid={77b12ce172b1421a452d89a59564754c}");
                HttpURLConnection miconexion =(HttpURLConnection) miruta.openConnection ();
                if(miconexion.getResponseCode ()==200){
                    InputStream cuerporespuesta= miconexion.getInputStream ();
                    InputStreamReader lector= new InputStreamReader (cuerporespuesta, "UTF-8");
                    procesarJson(lector);
                }

            }
           catch (Exception error){

           }
            return  null;
        }
}

    public void recibirdatos(String ciudad){
        ciudadingresada_=ciudad;
         mostrar = new fragentmostrar ();
        Transacciones=administrador.beginTransaction ();
        Transacciones.replace (R.id.alojador, mostrar);
        Transacciones.commit ();
    }
    public String verciudad(){
        return ciudadingresada_;
    }
}