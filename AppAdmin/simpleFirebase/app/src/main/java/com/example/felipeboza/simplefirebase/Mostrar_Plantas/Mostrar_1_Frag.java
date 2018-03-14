package com.example.felipeboza.simplefirebase.Mostrar_Plantas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.felipeboza.simplefirebase.Globales;
import com.example.felipeboza.simplefirebase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mostrar_1_Frag extends Fragment {


    View UI;

    // Edit text del fragment

    EditText editTextID;
    EditText editTextNombreCientifico;
    EditText editTextNombreComun;
    EditText editTextFamilia;
    EditText editTextGenero;

    public Mostrar_1_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.UI = inflater.inflate(R.layout.frag_mostrar_1, container, false);

        // Se inicializan los edit text

        editTextID = this.UI.findViewById(R.id.edTextIdMs);
        editTextNombreCientifico = this.UI.findViewById(R.id.edTextNombreCientificoMs);
        editTextNombreComun = this.UI.findViewById(R.id.edTextNombreComúnMs);
        editTextFamilia = this.UI.findViewById(R.id.edTextFamiliaMs);
        editTextGenero = this.UI.findViewById(R.id.edTextGéneroMs);

        // Se agrega en cada edit text el texto que contenga cada atributo de la variable global

        editTextID.setText(Globales.getPlanta_actual().getId());
        editTextNombreCientifico.setText(Globales.getPlanta_actual().getNombreCientifico());
        editTextNombreComun.setText(Globales.getPlanta_actual().getNombreComun());
        editTextFamilia.setText(Globales.getPlanta_actual().getFamilia());
        editTextGenero.setText(Globales.getPlanta_actual().getGenero());


        return this.UI;

    }


}
