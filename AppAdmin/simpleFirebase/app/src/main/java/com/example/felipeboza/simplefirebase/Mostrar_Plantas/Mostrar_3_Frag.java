package com.example.felipeboza.simplefirebase.Mostrar_Plantas;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.felipeboza.simplefirebase.Globales;
import com.example.felipeboza.simplefirebase.R;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mostrar_3_Frag extends Fragment {


    View UI;

    // Edit text del fragment

    EditText editTextProductor;

    // Coordenadas Geograficas

    EditText editTextLatitud;
    EditText editTextLongitud;

    // Imageview del fragment

    // Imagenes del genoma y el metaboloma

    ImageView imageViewGenoma;
    ImageView imageViewMetaboloma;

    public Mostrar_3_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        UI = inflater.inflate(R.layout.frag_mostrar_3, container, false);

        // Se inicializan los controles de la interfaz

        editTextProductor = this.UI.findViewById(R.id.edTextProductorMs);
        editTextLatitud = this.UI.findViewById(R.id.edTextCGlatitudMs);
        editTextLongitud = this.UI.findViewById(R.id.edTextCGlongitudMs);

        imageViewGenoma = this.UI.findViewById(R.id.imgVgenomaMs);
        imageViewMetaboloma = this.UI.findViewById(R.id.imgVmetabolomaMs);

        // Se agrega en cada edit text el texto que contenga cada atributo de la variable global

        editTextProductor.setText(Globales.getPlanta_actual().getProductor());
        editTextLatitud.setText(Globales.getPlanta_actual().getLatitud());
        editTextLongitud.setText(Globales.getPlanta_actual().getLongitud());

        // Si las variables de imagen no esta vacias

        if (Globales.comprobarCadenaVacia(Globales.getPlanta_actual().getImagenGenoma())){ // Si no esta vacia

            // Se convierte la imagen de string a bitmap
            imageViewGenoma.setImageBitmap(Globales.StringToBitmap(Globales.getPlanta_actual().getImagenGenoma()));

        }

        if (Globales.comprobarCadenaVacia(Globales.getPlanta_actual().getImagenMetaboloma())){ // Si no esta vacia

            // Se convierte la imagen de string a bitmap
            imageViewMetaboloma.setImageBitmap(Globales.StringToBitmap(Globales.getPlanta_actual().getImagenMetaboloma()));

        }


        return UI;

    }


}
