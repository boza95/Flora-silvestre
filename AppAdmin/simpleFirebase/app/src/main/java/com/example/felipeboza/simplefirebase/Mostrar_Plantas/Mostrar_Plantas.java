package com.example.felipeboza.simplefirebase.Mostrar_Plantas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.felipeboza.simplefirebase.Globales;
import com.example.felipeboza.simplefirebase.LoadActivity;
import com.example.felipeboza.simplefirebase.MainActivity;
import com.example.felipeboza.simplefirebase.Planta;
import com.example.felipeboza.simplefirebase.R;

public class Mostrar_Plantas extends AppCompatActivity {

    ViewPager vpPagerMosPs;// Objeto pager
    Pager_Adapter_Mostrar_Plantas pagerAdapterMosPs;// Adaptador del objeto pager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_plantas);

        // Se inicializan los elementos
        vpPagerMosPs = findViewById(R.id.vpPagerMs);
        pagerAdapterMosPs = new Pager_Adapter_Mostrar_Plantas(getSupportFragmentManager(),4);
        vpPagerMosPs.setAdapter(pagerAdapterMosPs);
    }

    @Override
    public void onBackPressed() {// Si se retrocede

        Globales.setPlanta_actual(new Planta());// Se inicializa la variable

        // Se llama nuevamente a la ventana de cargar informacion de la base de datos

        Mostrar_Plantas.this.startActivity(new Intent(Mostrar_Plantas.this, LoadActivity.class));

        this.finish();// Se cierra la ventana actual

        super.onBackPressed();
    }
}
