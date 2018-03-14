package com.example.felipeboza.simplefirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LoadActivity extends AppCompatActivity {

    ProgressDialog pd; // Dialogo de progreso
    MiTareaAsincronaDialog tarea; // Tarea asincrona

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        // Se inicializa la lista global de las plantas

        ArrayList<Planta> plantas = new ArrayList<>();
        Globales.setPlantas(plantas);

        // Se inicializa la lista global de las familias de las plantas

        ArrayList<String> familias = new ArrayList<>();
        familias.add("");
        Globales.setPlantasFamilias(familias);

        // Se copian los registros de la base de datos web
        copiar_Registros();

        // Se inicializa el dialogo de proceso
        pd = new ProgressDialog(this);
        pd.setTitle(R.string.titulo_progress_dialog_1);

        pd.setMessage(this.getString(R.string.mensaje_progress_dialog_2));

        // Se inicializa la tarea asincrona
        tarea = new LoadActivity.MiTareaAsincronaDialog();
        tarea.execute();
    }

    /*
        Este metodo se encarga de copiar los registros de la base de datos web a memoria

    */

    private void copiar_Registros() {

        // Se inicializan los objetos de la base de datos

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(Globales.getRutaFirebase());

        // Se establece la comunicacion con la base de datos web

        myRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {

                // Se copia cada registro de la base de datos web a variables globales

                Planta planta = dataSnapshot.getValue(Planta.class); // Objeto de tipo planta
                Globales.plantas.add(planta); // Lista global de plantas

                // Se comprueba si la familia ya fue agregada a la lista
                if(Globales.comprobarElementoEnLista(planta.getFamilia())) {

                    Globales.plantasFamilias.add(planta.getFamilia()); // Lista global de familias de plantas

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

    /* La tarea asincrona se asegura que se copiaran los registros de la base de datos web a memoria.
    */

    private class MiTareaAsincronaDialog extends AsyncTask<String, Float, Integer> {

        @Override
        protected Integer doInBackground(String ... ms) {

            // Se ejecuta mientras el numero de registros web sea diferente al numero de registros en la lista global

            while (Globales.getNumeroRegistros() != Globales.getPlantas().size()) {

                try {

                    Thread.sleep((long) (Math.random() * 10.0d));

                } catch (InterruptedException e) {

                    cancel(true);

                    e.printStackTrace();

                }
                publishProgress(new Float[0]);
            }

            return Integer.valueOf(81);

        }

        @Override
        protected void onProgressUpdate(Float ... values) {

            pd.show(); // Se muestre el dialogo de progreso

        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(Integer ms ) {// Una vez que se terminan de copiar los registros

            pd.dismiss(); // Se quita el dialogo de progreso

            // Se informa al usuario

            Toast.makeText(getApplicationContext(), R.string.mensaje_toast_2_exito, Toast.LENGTH_SHORT).show();

            // Se llama a la siguiente ventana
            LoadActivity.this.startActivity(new Intent(LoadActivity.this, MainActivity.class));

            // Se cierra esta ventana
            LoadActivity.this.finish();
        }

        protected void onCancelled(Integer cantidadProcesados) {

            Toast.makeText(getApplicationContext(), R.string.mensaje_toast_1_error, Toast.LENGTH_SHORT).show();
            LoadActivity.this.finish();
        }
    }
}
