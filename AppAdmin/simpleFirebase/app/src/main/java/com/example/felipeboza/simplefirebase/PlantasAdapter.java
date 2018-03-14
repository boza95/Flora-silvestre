package com.example.felipeboza.simplefirebase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.felipeboza.simplefirebase.Modificar_Plantas.Modificar_Plantas;
import com.example.felipeboza.simplefirebase.Mostrar_Plantas.Mostrar_Plantas;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Felipe Boza on 02/12/2017.
 */

public class PlantasAdapter extends ArrayAdapter<Planta> {

    private Context context; // Objeto que identifica la ventana donde esta el list view
    private ArrayList<Planta> datos = null;
    private ArrayList<Planta> plantaArrayList;

    /**
     * Constructor del Adapter.
     *
     * @param context
     *            context de la Activity que hace uso del Adapter.
     * @param datos
     *            Datos que se desean visualizar en el ListView.
     */
    public PlantasAdapter(Context context, ArrayList<Planta> datos) {
        super(context, R.layout.item_planta, datos);

        // Guardamos los parámetros en variables de clase.
        this.context = context;
        this.datos = datos; // Lista de plantas de la base de datos
        this.plantaArrayList = new ArrayList<>(); // Lista de respaldo de la lista de plantas de la base de datos
        this.plantaArrayList.addAll(datos);

    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        // En primer lugar "inflamos" una nueva vista, que será la que se
        // mostrará en la celda del ListView.
        View item = LayoutInflater.from(context).inflate(
                R.layout.item_planta, null); // Diseño del archivo item_planta.xml

        // A partir de la vista, recogeremos los controles que contiene para
        // poder manipularlos.
        // Recogemos el ImageView y le asignamos una foto.
        ImageView imagen = (ImageView) item.findViewById(R.id.imgPlanta);

        if(datos.get(position).getImagenPlanta().isEmpty()) { // Si el valor de la variable es vacio

            imagen.setImageResource(R.drawable.nodisponible); // Se asigna una fotografia por defecto

        }

        else { // Si no

            // entonces se convierte el string de esa variable a formato bitmap
            Bitmap bitmap = Globales.StringToBitmap(datos.get(position).getImagenPlanta());
            imagen.setImageBitmap(bitmap); // Se agrega al listview
        }



        // Recogemos el TextView para mostrar el nombre y establecemos el
        // nombre.
        TextView nombreComun = (TextView) item.findViewById(R.id.tvNombreComun);
        nombreComun.setText(datos.get(position).getNombreComun());

        // Recogemos el TextView para mostrar los usos y lo
        // establecemos.
        TextView usos = (TextView) item.findViewById(R.id.tvUsos);
        usos.setText(datos.get(position).getUsos());

        // Se iniacializan los image view de modificar y eliminar plantas
        ImageView imageViewEditarPlanta = item.findViewById(R.id.imgVeditarPlanta);
        ImageView imageViewEliminarPlanta = item.findViewById(R.id.imgVeliminarPlanta);

        // Este metodo permite abrir una vista detallada de los atributos de cada planta

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Globales.setPlanta_actual(datos.get(position)); // Se coloca la planta elegida en una variable global

                // Se respalda la lista de plantas
                datos = new ArrayList<>();
                datos.addAll(Globales.getPlantas());

                // Se llama a la ventana de mostrar informacion
                context.startActivity(new Intent(context, Mostrar_Plantas.class));
                // Se finaliza la ventana actual
                ((Activity) context).finish();

            }
        });

        // Este metodo permite modificar los atributos de una planta especifica

        imageViewEditarPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Se informa al usuario

                Toast.makeText(context, R.string.mensaje_toast_modificar_plantas,
                        Toast.LENGTH_LONG).show();

                Globales.setPlanta_actual(datos.get(position)); // Se coloca la planta elegida en una variable global

                // Se llama a la ventana de modificar informacion
                context.startActivity(new Intent(context, Modificar_Plantas.class));
                // Se finaliza la ventana actual
                ((Activity) context).finish();

            }
        });

        imageViewEliminarPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Se establece la comunicacion con la base de datos
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(Globales.getRutaFirebase());

                // Se elimina el elemento de la base
                myRef.child(datos.get(position).getId()).removeValue();

                // Se reduce el numero de elementos en la variable
                Globales.setNumeroRegistros(Globales.getNumeroRegistros()-1);

                // Se llama nuevamente a la ventana de cargar informacion de la base de datos
                context.startActivity(new Intent(context, LoadActivity.class));

                // Se informa al usuario
                Toast.makeText(context, R.string.mensaje_toast_eliminar_plantas,
                        Toast.LENGTH_LONG).show();

                // Se finaliza la ventana actual
                ((Activity) context).finish();


            }
        });

        // Devolvemos la vista para que se muestre en el ListView.
        return item;
    }

    /*

        Este metodo permite filtrar el contenido del list view, por medio del texto escrito en
        el search view

     */

    public void filtro_por_search_View(String charText){

        charText = charText.toLowerCase(Locale.getDefault());
        datos.clear();

        if(charText.equals("")) { // Si no hay nada escrito


            datos.addAll(plantaArrayList); // Entonces se muestran todos los elementos


        }

        else {

            // Si hay algo escrito entonces se agregan al listview

            for(Planta planta : plantaArrayList){

                // los elementos que coincidan

                if(planta.getNombreComun().toLowerCase(Locale.getDefault()).contains(charText)){

                    datos.add(planta);

                }

            }

        }

        notifyDataSetChanged();

    }

    /*

        Este metodo permite filtrar el contenido del list view, por medio de la opcion seleccionada en el
        spinner

     */

    public void filtro_por_spinner(String charText){

        charText = charText.toLowerCase(Locale.getDefault());
        datos.clear();

        if(charText.equals("")) { // Si no hay ninguna opcion seleccionada


            datos.addAll(plantaArrayList); // entonces se muestran todos los elementos


        }

        else {

            // Si se selecciona una opcion

            for(Planta planta : plantaArrayList){

                // se muestran los elementos que coincidan con esa opcion

                if(planta.getFamilia().toLowerCase(Locale.getDefault()).contains(charText)){

                    datos.add(planta);

                }

            }

        }

        notifyDataSetChanged();

    }

}
