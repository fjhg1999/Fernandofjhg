package com.example.calculadoraprogramacion2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
public final class MainActivity extends AppCompatActivity {
    TextView tempVal;
    LocationManager locationManager;
    LocationListener locationListener;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempVal = findViewById(R.id.lblSensorGps);

    }
    private void obtenerPosicion(){
        try {


            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_BACKGROUND_LOCATION}, 1);
                tempVal.setText("solicitando permisos de localizacion...");
            }
            Location location = new Location(LocationManager.GPS_PROVIDER);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            mostrarPosicion(location);
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    mostrarPosicion(location);
                }
            };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
        }catch (Exception e){
            tempVal.setText(e.getMessage());
        }
    }private void mostrarPosicion(Location location){
        tempVal.setText("posicion; latitud:"+location.getLatitude() +"; longitud: "+location.getLongitude()+"; altitud; "+location.getAltitude());
    }
}