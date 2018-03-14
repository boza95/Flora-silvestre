package com.example.felipeboza.simplefirebase.Registrar_Plantas;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.felipeboza.simplefirebase.Globales;
import com.example.felipeboza.simplefirebase.LoadActivity;
import com.example.felipeboza.simplefirebase.MainActivity;
import com.example.felipeboza.simplefirebase.Planta;
import com.example.felipeboza.simplefirebase.R;

public class Registrar_Plantas extends AppCompatActivity {

    ViewPager vpPagerRegPs; // Objeto pager
    Pager_Adapter_Registrar_Plantas pagerAdapterRegPs; // Adaptador del objeto pager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_plantas);

        // Se inicializan los elementos
        vpPagerRegPs = findViewById(R.id.vpPagerR);
        pagerAdapterRegPs = new Pager_Adapter_Registrar_Plantas(getSupportFragmentManager(),4);
        vpPagerRegPs.setAdapter(pagerAdapterRegPs);
    }

    @Override
    public void onBackPressed() { // Si se retrocede

        Globales.setPlanta_actual(new Planta()); // Se inicializa la variable

        // Se llama nuevamente a la ventana de cargar informacion de la base de datos
        Registrar_Plantas.this.startActivity(new Intent(Registrar_Plantas.this, LoadActivity.class));

        // Se cierra la ventana actual
        this.finish();

        super.onBackPressed();
    }

}
