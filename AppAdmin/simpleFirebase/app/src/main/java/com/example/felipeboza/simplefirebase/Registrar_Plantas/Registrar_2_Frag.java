package com.example.felipeboza.simplefirebase.Registrar_Plantas;


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
public class Registrar_2_Frag extends Fragment {

    View UI;

    // Edit text del fragment

    EditText editTextEspecie;
    EditText editTextClasificador;
    EditText editTextTipo;
    EditText editTextDistrito;
    EditText editTextUsos;

    public Registrar_2_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.UI = inflater.inflate(R.layout.frag_registrar_2, container, false);

        // Se inicializan los edit text

        editTextEspecie = this.UI.findViewById(R.id.edTextEspecieR);
        editTextClasificador = this.UI.findViewById(R.id.edTextClasificadorR);
        editTextTipo = this.UI.findViewById(R.id.edTextTipoR);
        editTextDistrito = this.UI.findViewById(R.id.edTextDistritoR);
        editTextUsos = this.UI.findViewById(R.id.edTextUsosR);

        // Se agrega en cada edit text el texto que contenga cada atributo de la variable global

        editTextEspecie.setText(Globales.getPlanta_actual().getEspecie());
        editTextClasificador.setText(Globales.getPlanta_actual().getClasificador());
        editTextTipo.setText(Globales.getPlanta_actual().getTipo());
        editTextDistrito.setText(Globales.getPlanta_actual().getDistrito());
        editTextUsos.setText(Globales.getPlanta_actual().getUsos());

        // Se almacena en cada atributo de la variable global el texto que contenga cada edit text

        Globales.getPlanta_actual().setEspecie(editTextEspecie.getText().toString());
        Globales.getPlanta_actual().setClasificador(editTextClasificador.getText().toString());
        Globales.getPlanta_actual().setTipo(editTextTipo.getText().toString());
        Globales.getPlanta_actual().setDistrito(editTextDistrito.getText().toString());
        Globales.getPlanta_actual().setUsos(editTextUsos.getText().toString());

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
