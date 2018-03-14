package com.example.felipeboza.simplefirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SplashActivity extends AppCompatActivity {

    private ProgressDialog pd = null; // Dialogo de progreso
    private MiTareaAsincronaDialog tarea; // Tarea asincrona

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comprobar_Numero_Registros_Web(); // Se obtiene el numero de registros en la base de datos web

        // Se inicializa el dialogo de progreso

        pd = new ProgressDialog(this);

        pd.setTitle(R.string.titulo_progress_dialog_1);
        pd.setMessage(this.getResources().getString(R.string.mensaje_progress_dialog_1));

        // Se ejecuta la tarea asincrona

        tarea = new MiTareaAsincronaDialog();
        tarea.execute();

    }

    /*

        Este metodo se encarga de obtener el numero de registros en la base de datos web

     */

    private void comprobar_Numero_Registros_Web()
    {
        // Se inicializan los objetos de la base de datos

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(Globales.getRutaFirebase());

        // Se realiza la comunicacion con la base de datos

        myRef.addValueEventListener(new ValueEventListener()
        {

            public void onDataChange(DataSnapshot paramAnonymousDataSnapshot)
            {
                Globales.setNumeroRegistros(paramAnonymousDataSnapshot.getChildrenCount()); // Se obtiene el numero de registros y se
                                                                                      // almacena en una variable global.
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    /* La tarea asincrona se asegura que se obtendra el numero de registros
        de la base de datos web.
    */

    private class MiTareaAsincronaDialog extends AsyncTask<String, Float, Integer> {

        @Override
        protected Integer doInBackground(String ... ms) {

            // Se ejecuta mientras el valor de la variable sea igual a -1

            while (Globales.getNumeroRegistros() == -1) { // Cuando el valor de la variable sea distinto a -1,
                // entonces se detendrá la tarea asincrona

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


            pd.show(); // Se muestra el dialogo de progreso


        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(Integer ms ) { // Una vez que se obtiene el numero de registros

            pd.dismiss(); // Se quita el dialogo de progreso

            // Se informa al usuario

            Toast.makeText(getApplicationContext(), R.string.mensaje_toast_1_exito, Toast.LENGTH_SHORT).show();

            // Se llama a la siguiente ventana

            SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoadActivity.class));

            // Se cierra esta ventana
            SplashActivity.this.finish();
    }

    protected void onCancelled(Integer cantidadProcesados) {

        Toast.makeText(getApplicationContext(), R.string.mensaje_toast_1_error, Toast.LENGTH_SHORT).show();
        SplashActivity.this.finish();
    }
}


}
