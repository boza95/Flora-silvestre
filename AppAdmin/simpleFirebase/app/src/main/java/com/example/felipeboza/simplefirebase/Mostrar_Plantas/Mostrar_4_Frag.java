package com.example.felipeboza.simplefirebase.Mostrar_Plantas;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.felipeboza.simplefirebase.Globales;
import com.example.felipeboza.simplefirebase.R;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.microedition.khronos.opengles.GL;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mostrar_4_Frag extends Fragment {


    View UI;
    ImageView imageViewPlanta;

    public Mostrar_4_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        UI = inflater.inflate(R.layout.frag_mostrar_4, container, false);

        // Se inicializan los elementos del fragment
        imageViewPlanta = UI.findViewById(R.id.imgVplantaMs);

        // Si la variable de imagen no esta vacia

        if (Globales.comprobarCadenaVacia(Globales.getPlanta_actual().getImagenPlanta())){

            // Se convierte la imagen de string a bitmap
            imageViewPlanta.setImageBitmap(Globales.StringToBitmap(Globales.getPlanta_actual().getImagenPlanta()));

        }

        return UI;

    }

}
