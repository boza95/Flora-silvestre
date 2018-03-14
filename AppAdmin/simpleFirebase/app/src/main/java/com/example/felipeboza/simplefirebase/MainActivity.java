package com.example.felipeboza.simplefirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.felipeboza.simplefirebase.Registrar_Plantas.Registrar_Plantas;
import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private ListView lvPlantas; // Objeto listview
    private PlantasAdapter adapterPlantas; // Objeto adapter

    SearchView editsearch; // Objeto search view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this); // Se inicializa el contexto de firebase

        // Se inicializan los objetos

        lvPlantas = findViewById(R.id.lvItems);
        editsearch = findViewById(R.id.simpleSearchView);

        editsearch.setOnQueryTextListener(this);

        setToolbar(); // Se agrega la barra de herramientas

        // Se inicializa el adaptador personalizado

        adapterPlantas = new PlantasAdapter(this, Globales.getPlantas());

        // Se inicializa el objeto listview

        lvPlantas = (ListView) findViewById(R.id.lvItems);
        lvPlantas.setAdapter(null);
        lvPlantas.setAdapter(adapterPlantas);

    }

    // Este metodo se encarga de llamar a la ventana para registrar plantas

    private void llamar_Ventana_Reg_Plantas() {

        // Se llama a la ventana para registrar plantas
        MainActivity.this.startActivity(new Intent(MainActivity.this, Registrar_Plantas.class));

        // Se informa al usuario
        Toast.makeText(getApplicationContext(),R.string.mensaje_toast_agregar_plantas, Toast.LENGTH_SHORT).show();

        // Se cierra esta ventana
        this.finish();

    }

    /*
        Este metodo agrega la barra de herramientas
     */

    private void setToolbar() {

        // Se añade la barra de herramientas
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PHM");
    }

    /*
        Este metodo agrega las opciones de menu a la barra de herramientas

     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        // Se inicializa el objeto spinner

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) item.getActionView();

        // Se agregan las familias de las plantas al objeto spinner

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, Globales.getPlantasFamilias());

        spinner.setAdapter(adapter);

        // Metodo para obtener el elemento seleccionado en el spinner

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                adapterPlantas.filtro_por_spinner(Globales.getPlantasFamilias().get(i)); // Metodo que filtra los elementos del listview por el elemento seleccionado en el spinner
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.accion_agregar:
                llamar_Ventana_Reg_Plantas();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onBackPressed() {

        Globales.setNumeroRegistros(-1); // Se inicializa el numero de registros
        finish();

        super.onBackPressed();
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        adapterPlantas.filtro_por_search_View(s); // Metodo que filtra el listview por el texto escrito en el search view
        return false;

    }
}
