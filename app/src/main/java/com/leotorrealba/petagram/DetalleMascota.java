package com.leotorrealba.petagram;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class DetalleMascota extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_mascota);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        listaMascotas = (RecyclerView) findViewById(R.id.rvPerrosTop);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        Bundle parametros = getIntent().getExtras();

        inicilizarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);

    }

    public void inicilizarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Rocky",R.drawable.dog1,4));
        mascotas.add(new Mascota("Fifi",R.drawable.dog2,8));
        mascotas.add(new Mascota("Snoopy",R.drawable.dog5,10));
        mascotas.add(new Mascota("Pluto",R.drawable.dog6,17));
        mascotas.add(new Mascota("Scooby Doo",R.drawable.dog7,5));

    }

}
