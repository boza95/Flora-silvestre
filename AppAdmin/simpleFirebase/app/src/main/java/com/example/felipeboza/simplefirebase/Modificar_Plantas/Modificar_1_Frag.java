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
public class Modificar_1_Frag extends Fragment {


    View UI;

    // Edit text del fragment

    EditText editTextID;
    EditText editTextNombreCientifico;
    EditText editTextNombreComun;
    EditText editTextFamilia;
    EditText editTextGenero;

    public Modificar_1_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.UI = inflater.inflate(R.layout.frag_modificar_1, container, false);

        // Se inicializan los edit text

        editTextID = this.UI.findViewById(R.id.edTextIdM);
        editTextNombreCientifico = this.UI.findViewById(R.id.edTextNombreCientificoM);
        editTextNombreComun = this.UI.findViewById(R.id.edTextNombreComúnM);
        editTextFamilia = this.UI.findViewById(R.id.edTextFamiliaM);
        editTextGenero = this.UI.findViewById(R.id.edTextGéneroM);

        // Se agrega en cada edit text el texto que contenga cada atributo de la variable global

        editTextID.setText(Globales.getPlanta_actual().getId());
        editTextNombreCientifico.setText(Globales.getPlanta_actual().getNombreCientifico());
        editTextNombreComun.setText(Globales.getPlanta_actual().getNombreComun());
        editTextFamilia.setText(Globales.getPlanta_actual().getFamilia());
        editTextGenero.setText(Globales.getPlanta_actual().getGenero());

        obtenerDatos();

        return this.UI;

    }

    // Este metodo obtiene y almacena en cada atributo de la variable global, el texto digitado en cada edit text

    private void obtenerDatos() {

        //----------------------------------------------------------------------------------------//

        editTextID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setId(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextNombreCientifico.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setNombreCientifico(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextNombreComun.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setNombreComun(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextFamilia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setFamilia(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextGenero.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setGenero(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//
    }


}
