package com.example.calculadoraprogramacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class lista_amigos extends AppCompatActivity {
FloatingActionButton btnAgregarAmigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_amigos);

        btnAgregarAmigos= findViewById(R.id.fabAgregarAmigos);
        btnAgregarAmigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActividad();

            }
        });
    }
    private void abrirActividad(){
        Intent abrirActicidad= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(abrirActicidad);
    }

}