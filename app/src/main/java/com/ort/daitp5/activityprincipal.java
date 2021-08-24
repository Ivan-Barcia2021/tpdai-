package com.ort.daitp5;

import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class activityprincipal extends AppCompatActivity {
    FragmentManager administrador;
    FragmentTransaction Transacciones;

    String ciudadingresada_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_actividadprincipal);

      fragent miingreso;
        miingreso= new fragent ();
        administrador=getFragmentManager ();
        Transacciones=administrador.beginTransaction ();
        Transacciones.replace (R.id.alojador, miingreso);

        Transacciones.commit ();
    }
    public void recibirdatos(String ciudad){
        ciudadingresada_=ciudad;
        fragentmostrar mostrar = new fragentmostrar ();
        Transacciones=administrador.beginTransaction ();
        Transacciones.replace (R.id.alojador, mostrar);
        Transacciones.commit ();
    }
    public String verciudad(){
        return ciudadingresada_;
    }
}