package com.example.felipeboza.simplefirebase.Modificar_Plantas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.felipeboza.simplefirebase.Globales;
import com.example.felipeboza.simplefirebase.LoadActivity;
import com.example.felipeboza.simplefirebase.MainActivity;
import com.example.felipeboza.simplefirebase.Planta;
import com.example.felipeboza.simplefirebase.R;

public class Modificar_Plantas extends AppCompatActivity {

    ViewPager vpPagerModPs;// Objeto pager
    Pager_Adapter_Modificar_Plantas pagerAdapterModPs;// Adaptador del objeto pager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_plantas);

        // Se inicializan los elementos
        vpPagerModPs = findViewById(R.id.vpPagerM);
        pagerAdapterModPs = new Pager_Adapter_Modificar_Plantas(getSupportFragmentManager(),4);
        vpPagerModPs.setAdapter(pagerAdapterModPs);
    }

    @Override
    public void onBackPressed() {// Si se retrocede

        Globales.setPlanta_actual(new Planta());// Se inicializa la variable

        // Se llama nuevamente a la ventana de cargar informacion de la base de datos

        Modificar_Plantas.this.startActivity(new Intent(Modificar_Plantas.this, LoadActivity.class));

        this.finish();// Se cierra la ventana actual

        super.onBackPressed();
    }

}
