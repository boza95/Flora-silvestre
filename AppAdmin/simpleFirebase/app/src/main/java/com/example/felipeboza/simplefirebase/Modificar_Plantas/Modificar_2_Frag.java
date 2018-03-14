package com.example.felipeboza.simplefirebase.Modificar_Plantas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.felipeboza.simplefirebase.Globales;
import com.example.felipeboza.simplefirebase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Modificar_2_Frag extends Fragment {


    View UI;

    // Edit text del fragment

    EditText editTextEspecie;
    EditText editTextClasificador;
    EditText editTextTipo;
    EditText editTextDistrito;
    EditText editTextUsos;

    public Modificar_2_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.UI = inflater.inflate(R.layout.frag_modificar_2, container, false);

        // Se inicializan los edit text

        editTextEspecie = this.UI.findViewById(R.id.edTextEspecieM);
        editTextClasificador = this.UI.findViewById(R.id.edTextClasificadorM);
        editTextTipo = this.UI.findViewById(R.id.edTextTipoM);
        editTextDistrito = this.UI.findViewById(R.id.edTextDistritoM);
        editTextUsos = this.UI.findViewById(R.id.edTextUsosM);

        // Se agrega en cada edit text el texto que contenga cada atributo de la variable global

        editTextEspecie.setText(Globales.getPlanta_actual().getEspecie());
        editTextClasificador.setText(Globales.getPlanta_actual().getClasificador());
        editTextTipo.setText(Globales.getPlanta_actual().getTipo());
        editTextDistrito.setText(Globales.getPlanta_actual().getDistrito());
        editTextUsos.setText(Globales.getPlanta_actual().getUsos());

        obtenerDatos();

        return this.UI;
    }

    // Este metodo obtiene y almacena en cada atributo de la variable global, el texto digitado en cada edit text

    private void obtenerDatos() {

        //----------------------------------------------------------------------------------------//

        editTextEspecie.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setEspecie(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextClasificador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setClasificador(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextTipo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setTipo(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextDistrito.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setDistrito(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextUsos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setUsos(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//
    }

}
