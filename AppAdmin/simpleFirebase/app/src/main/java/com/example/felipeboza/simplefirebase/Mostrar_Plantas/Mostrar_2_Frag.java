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
public class Mostrar_2_Frag extends Fragment {


    View UI;

    // Edit text del fragment

    EditText editTextEspecie;
    EditText editTextClasificador;
    EditText editTextTipo;
    EditText editTextDistrito;
    EditText editTextUsos;

    public Mostrar_2_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.UI = inflater.inflate(R.layout.frag_mostrar_2, container, false);

        // Se inicializan los edit text

        editTextEspecie = this.UI.findViewById(R.id.edTextEspecieMs);
        editTextClasificador = this.UI.findViewById(R.id.edTextClasificadorMs);
        editTextTipo = this.UI.findViewById(R.id.edTextTipoMs);
        editTextDistrito = this.UI.findViewById(R.id.edTextDistritoMs);
        editTextUsos = this.UI.findViewById(R.id.edTextUsosMs);

        // Se agrega en cada edit text el texto que contenga cada atributo de la variable global

        editTextEspecie.setText(Globales.getPlanta_actual().getEspecie());
        editTextClasificador.setText(Globales.getPlanta_actual().getClasificador());
        editTextTipo.setText(Globales.getPlanta_actual().getTipo());
        editTextDistrito.setText(Globales.getPlanta_actual().getDistrito());
        editTextUsos.setText(Globales.getPlanta_actual().getUsos());


        return this.UI;
    }


}
