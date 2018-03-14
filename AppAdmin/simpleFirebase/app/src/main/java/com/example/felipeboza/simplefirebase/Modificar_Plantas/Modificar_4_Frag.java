package com.example.felipeboza.simplefirebase.Modificar_Plantas;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.felipeboza.simplefirebase.Globales;
import com.example.felipeboza.simplefirebase.LoadActivity;
import com.example.felipeboza.simplefirebase.Planta;
import com.example.felipeboza.simplefirebase.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * A simple {@link Fragment} subclass.
 */
public class Modificar_4_Frag extends Fragment {


    View UI;
    ImageView imageViewPlanta;
    Button buttonModificarPlanta;

    public Modificar_4_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        UI = inflater.inflate(R.layout.frag_modificar_4, container, false);

        // Se inicializan los elementos del fragmen
        imageViewPlanta = UI.findViewById(R.id.imgVplantaM);
        buttonModificarPlanta = UI.findViewById(R.id.btnModificarPlanta);

        // Si la variable de imagen no esta vacia

        if (Globales.comprobarCadenaVacia(Globales.getPlanta_actual().getImagenPlanta())) {

            // Se convierte la imagen de string a bitmap
            imageViewPlanta.setImageBitmap(Globales.StringToBitmap(Globales.getPlanta_actual().getImagenPlanta()));

        }

        // Metodo para modificar la informacion en la base de datos

        buttonModificarPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mensaje = "";

                if (Globales.comprobarVariablesVacias()) { // Se comprueba que no existan campos vacios

                    // Se establece la comunicacion con la base de datos

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference(Globales.getRutaFirebase());

                    // Se modifica la informacion en la base de datos
                    myRef.child(Globales.getPlanta_actual().getId()).setValue(Globales.getPlanta_actual());
                    mensaje = getActivity().getString(R.string.mensaje_toast_modificar_plantas_exito);

                    Globales.setPlanta_actual(new Planta()); // Se inicializa la variable global

                    // Se llama nuevamente a la ventana de cargar informacion de la base de datos
                    getActivity().startActivity(new Intent(getActivity(), LoadActivity.class));
                    // Se cierra la ventana actual
                    getActivity().finish();

                } else {

                    mensaje = getActivity().getString(R.string.mensaje_toast_modificar_plantas_error);

                }

                // Se informa al usuario
                Toast.makeText(getActivity().getApplicationContext(),
                        mensaje, Toast.LENGTH_SHORT).show();

            }
        });

        // Metodo para ejecutar al hacer click sobre el image view
        imageViewPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                abrirGaleria();

            }
        });

        return UI;

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

                    // Entonces la imagen se coloca el imageview
                    imageViewPlanta.setImageBitmap(bitmap);

                    // Y se guarda en su respectiva variable
                    Globales.getPlanta_actual().setImagenPlanta(imagen);


                } catch (FileNotFoundException e) {
                }
            }
        }
    }
}