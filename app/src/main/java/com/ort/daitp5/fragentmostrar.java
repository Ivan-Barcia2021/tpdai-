package com.ort.daitp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragentmostrar extends Fragment {
    TextView textomostrar;
    public View onCreateView(LayoutInflater inflador, ViewGroup grupo, Bundle paquete){
        View vistadevolver;
        vistadevolver=inflador.inflate (R.layout.mostrar, grupo, false);
        textomostrar=vistadevolver.findViewById (R.id.ciudadelegida);
        activityprincipal miactivity;
        miactivity= (activityprincipal) getActivity();
        String nombreamostrar;
        nombreamostrar=miactivity.verciudad ();
        textomostrar.setText (nombreamostrar);
        return vistadevolver;
    }
}
