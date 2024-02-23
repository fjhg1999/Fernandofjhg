package com.example.calculadoraprogramacion2;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
public final class MainActivity extends AppCompatActivity {
    SensorManager SensorManager;
    Sensor sensor;
    private SensorEventListener _sensorEvenListener;
    TextView tempVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempVal = findViewById(R.id.lblSensorDeAproximidad);
        activarSensorDeLuz();
    }
    private void activarSensorDeLuz() {
        SensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = SensorManager.getDefaultSensor(sensor.TYPE_PROXIMITY);
        if (sensor == null) {
            tempVal.setText("tu dispositivo no cuenta con el sensor acelerometro");
            finish();
        }
        _sensorEvenListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                double valor= event.values[0];
                tempVal.setText("Proximidad"+ valor);
                if (valor<=20){
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                } else if (valor<=50){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                } else if (valor>50) {
                    getWindow().getDecorView().setBackgroundColor(Color.CYAN);

                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {};
        };
    }
    @Override
    public void onResume(){
        iniciar();
        super.onResume();
    }
    @Override
    public void onPause(){
        detener();
        super.onPause();
    }
    private void iniciar(){
        SensorManager.registerListener(_sensorEvenListener, sensor, 2000*1000);
    }
    private void detener(){
        SensorManager.unregisterListener(_sensorEvenListener);
    }
}