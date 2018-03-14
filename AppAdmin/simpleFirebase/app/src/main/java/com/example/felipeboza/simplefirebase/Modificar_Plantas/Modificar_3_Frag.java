package com.example.felipeboza.simplefirebase.Modificar_Plantas;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
public class Modificar_3_Frag extends Fragment {


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

    // Genoma 1 // Metaboloma = 2

    int imageViewSeleccionado; // Indica el imageview utilizado


    public Modificar_3_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        UI = inflater.inflate(R.layout.frag_modificar_3, container, false);

        // Se inicializan los controles de la interfaz

        editTextProductor = this.UI.findViewById(R.id.edTextProductorM);
        editTextLatitud = this.UI.findViewById(R.id.edTextCGlatitudM);
        editTextLongitud = this.UI.findViewById(R.id.edTextCGlongitudM);

        imageViewGenoma = this.UI.findViewById(R.id.imgVgenomaM);
        imageViewMetaboloma = this.UI.findViewById(R.id.imgVmetabolomaM);

        // Se agrega en cada edit text el texto que contenga cada atributo de la variable global

        editTextProductor.setText(Globales.getPlanta_actual().getProductor());
        editTextLatitud.setText(Globales.getPlanta_actual().getLatitud());
        editTextLongitud.setText(Globales.getPlanta_actual().getLongitud());

        // Si las variables de imagen no esta vacias

        if (Globales.comprobarCadenaVacia(Globales.getPlanta_actual().getImagenGenoma())){// Si no esta vacia

            // Se convierte la imagen de string a bitmap
            imageViewGenoma.setImageBitmap(Globales.StringToBitmap(Globales.getPlanta_actual().getImagenGenoma()));

        }

        if (Globales.comprobarCadenaVacia(Globales.getPlanta_actual().getImagenMetaboloma())){// Si no esta vacia

            // Se convierte la imagen de string a bitmap
            imageViewMetaboloma.setImageBitmap(Globales.StringToBitmap(Globales.getPlanta_actual().getImagenMetaboloma()));

        }

        obtenerDatos();

        // Metodo para ejecutar al hacer click sobre cualquier image view

        imageViewGenoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageViewSeleccionado = 1;
                abrirGaleria();


            }
        });

        imageViewMetaboloma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageViewSeleccionado = 2;
                abrirGaleria();

            }
        });

        return UI;

    }

    // Este metodo obtiene y almacena en cada atributo de la variable global, el texto digitado en cada edit text

    private void obtenerDatos() {

        //----------------------------------------------------------------------------------------//

        editTextProductor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setProductor(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextLatitud.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setLatitud(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //----------------------------------------------------------------------------------------//

        editTextLongitud.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Globales.getPlanta_actual().setLongitud(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    // Este metodo permite abrir la galeria y cargar una imagen en memoria

    public void abrirGaleria() {

        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);

        startActivityForResult(intent, Globales.getSelectPicture());

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == Globales.getSelectPicture()) {

            if (data != null) {

                Uri selectedImage = data.getData();
                InputStream is;
                try {

                    // Se abre la galeria

                    is = getActivity().getContentResolver().openInputStream(selectedImage);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    Bitmap bitmap = BitmapFactory.decodeStream(bis);

                    // Se convierte la imagen cargada a formato string

                    String imagen = Globales.BitmapToString(bitmap);

                    if (imageViewSeleccionado == 1) {// Si el valor es 1,

                        // Entonces la imagen se coloca el imageview genoma

                        imageViewGenoma.setImageBitmap(bitmap);
                        // Y se guarda en su respectiva variable
                        Globales.getPlanta_actual().setImagenGenoma(imagen);

                    } else {// Si no

                        // Entonces la imagen se coloca el imageview metaboloma

                        imageViewMetaboloma.setImageBitmap(bitmap);
                        // Y se guarda en su respectiva variable
                        Globales.getPlanta_actual().setImagenMetaboloma(imagen);
                    }

                } catch (FileNotFoundException e) {
                }
            }
        }

    }
}
