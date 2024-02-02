package com.example.calculadoraprogramacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbh= findViewById(R.id.tbhConversor);

        tbh.setup();
        tbh.addTab(tbh.newTabSpec("LON").setContent(R.id.tab1Longitud).setIndicator("LONGITUD", null));
        tbh.addTab(tbh.newTabSpec("ALM").setContent(R.id.tab1Longitud).setIndicator("ALMACENAMIENTO", null));
        tbh.addTab(tbh.newTabSpec("MON").setContent(R.id.tab1Longitud).setIndicator("MONEDAS", null));
    }
}